// Emp  -Dept 조인 

print("1. INNER JOIN  $lookup + $unwind + $match ")
db.emp.aggregate([
    {
      $lookup: {
        from: "dept",
        localField: "deptno",
        foreignField: "deptno",
        as: "deptInfo"
      }
    },
    { $unwind: "$deptInfo" },
    { $match: { deptInfo: { $ne: null } } }
  ]).forEach(printjson);

print("2. LEFT OUTER JOIN $lookup 기본" ) 
db.emp.aggregate([
    {
      $lookup: {
        from: "dept",
        localField: "deptno",
        foreignField: "deptno",
        as: "deptInfo"
      }
    }
  ]).forEach(printjson); 

print("3. RIGHT OUTER JOIN  직접 구현 필요 ($unionWith + 커스텀) 없음")  

const deptJoin1 = db.dept.aggregate([
  {
    $lookup: {
      from: "emp",
      localField: "deptno",
      foreignField: "deptno",
      as: "empInfo"
    }
  }
]);
 




print("4. FULL OUTER JOIN - $lookup 두 번 + $unionWith");
// emp ->  dept
const empJoin = db.emp.aggregate([
  {
    $lookup: {
      from: "dept",
      localField: "deptno",
      foreignField: "deptno",
      as: "deptInfo"
    }
  },
  {
    $addFields:{source:"emp"}
  }
]);

// dept ->  emp
const deptJoin2 = db.dept.aggregate([
  {
    $lookup: {
      from: "emp",
      localField: "deptno",
      foreignField: "deptno",
      as: "empInfo"
    }
  }
]);

const empJoin2 = db.emp.aggregate([
    {
      //1. emp ->  dept
    $lookup: {
      from: "dept",
      localField: "deptno",
      foreignField: "deptno",
      as: "deptInfo"
    }
    }, 
    {
        $addFields: { source: "emp" }
    }, 

  // 2. $unionWith   dept ->  emp 조인 추가
  {
    $unionWith: {
      coll: "dept",
      pipeline: [
        {
          $lookup: {
            from: "emp",
            localField: "deptno",
            foreignField: "deptno",
            as: "empInfo"
          }
        },
        {
          $addFields: { source: "dept" }
        }
      ]
    }
  }
]);