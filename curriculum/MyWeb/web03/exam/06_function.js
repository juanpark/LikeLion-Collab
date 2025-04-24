"use strict"; // 선언된 하위 코드들의 오류 검사를 강하게 진행하겠다
/*
1. 전역과 지역키워드를 명시
2. this바인딩을 명시적으로 해라
3. 예약어 쓰지 말기
4. 중복 매개변수 금지   function test(a,a) X
5. 함수 선언 제한
*/

{
  foo(); // Logs "foo"
  function foo() {
    console.log("foo");
  }
}

console.log(
  `'foo' name ${
    "foo" in globalThis ? "is" : "is not"
  } global. typeof foo is ${typeof foo}`,
);
// 'foo' name is not global. typeof foo is undefined

if(true) {
    function f() {console.log("========")};
}

x=100;
console.log(x);