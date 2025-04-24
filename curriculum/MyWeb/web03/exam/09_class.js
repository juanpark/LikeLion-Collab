// 클래스 기반 배열코드를 작성하자

class FruitManager{
    constructor(){
        this.fruits_list = [
            {name : "사과", color : "빨강"},
            {name : "바나나", color : "노랑"},
            {name : "수박", color : "파랑"}
        ];
    }//constructor

    addFruit(name, color) {
        this.fruits_list.push({name, color});
    }

    printFruits(){
        this.fruits_list.forEach((fruit) => {
            console.log(`${fruit.name} : ${fruit.color}`);
        });
    }

    removeFruit(name) {
        const index = this.fruits_list.findIndex(f => f.name === name);
        if(index !== -1) {
            this.fruits_list.splice(index, 1);
            console.log(`${name} deleted`);
        } else {
            console.log(`${name} not in list`);
        }
    }

    updateFruit(name, newname) {
        const fruit_res = this.fruits_list.find(f => f.name === name);
        if (fruit_res) {
            fruit_res.name = newname;
            console.log(`${name} updated to ${newname}`);
        } else {
            console.log(`${name} not in list`);
        }
    }
}

// call class
const manager = new FruitManager();
manager.printFruits();
console.log("=========================")
manager.addFruit("Kiwi", "Gold");
manager.printFruits();

// delete data
console.log("=========================")
manager.removeFruit("Kiwi");
manager.printFruits();

// update
console.log("=========================")
manager.updateFruit("바나나", "오렌지");
manager.printFruits();