// 1. 문자열 → 객체 (읽기 / 파싱)

const jsonString = '{"name": "길동", "age": 28}';
const user = JSON.parse(jsonString);
console.log(user.name); 
console.log(typeof(jsonString));
console.log(typeof(user));

//2. 객체 → 문자열 (쓰기 / 저장)
const newUser = { name: "홍길동", age: 26 };
const jsonOutput = JSON.stringify(newUser);
console.log(jsonOutput); 
console.log(typeof(newUser));
console.log(typeof(jsonOutput));
