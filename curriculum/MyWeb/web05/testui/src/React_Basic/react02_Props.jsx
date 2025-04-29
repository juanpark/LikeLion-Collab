import React, {useState} from "react";

function Welcome(props) {
  return <h2>Welcome, {props.name}!</h2>;
}
function App() {
  return <Welcome name="홍길동 " />;
}

// Calc 컴포넌트를 만들어 4칙연산을 구현해 보자
function Calc(props) {
  const {num1, num2} = props;

  // 계산 결과를 보여주는 상태, 화면을 보여줄지 말지 
  const [state, setState] = useState(false);

  // 버튼을 클릭했을 때 계산결과 보여주는 이벤트 
  const  handleCalc=() => {};
  
  return (
    <div> 
        <h2>4칙연산 결과</h2>
        <button onClick={handleCalc}>계산하기</button>
        <p>{num1} + {num2} = {num1 + num2}</p>
        <p>{num1} - {num2} = {num1 - num2}</p>
        <p>{num1} * {num2} = {num1 * num2}</p>
        <p>{num1} / {num2} = {num2 !== 0 ? num1 / num2 : "not divisible by 0"}</p>
    </div>
  );
}


// Calc 컴포넌트를 만들어 4칙연산을 구현해 보자
function MyCalc(props) {
    const {num1, num2} = props;

    // 계산 결과를 보여주는 상태, 화면을 보여줄지 말지 
    const [showResult, setShowResult] = useState(false);

    // 버튼을 클릭했을 때 계산결과 보여주는 이벤트 
    const  handleCalc=() => {
      setShowResult(true);
    };

    return (
      <div> 
          <h2>4칙연산 결과</h2>
          <button onClick={handleCalc}>계산하기</button>
          {/*결과를 조건부로 계산*/}
          {showResult && (<>
          <p>{num1} + {num2} = {num1 + num2}</p>
          <p>{num1} - {num2} = {num1 - num2}</p>
          <p>{num1} * {num2} = {num1 * num2}</p>
          <p>{num1} / {num2} = {num2 !== 0 ? num1 / num2 : "not divisible by 0"}</p>
          </>
        )}
      </div>
    );
}




export default Welcome;
export {MyCalc};