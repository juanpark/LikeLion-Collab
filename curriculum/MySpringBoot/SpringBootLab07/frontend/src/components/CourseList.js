// src/components/CourseList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CourseList = () => {
  // [1] 상태 선언
  const [courses, setCourses] = useState([]);
  const [title, setTitle] = useState('');

  // [2] 강의 목록 불러오기
  const loadCourses = async () => {
    const res = await axios.get('/api/courses');
    setCourses(res.data);
  };

  // [3] 첫 로딩 시 실행
  useEffect(() => {
    loadCourses();
  }, []);

  // [4] 새 강의 추가
  const handleAddCourse = async (e) => {
    e.preventDefault();
    await axios.post('/api/courses', { title });
    setTitle('');
    loadCourses();
  };

  // [5] 강의 삭제
  const handleDeleteCourse = async (id) => {
    await axios.delete(`/api/courses/${id}`);
    loadCourses();
  };

  return (
    <div>
      <h2 className="mb-3">강의 목록</h2>

      {/* [6] 강의 추가 폼 */}
      <form onSubmit={handleAddCourse} className="row g-2 mb-3">
        <div className="col-md-4">
          <input
            type="text"
            className="form-control"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            placeholder="강의 제목"
            required
          />
        </div>
        <div className="col-md-2">
          <button type="submit" className="btn btn-primary w-100">
            추가
          </button>
        </div>
      </form>

      {/* [7] 강의 목록 */}
      <ul className="list-group">
        {courses.map((c) => (
          <li key={c.id} className="list-group-item d-flex justify-content-between align-items-center">
            {c.title}
            <button
              onClick={() => handleDeleteCourse(c.id)}
              className="btn btn-danger btn-sm"
            >
              삭제
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CourseList;
