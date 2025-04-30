import React from "react";
import Header from "./components/Header";
import TravelCard from "./components/TravelCard";
import Footer from "./components/Footer";
import travelData from "./travelData";
import './App.css';


export default function App() {
  const cards = travelData.map(item => (
    <TravelCard 
      key={item.id}
      {...item} 
    />
  ));
  
  return (
    <div>
      <Header />
      <section className="cards-list">
        {cards}
      </section>
      <Footer />
    </div>
  );
}
