import React, {useState} from "react";
import Hello,{MyBye, MyConnect} from "./React_Basic/react01_Hello"
import Welcome, {MyCalc} from "./React_Basic/react02_Props";
import Counter02 from "./React_Basic/react03_UseState"
import NameInput, {DateInput} from "./React_Basic/react04_InputBinding"
import LoginStatus from "./react05_ConditionalRender";
import SkillList from "./React_Basic/react06_ListRender";
import Clock from "./React_Basic/react07_UseEffect";
import UserList, {TodosOne} from "./React_Basic/react08_FetchData";

function App() {
  const [CurrentComponent, setCurrentComponent] = useState("React01");
    const listComponent = () => {
      switch(CurrentComponent) {
        case "React01" : return <React01/>;
        case "React02" : return <React02/>;
        case "React03" : return <React03/>;
        case "React04" : return <React04/>;
        case "React05" : return <React05/>;
        case "React06" : return <React06/>;
        case "React07" : return <React07/>;
        case "React08" : return <React08/>;
        default : return <React01/>;
      }
    };

  return (
    <>
      <div>
        <button onClick={() => setCurrentComponent("React01")}>React01</button>
      </div>
      <div>
        <button onClick={() => setCurrentComponent("React02")}>React02</button>
      </div>
      <div>
        <button onClick={() => setCurrentComponent("React03")}>React03</button>
      </div>
      <div>
        <button onClick={() => setCurrentComponent("React04")}>React04</button>
      </div>
      <div>
        <button onClick={() => setCurrentComponent("React05")}>React05</button>
      </div>
      <div>
        <button onClick={() => setCurrentComponent("React06")}>React06</button>
      </div>
      <div>
        <button onClick={() => setCurrentComponent("React07")}>React07</button>
      </div>
      <div>
        <button onClick={() => setCurrentComponent("React08")}>React08</button>
      </div>
      {/* 현재 선택된 컴포넌트 표시 */}
      <div style={{ border: "3px solid gray", padding: "20px" }}>
        {listComponent()}
      </div>
    </>
  );
}

function React08() {
  return (
    <div>
      <UserList/>
      <TodosOne/>
    </div>
  )
}

function React07() {
  return (
    <div>
      <Clock/>
    </div>
  )
}

function React06() {
  return (
    <div>
      <SkillList/>
    </div>
  )
}

function React05() {
  const [isLoggedIn, setLoggedIn] = useState(false);
  const handleLogin = () => {
    setLoggedIn(true);
  };
  const handleLogout = () => {
    setLoggedIn(false);
  };

  return (
    <div>

      <LoginStatus isLoggedIn={isLoggedIn}/>
      {isLoggedIn ? 
      (<button onClick={handleLogout}>Logout</button>) : 
      (<button onClick={handleLogin}>Login</button> )}
    </div>
  )
}

function React04() {
  return (
    <div>
      <NameInput/>
      <DateInput/>
    </div>
  )
}

function React03() {
  return (
    <div>
      <h1>React APP</h1>
      <Counter02 />
    </div>
  )
}

function React02() {
  return (
    <>
      <Welcome name ="홍길동" />
      <MyCalc num1={10} num2={5} />


    </>
  )
}

// jsx 호출할 때 import 할 때 컴포넌트 이름의 첫글자는 꼭 대문자.
function React01() {
  return (
    <>
      <Hello />
      <MyBye />
      <MyConnect />
    </>
  )
}

export default App;

