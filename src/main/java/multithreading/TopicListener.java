package main.java.multithreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TopicListener<M, T> {
  private final ConcurrentMap<T, FutureMessage<M>> futureMessages =
      new ConcurrentHashMap<T, FutureMessage<M>>();

  public TopicListener() {}

  public void initListenerForTopic(T topic) {
    futureMessages.putIfAbsent(topic, new FutureMessage<M>());
  }

  public void publishMessage(T topic, M message) {
    FutureMessage<M> signaler = futureMessages.replace(topic, new FutureMessage<M>());
    signaler.setMessage(message);
  }

  public M waitNewMessage(T topic) {
    return futureMessages.get(topic).getMessage();
  }

  class FutureMessage<M> {
    private final Lock dataLock = new ReentrantLock();
    private final Condition dataReady = dataLock.newCondition();

    private volatile M message;

    public M getMessage() {
      dataLock.lock();
      try {
        while (this.message == null) {
          try {
            dataReady.await();
          } catch (InterruptedException e) {
            // Report or ignore...
          }
        }
      } finally {
        dataLock.unlock();
      }

      return this.message;
    }

    public void setMessage(M toPublish) {
      this.message = toPublish;

      dataLock.lock();
      try {
        dataReady.signalAll();
      } finally {
        dataLock.unlock();
      }
    }
  }
}
