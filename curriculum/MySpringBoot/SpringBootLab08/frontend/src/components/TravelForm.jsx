import React, { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

export default function TravelForm({ onAdd }) {
  const [title, setTitle] = useState("");
  const [location, setLocation] = useState("");
  const [googleMapsUrl, setGoogleMapsUrl] = useState("");
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [description, setDescription] = useState("");
  const [imageUrl, setImageUrl] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const travel = {
      title,
      location,
      googleMapsUrl,
      startDate: startDate.toISOString().split("T")[0],
      endDate: endDate.toISOString().split("T")[0],
      description,
      imageUrl
    };

    const res = await fetch("/api/travels", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(travel)
    });

    if (res.ok) {
      onAdd();
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ padding: "20px", maxWidth: "600px", margin: "auto" }}>
      <h2>여행지 등록</h2>
      <div className="form-group">
        <input className="form-control" placeholder="제목" value={title} onChange={(e) => setTitle(e.target.value)} />
      </div>
      <div className="form-group">
        <input className="form-control" placeholder="지역" value={location} onChange={(e) => setLocation(e.target.value)} />
      </div>
      <div className="form-group">
        <input className="form-control" placeholder="지도 URL" value={googleMapsUrl} onChange={(e) => setGoogleMapsUrl(e.target.value)} />
      </div>

      <div className="form-group">
        <label>시작 날짜:</label><br />
        <DatePicker selected={startDate} onChange={(date) => setStartDate(date)} dateFormat="yyyy-MM-dd" className="form-control" />
      </div>

      <div className="form-group">
        <label>종료 날짜:</label><br />
        <DatePicker selected={endDate} onChange={(date) => setEndDate(date)} dateFormat="yyyy-MM-dd" className="form-control" />
      </div>

      <div className="form-group">
        <textarea className="form-control" placeholder="설명" value={description} onChange={(e) => setDescription(e.target.value)} />
      </div>
      <div className="form-group">
        <input className="form-control" placeholder="이미지 URL" value={imageUrl} onChange={(e) => setImageUrl(e.target.value)} />
      </div>
      <button className="btn btn-primary btn-block">등록</button>
    </form>
  );
}
