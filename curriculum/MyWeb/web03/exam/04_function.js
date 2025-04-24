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