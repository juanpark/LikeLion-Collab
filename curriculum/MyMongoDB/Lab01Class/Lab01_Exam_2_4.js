db.emp.aggregate([
  {$match:{job:"SALESMAN"}},
  {$group:{_id:"SALESMAN", "AVG_SAL":{$avg:"$sal"}, "TOT_SAL":{$sum:"$sal"}}
},
{
  $project:{
    _id:0, Job:"$_id", AVG_SAL:1, TOT_SAL:1
}
}
]).forEach(element => {
  print("Job" + element.job + ", AVG_SAL: " + element.AVG_SAL + ", TOT_SAL: " + element.TOT_SAL)
});