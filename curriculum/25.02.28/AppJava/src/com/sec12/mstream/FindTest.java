package com.sec12.mstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class FindTest {

	public static void main(String[] args) {

		List<String> str = Arrays.asList("딸기", "바나나", "멜론", "수박");
		Optional<String> o_min = str.stream().min(Comparator.naturalOrder());
		Optional<String> o_max = str.stream().max(Comparator.naturalOrder());
		Optional<String> findone = str.stream().findAny();
		Prn(o_min);
		Prn(o_max);
		Prn(findone);
	}

	private static void Prn(Optional<String> o) {
		if (o.isPresent()) {
			System.out.println(o.get());
		} else {
			System.out.println("no value");
		}

	}

}
