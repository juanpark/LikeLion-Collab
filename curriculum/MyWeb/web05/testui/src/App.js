import React from "react";
import Hello from "./react01_Hello";
import MyAddress from "./myaddress";

function App() {
  return (<div>   <h1>Hello React!</h1>
     
    <Hello name="Lion" nickName="Tiger"/>
    <MyAddress name="홍길동" addr="서울" phone="010-1234-1234" />
  
  </div>);
}
export default App;

