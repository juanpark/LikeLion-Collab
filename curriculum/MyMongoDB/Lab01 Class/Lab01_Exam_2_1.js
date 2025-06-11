db.emp.aggregate([
{
  $group:
  {
    _id:null,
    MAX_SAL:{$max:"$sal"},
    MIN_SAL:{$min:"$sal"},
    TOTAL_SAL:{$sum:"$sal"},
    AVG_SAL:{$avg:"$sal"},
    EMP_COUNT:{$sum:1}
  }
},
{
  $project:{
    _id:0,
    //MAX_SAL:1,
    //MIN_SAL:1,
    //TOTAL_SAL:1,
    //AVG_SAL:1,
    //EMP_COUNT:1
}
}
]).forEach(element => {
  print("Max: " + element.MAX_SAL + "\nMin: " + element.MIN_SAL + "\nAvg: " + element.AVG_SAL + "\nCount: " + element.EMP_COUNT)
});