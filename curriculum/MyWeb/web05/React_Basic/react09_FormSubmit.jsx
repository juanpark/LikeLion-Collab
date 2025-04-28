import { useState } from "react";
export default function FormSubmit() {
  const [name, setName] = useState("");
  const handleSubmit = e => {
    e.preventDefault();
    alert("제출된 이름: " + name);
  };
  return (
    <form onSubmit={handleSubmit}>
      <input value={name} onChange={e => setName(e.target.value)} />
      <button type="submit">제출</button>
    </form>
  );
}
