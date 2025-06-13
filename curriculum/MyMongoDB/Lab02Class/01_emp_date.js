/*
1) new Date(): 현재 시간을 반환.
2) ISODate(): MongoDB에서 ISO 형식의 날짜로 데이터를 관리.
3) 날짜 범위 쿼리: $gte, $lte로 시작/종료 날짜 필터링.
4)Aggregation: $year, $month, $dayOfMonth로 날짜의 특정 부분 추출.

$dateAdd        -> adds a specified amount of time to a date
                input: BSON Date object
{
  $dateAdd: {
    startDate: "$createdAt",      // must be a Date
    unit: "day",                  // or "hour", "minute", etc.
    amount: 3                     // add 3 days
  }
}
$dateToString   -> format a Date object into a string based on a template
                input: Bson Date
{
  $dateToString: {
    format: "%Y-%m-%d",
    date: "$createdAt"
  }
}
  •	%Y = Year (e.g. 2025)
	•	%m = Month (01–12)
	•	%d = Day of month
	•	%H, %M, %S = Hour, Minute, Second
*/

// emp 컬렉션 활용 MongoDB 날짜 처리
print("\n-- Q1. 사원의 입사년도(hiredate 기준)를 출력하자. --");
db.emp.aggregate([
  { $project: { _id: 0, ename: 1, 입사년도: { $year: "$hiredate" } } }
]).forEach(printjson);

print("\n-- Q2. 1981년에 입사한 사원의 이름과 입사일을 출력하자. --");
db.emp.aggregate([
  { $addFields: { 입사년도: { $year: "$hiredate" } } },
  { $match: { 입사년도: 1981 } },
  { $project: { _id: 0, ename: 1, hiredate: 1 } }
]).forEach(printjson);

print("\n-- Q2-1. 10월에 입사한 사원의 이름과 입사일을 출력하자. --");
db.emp.aggregate([
  { $addFields: { 입사월: { $month: "$hiredate" } } },
  { $match: { 입사월: 10 } },
  { $project: { _id: 0, ename: 1, hiredate: 1 } }
]).forEach(printjson);

db.emp.find({
  $expr:{$eq:[{$month:"$hiredate"}, 10]}
},
{_id:0,ename:1,hiredate:1});

// when to use $expr: used in find() queries when operators need calculations
// find() field and fixed value comparison
// ex) find employees whoes sal is bigger than comm -> field comparison
db.emp.find({$expr:{$gt:["$sal","$comm"]}});

// ex) find employees whoes sal + comm is larger than 5000. find() $expr $add $gt
db.emp.find({$expr:{$gt:[{$add:["$sal",{$ifNull:["$comm",0]}]}, 5000]}});

print("\n-- Q3. 사원의 입사 요일(숫자 1~7, 일요일~토요일)을 출력하자. --");
db.emp.aggregate([
  { $project: { _id: 0, ename: 1, 입사요일: { $dayOfWeek: "$hiredate" } } }
]).forEach(printjson);

print("\n-- Q4. 월별 입사자 수를 출력하자. --");
db.emp.aggregate([
  { $group: { _id: { month: { $month: "$hiredate" } }, 입사자수: { $sum: 1 } } },
  { $sort: { "_id.month": 1 } },
  { $project: { _id: 0, 입사월: "$_id.month", 입사자수: 1 } }
]).forEach(printjson);

print("\n-- Q5. 입사일을 yyyy-mm-dd 문자열 형식으로 변환하여 출력하자. --");
db.emp.aggregate([
  { $project: { _id: 0, ename: 1, 입사일포맷: { $dateToString: { format: "%Y-%m-%d", date: "$hiredate" } } } }
]).forEach(printjson);

print("\n-- Q6. 입사한지 40년 이상 된 사원을 출력하자. --");
// $$ System Var, $$NOW, $$ROOT: all current Docs, $$CURRENT: current doc, $$REMOVE: $unset and field removal
db.emp.aggregate([
  { $addFields: { 재직일수: { $dateDiff: { startDate: "$hiredate", endDate: "$$NOW", unit: "year" } } } },
  { $match: { 재직일수: { $gte: 40 } } },
  { $project: { _id: 0, ename: 1, hiredate: 1, 재직년수: "$재직일수" } }
]).forEach(printjson);

print("\n-- Q7. 6월에 입사한 사원의 이름과 입사일을 출력하자. --");
db.emp.aggregate([
  { $addFields: { 입사월: { $month: "$hiredate" } } },
  { $match: { 입사월: 6 } },
  { $project: { _id: 0, ename: 1, hiredate: 1 } }
]).forEach(printjson);

print("\n-- Q8. 사원의 입사일 기준 연도별 인원수를 출력하자. --");
db.emp.aggregate([
  { $group: { _id: { year: { $year: "$hiredate" } }, 인원수: { $sum: 1 } } },
  { $project: { _id: 0, 입사년도: "$_id.year", 인원수: 1 } },
  { $sort: { 입사년도: 1 } }
]).forEach(printjson);

print("\n-- Q9. 입사일로부터 현재까지의 정확한 개월 수를 계산하자. --");
db.emp.aggregate([
  { $addFields: { 재직개월수: { $dateDiff: { startDate: "$hiredate", endDate: "$$NOW", unit: "month" } } } },
  { $project: { _id: 0, ename: 1, hiredate: 1, 재직개월수: 1 } }
]).forEach(printjson);

print("\n-- Q10. 11월(입사월=11)에 입사한 사원의 목록을 출력하자. --");
db.emp.aggregate([
  { $addFields: { 입사월: { $month: "$hiredate" } } },
  { $match: { 입사월: 11 } },
  { $project: { _id: 0, ename: 1, hiredate: 1 } }
]).forEach(printjson);