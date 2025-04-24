// js has no functional overloading
// the last function with the same name is valid

function test() {
    return 100;
}

function test(a) {
    return a;
}

function test(a,b) {
    return a + b;
}

console.log(test());
console.log(test(50));
console.log(test(50,30));


// simulating functional overloading?

function test02(a,b) {
    if ( a == undefined && b == undefined) {
        return 100;
    }
    else if ( b == undefined) {
        return a;
    }
    else {
        return a + b;
    }
}

console.log(test02());
console.log(test02(50));
console.log(test02(50,30));

console.log("================람다식으로 변경======================")

const test03 = (a,b) => {
    if ( a == undefined && b == undefined) {
        return 100;
    }
    else if ( b == undefined) {
        return a;
    }
    else {
        return a + b;
    }
};

console.log(test03());
console.log(test03(50));
console.log(test03(50,30));

console.log("================한줄로 변경======================")

const test04 = (a,b) => a === undefined ? 100 : b === undefined ? a : a + b;

console.log(test03());
console.log(test03(50));
console.log(test03(50,30));

// const func = (params) => expression