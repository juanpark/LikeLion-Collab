// 학생들의 이름과 시험별 성적저장 _ join data
db.Score.insertMany([ 
    { name: 'aaa', kor: 90, eng: 80, mat: 98, test: 'midterm' },
    { name: 'bbb', kor: 100, eng: 100, mat: 76, test: 'final' },
    { name: 'ccc', kor: 90, eng: 55, mat: 67, test: 'midterm' },
    { name: 'ddd', kor: 70, eng: 69, mat: 89, test: 'midterm' },
    { name: 'eee', kor: 60, eng: 80, mat: 78, test: 'final' },
    { name: 'fff', kor: 90, eng: 65, mat: 98, test: 'midterm' },
    { name: 'ggg', kor: 75, eng: 100, mat: 98, test: 'final' },
    { name: 'hhh', kor: [100, 20, 40, 100], eng: 100, mat: 98, test: 'final' }
  ]);
  //학생들의 이름과 학년 정보가 저장
  db.students.insertMany([
    { name: 'aaa', grade: '3rd' },
    { name: 'bbb', grade: '2nd' },
    { name: 'ccc', grade: '1st' },
    { name: 'ddd', grade: '2nd' },
    { name: 'eee', grade: '3rd' },
    { name: 'fff', grade: '1st' },
    { name: 'ggg', grade: '2nd' },
    { name: 'hhh', grade: '3rd' }
  ]);