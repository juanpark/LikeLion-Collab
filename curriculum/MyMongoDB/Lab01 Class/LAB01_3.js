print("================3. 그룹화 및 집계==============");

print("-- Q1. 부서별 평균 월급을 구하자.")
db.emp.aggregate([
  {$group:{_id:"$deptno", AVG_SAL:{$avg:"$sal"}}},
  {$project:{_id:0,DEPTNO:"$_id", AVG_SAL:1}}
]).forEach(printjson);


print("-- Q2.  직업별 평균 월급을 구하자.")
db.emp.aggregate([
  {$group:{_id:"$job", AVG_SAL:{$avg:"$sal"}}},
  {$project:{_id:0,JOB:"$_id", AVG_SAL:1}}
]).forEach(printjson);

print("-- Q3.  부서별 평균 월급을 구하되 10번 부서의 평균 월급만 출력하자.")
db.emp.aggregate([
  {$match:{deptno:10}},
  {$group:{_id:"$deptno", AVG_SAL:{$avg:"$sal"}}},
  {$project:{_id:0,DEPTNO:"$_id", AVG_SAL:1}}
]).forEach(printjson);

print("-- Q4. 직업별 월급의 합을 구하자")
db.emp.aggregate([
  {$group:{_id:"$job", TOT_SAL:{$sum:"$sal"}}},
  {$project:{_id:0,JOB:"$_id", TOT_SAL:1}}
]).forEach(printjson);

print("-- Q5.직업이 SALESMAN인 사원의 월급의 합을 구하라.")
db.emp.aggregate([
  {$match:{job:"SALESMAN"}},
  {$group:{_id:"$job", TOT_SAL:{$sum:"$sal"}}},
  {$project:{_id:0,JOB:"$_id", TOT_SAL:1}}
]).forEach(printjson);

print("-- Q6. 사원 테이블에서 사원의 최대 월급을 출력하자.")
db.emp.aggregate([
  {$group:{_id:null,MAX_SAL:{$max:"$sal"}}},
  {$project:{_id:0, MAX_SAL:1}}
]).forEach(printjson);

print("-- Q7. 사원테이블에서 사원 최소 월급을 출력하자.")
db.emp.aggregate([
  {$group:{_id:null,MIN_SAL:{$min:"$sal"}}},
  {$project:{_id:0, MIN_SAL:1}}
]).forEach(printjson);

print("-- Q8. 각 부서별 최대 월급을 출력하자.")
db.emp.aggregate([
  {$group:{_id:"$deptno", MAX_SAL:{$max:"$sal"}}},
  {$project:{_id:0,DEPTNO:"$_id", MAX_SAL:1}}
]).forEach(printjson);

print("-- Q9. 사원 테이블에서 커미션이 책정되어 있는 사원의 이름과 커미션을 출력하라")
db.emp.find(
    {comm:{$ne:"", $ne:null}},
    {_id:0, ename:1, comm:1}
).forEach(printjson);

print("-- Q10. 사원 테이블에서 커미션이 책정되지 않은 사원의 이름과 커미션을 출력하라.")
db.emp.find(
    {$or:[{comm:""}, {comm:null}]},
    {_id:0, ename:1, comm:1}
).forEach(printjson);

print("-- Q11. 사원 테이블에서 커미션이 책정되지 않은 사원의 count 출력하라.")
print(db.emp.countDocuments({ $or: [ { comm: "" }, { comm: null } ] }))

db.emp.aggregate([
    {$match:{$or:[{comm:""},{comm:null}]}},
    {$group:{_id:"NO_COMM", COUNT:{$sum:1}}},
    {$project:{_id:0, CONDITION:"_id", COUNT:1}}
]).forEach(printjson);

print("-- Q12: 월급이 5000 이상인 사원의 직업별 월급 합계를 출력해보자  ---"); 
db.emp.aggregate([
    {$match:{sal:{$gte:5000}}},
    {$group:{_id:"$job", total_sal:{$sum:"$sal"}}},
    {$project:{_id:0,job:"$_id",total_sal:1}}
]).forEach(printjson);

print("-- Q13.  직업별 월급의 합을 구하고, 월급의 합이 3000 이하인 사원만 출력해보자.  ");
db.emp.aggregate([
    {$group:{_id:"$job",total_sal:{$sum:"$sal"}}},
    {$match:{total_sal:{$lte:3000}}},
    {$project:{_id:0,Job:"$_id",total_sal:1}}
]).forEach(printjson);
print("TEST");

print("-- Q14.  부서별 월급의 합, 전체 총합 및 세부내역을 출력 해보자.  "); 
const 부서별합 = db.emp.aggregate([
  {
    $group: {
      _id: "$deptno",
      부서총급여: { $sum: "$sal" }
    }
  }
]).toArray();
부서별합.forEach(printjson);
print("=======> :")
const 전체총합 = 부서별합.reduce((acc, d) => acc + d.부서총급여, 0);
print("전체 부서 월급 총합:", 전체총합);

print("========================================================= ")
db.emp.aggregate([
    {
        $group: {
            _id: "$deptno",
            부서별_월급_합: { $sum: "$sal" },
            세부내역: {
          $push: { 
            ename: "$ename",
            sal: "$sal"
          }
        }
      }
    },
    {
      $group: {
        _id: null,
        전체_월급_총합: { $sum: "$부서별_월급_합" }, 
        부서별_상세: {
          $push: {
            deptno: "$_id",
            합계: "$부서별_월급_합",
            사원_리스트: "$세부내역"
          }
        }
      }
    },
    { $project: { _id: 0 } } 
  ]).forEach(printjson); 



print("-- Q15.  직업별 사원의 이름과  월급의 합, 전체 총합 및 세부내역을 출력 해보자.  ");

db.emp.aggregate([
  {
    $group: {
      _id: "$job", 
      직업별_월급_합: { $sum: "$sal" },
      세부내역: {
        $push: {
          ename: "$ename",
          sal: "$sal"
        }
      }
    }
  },
  {
    $group: {
      _id: null,
      전체_월급_총합: { $sum: "$직업별_월급_합" },
      직업별_상세: {
        $push: {
          job: "$_id",
          합계: "$직업별_월급_합",
          사원_리스트: "$세부내역"
        }
      }
    }
  },
  { $project: { _id: 0 } }
]).forEach(printjson);