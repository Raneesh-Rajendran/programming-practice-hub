package main.java.miscellaneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class JonnyPhotoArrange {

  public static void main(String[] args) {

    JonnyPhotoArrange arranger = new JonnyPhotoArrange();
    String s =
        "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
            + "john.png, London, 2015-06-20 15:13:22\n"
            + "myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
            + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
            + "pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
            + "BOB.jpg, London, 2015-08-05 00:02:03\n"
            + "notredame.png, Paris, 2015-09-01 12:00:00\n"
            + "me.jpg, Warsaw, 2013-09-06 15:40:22\n"
            + "a.png, Warsaw, 2016-02-13 13:33:50\n"
            + "b.jpg, Warsaw, 2016-01-02 15:12:22\n"
            + "c.jpg, Warsaw, 2016-01-02 14:34:30\n"
            + "d.jpg, Warsaw, 2016-01-02 15:15:01\n"
            + "e.jpg, Warsaw, 2016-01-02 09:49:09\n"
            + "f.jpg, Warsaw, 2016-01-02 10:55:32\n"
            + "g.jpg, Warsaw, 2016-02-29 22:13:11";
    System.out.println(arranger.solution(s));
  }

  public String solution(String S) {
    List<Photo> photos =
        Arrays.stream(S.split("\n"))
            .map(
                photo -> {
                  String[] parts = photo.split(",");
                  return new Photo(
                      parts[0].replace(" ", ""),
                      parts[1].replace(" ", ""),
                      parts[2].replace(" ", ""));
                })
            .collect(Collectors.toList());

    Map<String, List<Photo>> groupedByPlace =
        photos.stream().collect(Collectors.groupingBy(Photo::getCity)).entrySet().stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    (entry) ->
                        entry.getValue().stream()
                            .sorted(Comparator.comparing(Photo::getTime))
                            .collect(Collectors.toList())));

    return photos.stream()
        .map(
            photo ->
                photo.getCity()
                    + ((IntStream.range(
                                    0,
                                    String.valueOf(groupedByPlace.get(photo.getCity()).size())
                                        .length())
                                .mapToObj(r -> "0")
                                .collect(Collectors.joining()))
                            + (groupedByPlace.get(photo.getCity()).indexOf(photo) + 1))
                        .substring(
                            String.valueOf(groupedByPlace.get(photo.getCity()).indexOf(photo) + 1)
                                .length())
                    + photo.getName().substring(photo.getName().indexOf(".")))
        .collect(Collectors.joining("\n"));
  }

  public class Photo {
    private final String name;
    private final String city;
    private final String time;

    public Photo(String name, String city, String time) {
      this.name = name;
      this.city = city;
      this.time = time;
    }

    public String getName() {
      return name;
    }

    public String getCity() {
      return city;
    }

    public String getTime() {
      return time;
    }
  }
}
