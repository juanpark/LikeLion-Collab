import test, {Person, PI as p_PI, add} from './10_class.js';

console.log(test("Juan"));
console.log(p_PI);
console.log(add(1,2));

class Employee extends Person {
    constructor(tname, taddress, phone, position) {
        super(tname, taddress, phone);  // 부모 생성자 호출
        this.position = position;       // 새로운 필드 추가
    }

    // 새로운 메서드 추가
    printJob() {
        console.log(`${this.tname}의 직책은 ${this.position}입니다.`);
    }

    // toString() overriding
    toString() {
        return super.toString() + ` / 직책: ${this.position}`;
    }
}

const emp = new Employee("홍길동", "서울시 강남구", "010-1234-5678", "매니저");

emp.printInfo();
emp.printJob();

console.log(emp.toString());

