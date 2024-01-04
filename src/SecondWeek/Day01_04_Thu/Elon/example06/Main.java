package SecondWeek.Day01_04_Thu.Elon.example06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 아래 스트림은 map 중간 연산자(*3, +1 하는 연산)가 마치 하나의 연산 처럼 합쳐져서 연산이 수행된다.
        List<Integer> l1 = Stream.of(5, 2, 4, 1, 3)
                .map(e -> e * 3)
//                .peek(e -> System.out.println("(1) " + e)) // loop fusion을 확인하기 위한 중간 연산
                .map(e -> e + 1)
//                .peek(e -> System.out.println("(2) " + e)) // loop fusion을 확인하기 위한 중간 연산
                .sorted()
//                .peek(e -> System.out.println("(3) " + e)) // loop fusion을 확인하기 위한 중간 연산
                .filter(e -> e % 2 == 0)
//                .peek(e -> System.out.println("(4) " + e)) // loop fusion을 확인하기 위한 중간 연산
                .collect(Collectors.toList());

        System.out.println("Stream 버전: " + l1 + "\n");

        // 위의 코드를 for문으로 작성하면 아래와 비슷하다:
        int[] arr = {5, 2, 4, 1, 3};

        UnaryOperator<Integer> multiplyByThree = e -> e * 3;
        UnaryOperator<Integer> addOne = e -> e + 1;

        // loop fusion을 해부한 모습
        for (int i = 0; i < arr.length; i++) {
            // 곱하고, 더하는 것을 한 사이클에서 한 번에 진행
            arr[i] = addOne.compose(multiplyByThree).apply(arr[i]);
        }

        /**
         * 아래와 같이 진행되는 것이 아니다
         */
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = multiplyByThree.apply(arr[i]);
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = addOne.apply(arr[i]);
//        }

        Arrays.sort(arr);

        ArrayList<Integer> l2 = new ArrayList<>();
        for (int cur : arr) {
            if (cur % 2 == 0) {
                l2.add(cur);
            }
        }
        System.out.println("비Stream 버전: " + l2 + "\n");
    }
}
