package main.java.interview;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class MemoryObject {
    public final String id;
    private final AtomicInteger referenceCount;

    MemoryObject(String id) {
        this.id = id;
        this.referenceCount = new AtomicInteger(0);
    }

    public String getId() {
        return id;
    }

    public int getReferenceCount() {
        return referenceCount.get();
    }

    public void incrementReference() {
        referenceCount.incrementAndGet();
    }

    public void decrementReference() {
        referenceCount.decrementAndGet();
    }

    @Override
    public String toString() {
        return "MemoryObject{" +
                "id='" + id + '\'' +
                ", referenceCount=" + getReferenceCount() +
                '}';
    }
}
class MemoryManager {
    // Implement the MemoryManager class here
    private final Map<String, MemoryObject> pool = new ConcurrentHashMap<>();

    public void createObject(String objectId) {
        pool.computeIfAbsent(objectId, MemoryObject::new);
    }


    /**
     1. Syncronized method (Locking all objects)
     2. Lock only object in the map
     1. synchronize the object
     2. Semaphores (map id -> semaphore (Lock))
     3. No locks at all (flip side)
     1. Key -> Operations
     * ABC -> [add, remove, etc]
     * DFG -> [add, add , remove]
     */

    public void addReference(String objectId) {
        pool.compute(objectId, (key, existing) -> {
            MemoryObject obj = existing == null ? new MemoryObject(key) : existing;
            obj.incrementReference();
            return obj;
        });
    }

    /**
     * removeReference(String objectId): Ensures an object with the objectId exists in the memory pool; if not, creates it. It then decrements its reference count, allowing for negative counts in a multithreaded environment to manage concurrent operations accurately.

     * @param objectId
     */

    public void removeReference(String objectId) {
        pool.compute(objectId, (key, existing) -> {
            MemoryObject obj = existing == null ? new MemoryObject(key) : existing;
            obj.decrementReference();
            return obj;
        });
    }


    /**
     garbageCollect(): Removes objects with zero or negative reference counts from the memory pool.
     */
    public void garbageCollect() {
        pool.entrySet().removeIf(entry -> entry.getValue().getReferenceCount() <= 0);
    }

    /*
    getMemoryPool(): Retrieves a list of MemoryObject instances from the memory pool, filtering out objects with negative reference counts to ensure consistency in a multithreaded environment. The objects are sorted alphabetically by their IDs before being returned. If there are more than 3 objects in the memory pool, garbage collection is triggered.
    */

    public List<MemoryObject> getMemoryPool() {
        // Write your code here
        List<MemoryObject> list = pool.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .filter(obj -> obj.getReferenceCount() > 0)
                .sorted(Comparator.comparing(MemoryObject::getId))
                .collect(Collectors.toList());

        if (pool.size() > 3) {
            garbageCollect();
        }

        return list;
    }
}


class CustomMemoryManager {
    private static BufferedWriter createWriter() throws IOException {
        String outputPath = System.getenv("OUTPUT_PATH");
        if (outputPath == null || outputPath.isBlank()) {
            // Local IDE runs usually do not set OUTPUT_PATH; write to stdout in that case.
            return new BufferedWriter(new OutputStreamWriter(System.out));
        }
        return new BufferedWriter(new FileWriter(outputPath));
    }

    public static void executeCommand(String command, MemoryManager memoryManager) {
        String[] commandParts = command.split(" ", 3);
        if (commandParts.length < 2) {
            return;
        }

        String action = commandParts[0];
        if (action.equals("addReference")) {
            String object = commandParts[1];
            memoryManager.addReference(object);
        } else if (action.equals("removeReference")) {
            String object = commandParts[1];
            memoryManager.removeReference(object);
        }
    }
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = createWriter();

        int commandsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> commands = new ArrayList<>();

        for (int i = 0; i < commandsCount; i++) {
            String commandsItem = bufferedReader.readLine();
            commands.add(commandsItem);
        }

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        List<Future<Void>> futures = new ArrayList<>();

        MemoryManager memoryManager = new MemoryManager();
        for (String command : commands) {
            Future<Void> future = threadPoolExecutor.submit(() -> {
                executeCommand(command, memoryManager);
                return null;
            });
            futures.add(future);
        }

        // Wait for all tasks to complete
        for (Future<Void> future : futures) {
            future.get();
        }
        threadPoolExecutor.shutdown();

        // Collect the memory pool state after all commands have been processed
        List<String> result = new ArrayList<>();
        for (MemoryObject memoryObject : memoryManager.getMemoryPool()) {
            result.add(memoryObject.toString());

        }

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}