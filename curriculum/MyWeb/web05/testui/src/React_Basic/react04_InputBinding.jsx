import { useState } from "react";
export default function NameInput() {
  const [name, setName] = useState("");
  return (
    <div>
      <input value={name} onChange={e => setName(e.target.value)} />
      <p>입력한 이름: {name}</p>
    </div>
  );
}

// 오늘 날짜로 초기화
const getToday = () => {
  const today = new Date();
  const year = today.getFullYear();
  const month = today.getMonth();
  const date = today.getDate();
  const day = today.getDay();
  return `${year}-${month}-${date}-${day}`
}


export function DateInput() {
  const[myDate, setMyDate] = useState(getToday());
  return (
    <div style={{marginTop: "20px"}}>
      <h2>날짜 선택</h2>
      <input type="date" 
        value={myDate} 
        onChange={e => setMyDate(e.target.value)}/>
      <p>선택한 날짜: {myDate}</p>
    </div>
  );
}
