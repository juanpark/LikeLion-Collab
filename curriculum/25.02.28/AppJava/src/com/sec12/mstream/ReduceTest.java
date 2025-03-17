package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {

    public static void main(String[] args) {
        // 1️. Optional<T> reduce(BinaryOperator<T> accumulator)
        // 리스트의 모든 값을 합산하여 Optional<Integer>로 반환 -> public static int sum(int a, int b)
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);

        // Optional 값이 존재하면 출력, 없으면 "noValue" 출력
        System.out.println(sum.orElseGet(() -> {
            System.out.println("noValue");
            return 0;
        }));

        // 2. T reduce(T identity, BinaryOperator<T> accumulator)
        // 초기값(identity) 0을 지정하여 리스트의 모든 값을 합산
        int sum01 = numbers.stream().reduce(0, Integer::sum); 
        System.out.println("Sum with identity: " + sum01);
        

        // 3. <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        // 병렬 스트림을 사용하여 초기값 0.0을 지정한 후, BiFunction과 BinaryOperator를 통해 병렬 연산 수행
        double sum03 = numbers.parallelStream().reduce(
                0.0, // 초기값(identity)
                (partialSum, a) -> partialSum + a, // BiFunction<U, ? super T, U>
                Double::sum // BinaryOperator<U>
        ); 
        System.out.println("Parallel Sum: " + sum03);
    }
}
