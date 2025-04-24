//Hoisting : 코드가 실행되기 전에 변수 선언과, 함수선언을 스코프 최상단으로 끌어올리는 동작 
console.log(x);
var x = 5;
console.log(x);

/*
<----- var x hoisted to here
console.log(x);
var x = 5;
console.log(x);
*/

prn();
function prn() {
    console.log("===prn===");
}

/*
<----- function prn() declaration hoisted to here 
prn();
function prn() {
    console.log("===prn===");
}
*/

// 함수 표현식은 호이스팅이 안된다.
sayHello();
var sayHello = function() {
    console.log("===sayHello===")
};
