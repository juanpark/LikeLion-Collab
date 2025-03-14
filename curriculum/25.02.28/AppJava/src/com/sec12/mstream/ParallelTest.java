package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelTest {

	public static void main(String[] args) {
		List < String > list =  Arrays . asList (
				"사원1", "사원2", "사원3", "사원4", "사원5"
		);
		
		// 병렬 처리를 할 Stream을 생성
		Stream < String > ps1 = list . parallelStream ();
		Stream < String > ps2 = list . stream().parallel ();		
		
		// 생성 된 Stream이 병렬 처리를 할 것인지 확인
		System . out . println ( "ps1.isParallel () ="  + ps1 . isParallel ());
		System . out . println ( "ps2.isParallel () ="  + ps2 . isParallel ());		
		
		// 병렬 처리에서 직접 처리로 변환
		Stream < String > qs = ps1 . sequential ();
		System . out . println ( "qs.isParallel () ="  + qs . isParallel ());
	}

}
