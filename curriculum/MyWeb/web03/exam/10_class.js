//

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