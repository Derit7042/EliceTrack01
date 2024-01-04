package SecondWeek.Day01_04_Thu.Elon.example07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 아래 코드의 스트림은 처음에 요소가 5개이지만 실제로 연산은 3개만 진행한다.
        // limit 중간 연산 때문에 그렇다.
        List<Integer> l1 = Stream.of(5, 2, 4, 1, 3)
                .map(e -> e * 3)
//                .peek(e -> System.out.println("(1) " + e)) // short-circuit을 확인하기 위한 중간 연산
                .map(e -> e + 1)
//                .peek(e -> System.out.println("(2) " + e)) // short-circuit을 확인하기 위한 중간 연산
                .limit(3)
                .sorted()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Stream 버전: " + l1 + "\n");

        // 위 코드는 아래와 비슷하다:
        int[] arr1 = {5, 2, 4, 1, 3};

        UnaryOperator<Integer> multiplyByThree = e -> e * 3;
        UnaryOperator<Integer> addOne = e -> e + 1;

        int[] arr2 = new int[3];
        int index = 0;
        while (index < 3) {
            arr2[index] = arr1[index];
            index = index + 1;
        }

        // loop fusion을 해부한 모습
        for (int i = 0; i < arr2.length; i++) {
            // 곱하고, 더하는 것을 한 사이클에서 한 번에 진행
            arr2[i] = addOne.compose(multiplyByThree).apply(arr2[i]);
        }

        Arrays.sort(arr2);

        ArrayList<Integer> l2 = new ArrayList<>();
        for (int cur : arr2) {
            if (cur % 2 == 0) {
                l2.add(cur);
            }
        }
        System.out.println("비Stream 버전: " + l2 + "\n");

    }
}
