// export: 하나의 모듈에 하나의 기본값으로 지정, class, const, function

export default function(name){
    return `Hello default, ${name}`;
}
// 선언된 함수를 default export 하는 경우 확인 (함수 이름은 외부에서 import 되지 않음 / 사용되지 않음)
//function greet(name) {
//    return `Hello, ${name}`;
//}

// export default greet;

export const PI = 3.14;

export function add(a,b) {return a+b};

export class Person {
    constructor(tname, taddress, phone) {
        this.tname = tname;
        this.taddress = taddress;
        this.phone = phone; 
    }

    printInfo() {
        console.log(`${this.tname} ${this.taddress} ${this.phone}`);
    }

    toString() {
        return `${this.tname} ${this.taddress} ${this.phone}`;
    }

}

/*
const p1 = new Person('111','1111','1111');
const p2 = new Person('222','2222','2222');
p1.printInfo();
p2.printInfo();
console.log(p1 + " ");
console.log(p2);

const p_list = [
    new Person('111','1111','1111'),
    new Person('222','1111','1111'),
    new Person('333','1111','1111')
];

p_list.forEach((p, index) => {
    console.log(`${index + 1} ${p.toString()}`);
});
*/