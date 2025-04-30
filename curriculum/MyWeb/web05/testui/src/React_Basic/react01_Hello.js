import React from "react";

function Hello() {
  return <h1>Hello! Your first REACT page!</h1>;
}

function Bye() {
  return <h1>Bye! See you later!</h1>;
}

function Connect() {
  return <h1>Connect function</h1>;
}

export {Hello as default, Bye as MyBye, Connect as MyConnect};