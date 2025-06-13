
function runAllJoins() {
    print("=======================================================================================");
    print("Q1. Score 컬렉션에서 모든 학생들의 국어 점수(kor) 합계를 구하고, 만약 kor 필드가 배열이라면, 배열의 합을 사용하자.");
    db.Score.aggregate([ 
      { $project: { name: 1, kor: { $cond: { if: { $isArray: "$kor" }, then: { $sum: "$kor" }, else: "$kor" } } } },
      { $group: { _id: null, totalKorScore: { $sum: "$kor" } } } 
    ]).forEach(printjson);
  
    print("=======================================================================================");
    print("Q2. Score 컬렉션에서 가장 많이 치른 시험 유형을 찾아, 시험 유형별로 빈도를 계산하고 빈도순으로 정렬하자");
    db.Score.aggregate([{ $sortByCount: "$test" }]).forEach(printjson);
    db.Score.aggregate([{ $sortByCount: "$kor" }]).forEach(printjson);
  
    print("=======================================================================================");
    print("Q3. Score 컬렉션과 students 컬렉션을 조인하여, 각 학생의 성적과 학년 정보를 함께 출력하자.");
    db.Score.aggregate([ 
      { $lookup: { from: "students", localField: "name", foreignField: "name", as: "res" } }, 
      { $project: { name: 1, kor: 1, eng: 1, mat: 1, test: 1, "res.grade": 1 } }
    ]).forEach(printjson);
  
    print("=======================================================================================");
    print("Q4. Score 컬렉션에서 중간고사(midterm) 시험의 성적 데이터를 필터링하여 새로운 midtermResults 컬렉션에 저장하자.");
    db.Score.aggregate([
      { $match: { test: "midterm" } }, 
      { $out: "midtermResults" }
    ]);
  
    print("=======================================================================================");
    print("Q5. Score 컬렉션에서 기말고사(final) 시험의 성적 데이터를 필터링하여, 기존의 finalScores 컬렉션에 병합하자.");
    db.Score.aggregate([
      { $match: { test: "final" } }, 
      { $merge: { into: "finalScores", whenMatched: "merge", whenNotMatched: "insert" } }
    ]);
    db.Score.aggregate([
      { $match: { test: "final" } }, 
      { $merge: { into: "finalScores02", whenMatched: "merge", whenNotMatched: "discard" } }
    ]);
  
    print("=======================================================================================");
    print("Q6. INNER JOIN : students 컬렉션과 Score 컬렉션을 이름(name)으로 학생과 그들의 성적을 조회하자.");
    db.students.aggregate([
      { $lookup: { from: "Score", localField: "name", foreignField: "name", as: "res" } },
      { $match: { "res": { "$ne": [] } } }
    ]).forEach(printjson);
  
    print("=======================================================================================");
    print("Q7. OUTER JOIN: students 컬렉션과 Score 컬렉션을 이름(name)으로 매칭하여 출력");
    db.students.aggregate([
      { $lookup: { from: "Score", localField: "name", foreignField: "name", as: "res" } }
    ]).forEach(printjson);
  
    print("=======================================================================================");
    print("Q8-1. CROSS JOIN - 모든 가능한 결과 출력");
    db.students.aggregate([
      { $lookup: { from: "Score", pipeline: [ { $match: {} } ], as: "res" } }
    ]).forEach(printjson);
  
    print("=======================================================================================");
    print("Q8-2. CROSS JOIN - 가능한 결과 개수 출력");
    db.students.aggregate([
      { $lookup: { from: "Score", pipeline: [ { $match: {} } ], as: "res" } },
      { $project:{ name : 1, resCnt  :  { $size : "$res" } } }
    ]).forEach(printjson);
  
    print("=======================================================================================");
    print("Q8-3. CROSS JOIN - 학생-성적 쌍 생성하여 출력 (unwind)");
    db.students.aggregate([
      { $lookup: { from: "Score", pipeline: [ { $match: {} } ], as: "res" } },
      { $unwind: "$res" }
    ]).forEach(printjson);
  
    print("=======================================================================================");
    print("Q9. EQUI JOIN : 이름이 동일한 경우만 데이터를 결합하여 출력");
    db.students.aggregate([
      { $lookup: { from: "Score", localField: "name", foreignField: "name", as: "res" } }
    ]).forEach(printjson);
  }
  
  runAllJoins();
  