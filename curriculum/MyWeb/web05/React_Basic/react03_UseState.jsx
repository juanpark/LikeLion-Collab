import { useState } from "react";
export default function Counter() {
  const [count, setCount] = useState(0);
  return (
    <div>
      <p>현재 값: {count}</p>
      <button onClick={() => setCount(count + 1)}>증가</button>
    </div>
  );
}
