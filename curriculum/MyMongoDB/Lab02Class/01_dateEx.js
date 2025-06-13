//Q1. save current date:
db.collection.insertOne({
    name:"Hong Gil Dong",
    createdAt: new Date()
});

//Q2. extract year, month, date from doc
db.collection.aggregate([
    {$project:{
        _id:0,
        year:{$year:"$createdAt"},
        month:{$month:"$createdAt"},
        day:{$dayOfMonth:"$createdAt"}
    }}
]);

//Q3. extract Name and Year from doc
db.collection.aggregate([
    {$project:{
        _id:0,
        name:"$name",
        year:{$year:"$createdAt"},
    }}
]);
//Q4. King Sejong's name at exireAt for 30 days after NOW
var today = new Date();
var res = new Date(today.setDate(today.getDate() + 30));

var res = db.collection.insertOne({
    name: "King Sejong",
    exireAt: res
});
printjson(res)

//use aggregate
db.collection.aggregate([
    {$project:{
        name:{$literal:"King Sejong"},
        expireAt: {$add:["$$NOW", 1000 * 60 * 60 * 24 * 30] // 30 days from milisec unit
    }}}
]);



//$facet을 활용한 다중 분석
//	•	$facet은 하나의 입력 집합에 대해 여러 개의 파이프라인을 병렬로 실행할 수 있도록 합니다.
//	•	결과는 각각의 이름으로 된 배열 형태의 필드에 들어갑니다.
db.orders.aggregate([ 
  {
    $facet: {
        recentOrders: [
        { $sort: { orderDate: -1 } },
        { $limit: 5 }
        ],
        summaryByStatus: [
            { $group: { _id: "$status", total: { $sum: 1 } } }
        ]
    }
  }
]);
/*
{
  "recentOrders": [
    { ... }, { ... }, ...
  ],
  "summaryByStatus": [
    { "_id": "SHIPPED", "total": 10 },
    { "_id": "PENDING", "total": 5 },
    ...
  ]
}
  */