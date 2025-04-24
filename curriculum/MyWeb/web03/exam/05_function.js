// case 1: 다형성 처리를 구현하는 arguments.length 처리 -> ...args : 모든 매개인자를 배열로 받겠다

const test = (...args) => {
    switch (args.length) {
        case 0: return 100; // no args
        case 1: return args[0]; // 1 args
        case 2: return args[0] + args[1]; // 2 args
        default: return NaN;
    }
}


console.log(test());
console.log(test(100));
console.log(test(100,200));
console.log(test(1,2,3));

// case 2: typeof를 이용한 분기 방법
const test03 = (a, b) => {
    if (typeof a === "undefined" && typeof b === "undefined") return 100;
    if (typeof b === "undefined") return a;
    return a + b;
}

console.log(test03());
console.log(test03(100));
console.log(test03(100,200));

// 함수 선언 시 블록스코프, typeof 확인 
// globalThis : 현재 실행 환경에서의 전역 객체 
// "foo" in globalThis -> foo가 전역 변수로 등록 되었는지 유무 확인 

console.log(
    `'foo' name ${
      "foo" in globalThis ? "is" : "is not"
    } global. typeof foo is ${typeof foo}`,
  );
  if (false) {
    function foo() {
      return 1;
    }
  }
  
  function myfun() {}
  console.log("myfun" in globalThis);


  // In Chrome:
  // 'foo' name is global. typeof foo is undefined
  //
  // In Firefox:
  // 'foo' name is global. typeof foo is undefined
  //
  // In Safari:
  // 'foo' name is global. typeof foo is function
  