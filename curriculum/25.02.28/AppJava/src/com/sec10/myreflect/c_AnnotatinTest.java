package com.sec10.myreflect;
//@Override  // 메서드 재정의 명시 [검색 결과 없음]
//@Deprecated  // 사용 중지 경고
//@SuppressWarnings("unchecked")  // 컴파일러 경고 무시

public class c_AnnotatinTest {

	@Override
	public String toString() {
		return "This method overrides Object.toString()";
	}

	@Deprecated
	public void oldMethod() {
		System.out.println("This method is deprecated");
	}

	@SuppressWarnings("unchecked")
	public <T> T unsafeOperation(Object obj) {
		return (T) obj;
	}
}
