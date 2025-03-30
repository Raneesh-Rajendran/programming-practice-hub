package main.java.miscellaneous;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateParser {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        int noOfDays = scanner.nextInt();
        for(int i=0; i < noOfDays; i++){
            int noOfSubjects = scanner.nextInt();
            Map<LocalTime, LocalTime> subjectTimeDetails = new TreeMap<>();
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("H:mm", Locale.US);
            scanner.nextLine();
            for(int j=0; j < noOfSubjects; j++){
                if(scanner.hasNextLine()){
                    String[] subDetails = scanner.nextLine().split(" ");
                    subjectTimeDetails.put(LocalTime.parse(subDetails[1], formatter), LocalTime.parse(subDetails[2], formatter));
                }
            }

            int count = 1;
            Map.Entry<LocalTime,LocalTime> entry= subjectTimeDetails.entrySet().iterator().next();
            Long lessMin = MINUTES.between(entry.getKey(), entry.getValue());
            LocalTime endTime = entry.getValue();

            for (Map.Entry<LocalTime, LocalTime> data: subjectTimeDetails.entrySet()) {
                if(MINUTES.between(data.getKey(), data.getValue()) < lessMin){
                    lessMin = MINUTES.between(data.getKey(), data.getValue());
                    endTime = data.getValue();
                }
            }

            for (Map.Entry<LocalTime, LocalTime> data: subjectTimeDetails.entrySet()) {
                if(data.getKey().isAfter(endTime)){
                    endTime = data.getValue();
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
