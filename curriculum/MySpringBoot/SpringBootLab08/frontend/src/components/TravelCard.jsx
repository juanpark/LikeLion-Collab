import React, { useState } from "react";
import axios from "axios";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";

export default function TravelCard(props) {
  const [isOpen, setIsOpen] = useState(false);
  const [showModal, setShowModal] = useState(false);

  const [editedData, setEditedData] = useState({
    title: props.title,
    location: props.location,
    googleMapsUrl: props.googleMapsUrl,
    startDate: props.startDate,
    endDate: props.endDate,
    description: props.description,
    imageUrl: props.imageUrl,
  });

  const toggleAccordion = () => setIsOpen(!isOpen);
  const handleDelete = () => {
    if (window.confirm("정말 삭제하시겠습니까?")) {
      axios.delete(`/api/travels/${props.id}`).then(() => {
        alert("삭제 완료!");
        window.location.reload();
      });
    }
  };

  const handleEditChange = (e) => {
    setEditedData({ ...editedData, [e.target.name]: e.target.value });
  };

  const handleEditSubmit = () => {
    axios
      .post("/api/travels", {
        ...editedData,
        id: props.id,
      })
      .then(() => {
        alert("수정 완료!");
        setShowModal(false);
        window.location.reload();
      });
  };

  return (
    <div
      className="card mb-4 shadow-sm"
      style={{
        transition: "transform 0.3s ease",
        cursor: "pointer",
      }}
      onMouseEnter={(e) => (e.currentTarget.style.transform = "scale(1.02)")}
      onMouseLeave={(e) => (e.currentTarget.style.transform = "scale(1.0)")}
    >
      <img
        src={props.imageUrl}
        alt="여행지"
        className="card-img-top"
        style={{ height: "200px", objectFit: "cover" }}
      />
      <div className="card-body">
        <h5 className="card-title text-primary" onClick={toggleAccordion}>
          {props.title}
        </h5>

        <h6 className="card-subtitle mb-2 text-muted">
          {props.location} 📍
          <a
            href={props.googleMapsUrl}
            target="_blank"
            rel="noopener noreferrer"
            className="ms-2 link-primary"
          >
            지도 보기
          </a>
        </h6>

        <p className="card-text">
          🗓 {props.startDate} ~ {props.endDate}
        </p>

        {isOpen && (
          <div className="card-text">
            <p>{props.description}</p>
          </div>
        )}

        <div className="mt-3 d-flex justify-content-end">
          <button className="btn btn-warning btn-sm me-2" onClick={() => setShowModal(true)}>
            수정
          </button>
          <button className="btn btn-danger btn-sm" onClick={handleDelete}>
            삭제
          </button>
        </div>
      </div>

      {/* 수정 모달 */}
      <Modal show={showModal} onHide={() => setShowModal(false)}>
        <Modal.Header closeButton>
          <Modal.Title>여행지 수정</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {Object.entries(editedData).map(([key, value]) => (
            <div className="mb-2" key={key}>
              <label className="form-label">{key}</label>
              <input
                type="text"
                className="form-control"
                name={key}
                value={value}
                onChange={handleEditChange}
              />
            </div>
          ))}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>
            닫기
          </Button>
          <Button variant="primary" onClick={handleEditSubmit}>
            저장
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
}