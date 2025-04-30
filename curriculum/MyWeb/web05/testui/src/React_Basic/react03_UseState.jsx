import React, { useState } from "react";
function Counter() {
  const [count, setCount] = useState(0);
  return (
    <div>
      <p>현재 값: {count}</p>
      <button onClick={() => setCount(count + 1)}>증가</button>
      <button onClick={() => setCount(count - 1)}>감소</button>
      <button onClick={() => setCount(0)}>초기화</button>

    </div>
  );
}

// 색을 지정한 다음 랜덤으로 버튼의 배경색을 바꾸기  
export default function Counter02() {
  const [count, setCount] = useState(0);
  const [color, setColor] = useState("tomato");

  // 색을 랜덤으로 지정할 수 있는 목록
  const colors = ["blue", "gray", "yellow", "white", "green"];

  // 버튼을 클릭할 때 버튼 색도 변경
  const handleInc = () => {
    setCount(count + 1);
    changeColor();
  };

  const handleDec = () => {
    setCount(count - 1);
    changeColor();
  };

  const handleInit = () => {
    setCount(0);
    changeColor();
  };

  const changeColor = () => {
    const mycolorIndex = Math.floor(Math.random() * colors.length);  
    setColor(colors[mycolorIndex]);
  }

  return (
    <div>
      <p>현재 값: {count}</p>
      <button onClick={handleInc} style={{backgroundColor : color}}>증가</button>
      <button onClick={handleDec} style={{backgroundColor : color}}>감소</button>
      <button onClick={handleInit} style={{backgroundColor : color}}>초기화</button>

    </div>
  );
}