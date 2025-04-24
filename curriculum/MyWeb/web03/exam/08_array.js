// Array.forEach(callbackFn)
// Array.forEach(callbackFn, thisArg)
// ${} -> 변수, 표현식을 삽입할 때 사용하는 템플릿 리터럴 
// ex) `문자열 중앙에 ${값 또는 표현식}` 이름: ${name}, ${a+b}, ${fn()}

const a = 10;
const b = 20;
console.log('합계는 = ${a+b}');
console.log(`합계는 = ${a+b}`);


// case 1: 단순출력 
const fruits = ["사과", "바나나", "포도"];
    fruits.forEach(fruit => {
        console.log(fruit);
    });

// case 2: 인덱스 출력
fruits.forEach((fruits, index) => {
    console.log(`index ${index}`);
});

// case 3: 인덱스 출력 callbackfn: (value: string, index,: number, array: string[])
fruits.forEach((fruits, index, array) => {
    console.log(`index ${index} : ${fruits} :: 전체배열 : ${array}`);
});

// case 4: 배열이ㅡ 속성으로 출력
const fruits_list = [
    {name : "사과", color : "빨강"},
    {name : "바나나", color : "노랑"},
    {name : "수박", color : "파랑"}
];

fruits_list.forEach((fruit) => {
    console.log(`${fruit.name} : ${fruit.color}`);
});

// case 5: 콜백함수 활용 
function print(fruit, index) {
    console.log(`**${fruit.length}** ${index}`)
}

fruits.forEach(print);