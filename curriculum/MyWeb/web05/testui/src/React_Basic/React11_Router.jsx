import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./components/Home";
import About from "./components/About";
import Contact from "./components/Contact";

export default function React11_Router() {
  return (
    <BrowserRouter>
      <div>
        <h2>🌐 React Router 기본 예제</h2>
        <nav>
          <ul style={{ listStyle: "none", paddingLeft: 0 }}>
            <li><Link to="/">홈</Link></li>
            <li><Link to="/about">소개</Link></li>
            <li><Link to="/contact">연락처</Link></li>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}