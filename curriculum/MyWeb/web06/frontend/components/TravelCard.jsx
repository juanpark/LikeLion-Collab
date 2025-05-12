import React, { useState } from "react";

export default function TravelCard(props) {
  const [isOpen, setIsOpen] = useState(false);

  const toggleAccordion = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className="card">
      <img 
        src={props.imageUrl} 
        alt="여행지" 
        className="card--image"
      />
      <div className="card--content">
        <div className="card--location">
          <span>{props.location}</span> 📍
          <a href={props.googleMapsUrl} target="_blank" rel="noopener noreferrer">
            지도 보기
          </a>
        </div>

        {/* 여기 title만 클릭할 수 있게 */}
        <h2 
          onClick={toggleAccordion}
          style={{ cursor: "pointer", color: "#0077cc" }}
        >
          {props.title}
        </h2>

        <p className="card--date">{props.startDate} ~ {props.endDate}</p>

        {isOpen && (
          <div className="card--detail">
            <p>{props.description}</p>
          </div>
        )}
      </div>
    </div>
  );
}
