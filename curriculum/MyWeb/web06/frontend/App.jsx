
import React, { useEffect, useState } from "react";
import TravelCard from "./components/TravelCard";
import TravelForm from "./components/TravelForm";

function App() {
  const [travels, setTravels] = useState([]);

  useEffect(() => {
    fetch("http://localhost:3001/api/travels")
      .then((res) => res.json())
      .then((data) => setTravels(data))
      .catch((err) => console.error("데이터 로드 실패:", err));
  }, []);

  return (
    <div>
      <TravelForm onAdd={() => window.location.reload()} />
<h1 style={{ textAlign: "center", margin: "20px 0" }}>🌍 여행지 목록</h1>
      {travels.map((travel) => (
        <TravelCard key={travel.id} {...travel} />
      ))}
    </div>
  );
}

export default App;
