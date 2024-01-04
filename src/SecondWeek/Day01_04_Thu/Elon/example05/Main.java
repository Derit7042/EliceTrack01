package SecondWeek.Day01_04_Thu.Elon.example05;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Arrays.stream
        System.out.println("Arrays.stream:");
        Arrays.stream(new String[]{"abcd", "aaa", "bbb", "ccc", "acab"})
                .peek(e -> System.out.println("(1) " + e))
                .sorted()
                .filter(e -> e.startsWith("a"))
                .forEach(e -> System.out.println("(2) " + e));

        // 위 stream을 반복문으로 구현한 예시
        System.out.println("\n비 Stream 버전:");
        String[] strArr = {"abcd", "aaa", "bbb", "ccc", "acab"};
        for (String cur : strArr) {
            System.out.println("(1) " + cur);
        }
        Arrays.sort(strArr);
        ArrayList<String> strList = new ArrayList<>();
        for (String cur : strArr) {
            if (cur.startsWith("a")) {
                strList.add(cur);
            }
        }
        for (String cur : strList) {
            System.out.println("(2) " + cur);
        }
        System.out.println("\n==========================================\n");

        // list.stream
        System.out.println("\nlist.stream: ");
        Optional<Integer> max1 = List.of(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2).stream()
                .sorted().peek(e -> System.out.println(e))
                .map(e -> e / 2)
                .max(Comparator.comparing(x -> x));
        System.out.println("리스트에서의 최대값은: " + max1.orElseThrow() + "\n");

        // Stream.of
        System.out.println("\nStream.of: ");
        Optional<Integer> min1 = Stream.of(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2)
                .sorted()
                .peek(e -> System.out.println(e))
                .map(e -> e / 2)
                .min(Comparator.comparing(x -> x));
        System.out.println("리스트에서의 최소값은: " + min1.orElseThrow() + "\n");

        // Stream.builder
        System.out.println("\nStream.builder: ");
        Stream.Builder<Character> builder = Stream.builder();
        builder.add('z').add('a');
        builder.add('o').add('x');
        builder.add('p').add('d');
        // 아래와 같이 build를 불러야 stream이 생성됨.
        List<Character> l1 = builder.build().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("내림차순으로 정렬한 리스트: " + l1 + "\n");

        // Stream.iterate
        System.out.println("\nStream.iterate: ");
        List<Integer> l2 = Stream.iterate(2, e -> e * 2).limit(10).collect(Collectors.toList());
        System.out.println("Stream.iterate로 생성한 리스트: " + l2 + "\n");
    }
}
