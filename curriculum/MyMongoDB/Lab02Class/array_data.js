db.students_scores.insertMany([
    { name: "김민수", test: "mid", kor: [80, 90], eng: 85 },
    { name: "박지민", test: "mid", kor: 75, eng: 88 },
    { name: "민아영", test: "final", kor: [85, 95], eng: 92 },
    { name: "최무성", test: "final", kor: 78, eng: 83 },
    { name: "정미현", test: "mid", kor: 90, eng: 91 },
    { name: "이한결", test: "final", kor: [70, 65], eng: 77 },
    { name: "문세진", test: "final", kor: 88, eng: 84 }
  ]);
  
  // collection 컬렉션 샘플 데이터 삽입  
  db.collection.insertMany([
    { name: "김민수", createdAt: ISODate("2024-01-10T10:00:00Z") },
    { name: "박지민", createdAt: ISODate("2023-12-05T14:30:00Z") },
    { name: "민아영", createdAt: ISODate("2024-03-21T09:15:00Z") },
    { name: "최무성", createdAt: ISODate("2022-07-01T11:00:00Z") },
    { name: "정미현", createdAt: ISODate("2023-05-30T16:45:00Z") },
    { name: "이한결", createdAt: ISODate("2024-04-12T08:20:00Z") },
    { name: "문세진", createdAt: ISODate("2024-06-01T13:00:00Z") },
    { name: "서지호", createdAt: ISODate("2024-02-28T17:30:00Z") }
  ]);