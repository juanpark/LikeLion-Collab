var name = "Hong Gil Dong";
let age = 30;
const PI = 3.1415;
// document.write
console.log("name: ", name);
console.log("age: ", age);
console.log("PI: ", PI);

a = 100;
b = 200;

hap = a + b;
console.log(a, b, hap);
console.log(typeof(123));
console.log(typeof(90.9));
console.log(typeof("abc"));
console.log(typeof[]);
console.log(typeof{});
console.log(typeof(true));
console.log(typeof(null)); // null 값을 평가할 때, 수치 맥락에서는 0으로, 불리언 맥락에서는 거짓으로 동작합니다.
console.log(typeof(function(){}));
console.log(typeof(undefined));

console.log([] instanceof Array);
console.log([] instanceof Object);
console.log(new Date() instanceof Date);

//정확한 타입을 확인하고 싶다.
console.log(Object.prototype.toString.call(null));
console.log(Object.prototype.toString.call([]));
console.log(Object.prototype.toString.call(new Date()));
console.log(Object.prototype.toString.call("abc"));
console.log(Object.prototype.toString.call('a')); // String -> char index() -> byte

const sym1 = Symbol();
const sym2 = Symbol("foo");
const sym3 = Symbol("foo");

console.log(sym1, sym2, sym3);