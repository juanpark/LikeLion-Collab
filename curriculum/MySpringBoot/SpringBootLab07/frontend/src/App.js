// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import StudentList from './components/StudentList';
import CourseList from './components/CourseList';

function App() {
  return (
    // [1] 전체 앱을 React Router로 감싼다
    <Router>
      {/* [2] 경로별로 보여줄 컴포넌트 설정 */}
      <Routes>
        {/* [3] 루트("/") 경로 ➜ StudentList 컴포넌트 */}
        <Route path="/" element={<StudentList />} />

        {/* [4] "/courses" 경로 ➜ CourseList 컴포넌트 */}
        <Route path="/courses" element={<CourseList />} />
      </Routes>
    </Router>
  );
}

export default App;
