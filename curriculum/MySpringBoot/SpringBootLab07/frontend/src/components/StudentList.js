// src/components/StudentList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const StudentList = () => {
  // [1] 상태 선언
  const [students, setStudents] = useState([]);
  const [courses, setCourses] = useState([]);
  const [name, setName] = useState('');
  const [selectedCourses, setSelectedCourses] = useState([]);

  // [2] 학생+강의 목록 불러오기
  const loadStudents = async () => {
    const res = await axios.get('/api/students');
    setStudents(res.data.students);
    setCourses(res.data.courses);
  };

  // [3] 첫 로딩 시 실행
  useEffect(() => {
    loadStudents();
  }, []);

  // [4] 새 학생 추가
  const handleAddStudent = async (e) => {
    e.preventDefault();
    await axios.post('/api/students', {
      name,
      courseIds: selectedCourses,
    });
    setName('');
    setSelectedCourses([]);
    loadStudents();
  };

  // [5] 학생 삭제
  const handleDeleteStudent = async (id) => {
    await axios.delete(`/api/students/${id}`);
    loadStudents();
  };

  return (
    <div className="mb-5">
      <h2 className="mb-3">학생 목록</h2>

      {/* [6] 학생 추가 폼 */}
      <form onSubmit={handleAddStudent} className="row g-2 mb-3">
        <div className="col-md-3">
          <input
            type="text"
            className="form-control"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="학생 이름"
            required
          />
        </div>
        <div className="col-md-4">
          {/* [7] 과목 선택 드롭다운 */}
          <select
            multiple
            className="form-select"
            value={selectedCourses}
            onChange={(e) =>
              setSelectedCourses(
                Array.from(e.target.selectedOptions, (option) => option.value)
              )
            }
          >
            {courses.map((c) => (
              <option key={c.id} value={c.id}>
                {c.title}
              </option>
            ))}
          </select>
        </div>

        {/* [8] 추가 버튼 */}
        <div className="col-md-2">
          <button type="submit" className="btn btn-primary w-100">
            추가
          </button>
        </div>

        {/* 🔥 [9] 강의 목록으로 이동 버튼 */}
        <div className="col-md-2">
          <button
            type="button"
            className="btn btn-secondary w-100"
            onClick={() => window.location.href = '/courses'}
          >
            강의 목록으로 이동
          </button>
        </div>
      </form>

      {/* [10] 학생 목록 테이블 */}
      <table className="table table-bordered table-hover">
        <thead className="table-dark">
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>수강 과목</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {students.map((s) => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.name}</td>
              <td>
                <ul className="list-unstyled mb-0">
                  {s.courses?.map((c) => (
                    <li key={c.id}>• {c.title}</li>
                  ))}
                </ul>
              </td>
              <td>
                <button
                  onClick={() => handleDeleteStudent(s.id)}
                  className="btn btn-danger btn-sm"
                >
                  삭제
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default StudentList;
