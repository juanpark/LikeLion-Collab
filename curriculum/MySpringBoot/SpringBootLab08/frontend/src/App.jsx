import React, { useEffect, useState } from "react";
import TravelCard from "./components/TravelCard";
import TravelForm from "./components/TravelForm";
import Header from "./components/Header";
import Footer from "./components/Footer";

function App() {
  const [travels, setTravels] = useState([]);

  useEffect(() => {
    fetch("/api/travels")
      .then((res) => res.json())
      .then((data) => setTravels(data))
      .catch((err) => console.error("데이터 로드 실패:", err));
  }, []);

  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <div className="container mt-4">
        <TravelForm onAdd={() => window.location.reload()} />
        <h2 className="text-center my-4">🌍 여행지 목록</h2>
        <div className="row">
          {travels.map((travel) => (
            <div className="col-md-4" key={travel.id}>
              <TravelCard {...travel} />
            </div>
          ))}
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default App;
