db.emp.aggregate([
  {$match:{deptno:10}},
  {$group:{_id:"Dept 10", AVG_SAL:{$avg:"$sal"}}
},
{
  $project:{
    _id:0, DEPT:"$_id", AVG_SAL:1
}
}
]).forEach(element => {
  print("DEPT" + element.DEPT + ", Avg: " + element.AVG_SAL)
});