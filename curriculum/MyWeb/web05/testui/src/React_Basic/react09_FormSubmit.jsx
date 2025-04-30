import React, { useState } from "react";
export default function FormSubmit() {
  const [name, setName] = useState("");
  const handleSubmit = e => {
    e.preventDefault(); // 폼 기본 서버 전송을 막기 -> 기본 새로고침을 막음
    alert("제출된 이름: " + name); // 알림으로 입력값 출력 
  };
  return (
    <form onSubmit={handleSubmit}>
      <input value={name} onChange={e => setName(e.target.value)} />
      <button type="submit">제출</button>
    </form>
  );
}

export function NameSubmit() {
  const [name, setName] = useState("");
  const [responseMsg, setResponseMsg] = useState("");
  
  const handleSubmit = async (e) => {
    e.preventDefault(); 

    try{
    const res = await fetch('http://localhost:7777/api/name', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({text:name})
    });
    const data = await res.json();
    setResponseMsg(data.message)
    } catch(err) {
      console.error(err);
      setResponseMsg("failed request");
    }
    setName("");
  };

  return (
    <div>
    <form onSubmit={handleSubmit}>
      <input value={name} onChange={e => setName(e.target.value)} />
      <button type="submit">제출</button>
    </form>
    <p>{responseMsg}</p>
    </div>
  )}