db.emp.aggregate([
  {$match:{deptno:{$in:[10,30]}}},
  {$group:{_id:"Add_10_30", "SAL_SUM":{$sum:"$sal"}}
},
{
  $project:{
    _id:0, DEPT:"$_id", SAL_SUM:1
}
}
]).forEach(element => {
  print("DEPT" + element.DEPT + ", SAL_SUM: " + element.SAL_SUM)
});