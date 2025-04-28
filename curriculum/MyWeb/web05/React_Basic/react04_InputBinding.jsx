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
