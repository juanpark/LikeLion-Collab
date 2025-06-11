/*
var res = db.students.find(
    {
        "grades": {
            "$elemMatch": {
                "subject": "수학",
                "score": { "$gte": 90}
            }
        }
    },
    {
        "name": 1,
        "grades.$": 1,
        "_id": 0
    }
).toArray();

print(res)*/

db.students.find(
    {
        "grades": {
            "$elemMatch": {
                "subject": "수학",
                "score": { "$gte": 90}
            }
        }
    },
    {
        "name": 1,
        "grades.$": 1,
        "_id": 0
    }
).forEach(element => {
    print(element)
});
