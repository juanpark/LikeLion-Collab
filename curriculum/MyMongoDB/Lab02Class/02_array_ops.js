// MongoDB 배열 연산 문제 - students_scores 컬렉션 기반

// Q1. 모든 학생의 이름을 배열로 수집하자.
print("-- Q1. 모든 학생의 이름을 배열로 수집하자. --");
db.students_scores
  .aggregate([{ $group: { _id: null, 이름목록: { $push: "$name" } } }])
  .forEach(printjson);

// Q1-1. 모든 학생의 이름을 중복없이 배열로 수집후 정렬하자 $addToSet, $sortArray
print("");
db.students_scores
  .aggregate([
    { $group: { _id: null, 이름목록: { $addToSet: "$name" } } },
    {
      $project: {
        정렬된이름: { $sortArray: { input: "$이름목록", sortBy: 1 } },
      },
    },
  ])
  .forEach(printjson);

// Q2. 학생별 이름과 국어, 영어 점수를 하나의 배열 객체로 수집하자.
print("-- Q2. 학생별 이름과 국어, 영어 점수를 하나의 배열로 수집하자. --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        목록: { $push: { name: "$name", kor: "$kor", eng: "$eng" } },
      },
    },
  ])
  .forEach(printjson);

// Q2-1. 학생별 이름과 국어, 영어 점수를 하나의 배열 객체로 수집하자. 영어점수 85점 이상만 우수학생
db.students_scores.aggregate([
  {$match:{eng:{$gte:85}}},
  {$group:{_id:null,Top_Student:{$push:{name:"$name", eng:"$eng"}}}}
]).forEach(printjson);


// Q3. 국어 점수가 배열인 경우 총합으로 변환하여 수집하자.
print("-- Q3. 국어 점수가 배열인 경우 총합으로 변환하여 수집하자. --");
db.students_scores
  .aggregate([
    {
      $project: {
        name: 1,
        test: 1,
        kor_total: {
          $cond: {
            if: { $isArray: "$kor" },
            then: { $sum: "$kor" },
            else: "$kor",
          },
        },
      },
    },
  ])
  .forEach(printjson);

  // Q3-1.
  print("-- Q3-1. 국어 점수가 배열인 경우 print avg")
db.students_scores.aggregate([
  {
    $project: {
      name: 1,
      test: 1,
      kor_avg: {
        $cond: {
          if: { $isArray: "$kor" },
          then: { $avg: "$kor" },
          else: "$kor"
        }
      }
    }
  }
]).forEach(printjson);

// Q4. 영어 점수 배열을 만들어 길이를 출력하자.
print("-- Q4. 영어 점수 배열을 만들어 길이를 출력하자. --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        영어배열: { $push: "$eng" },
      },
    },
    {
      $project: {
        _id: 0,
        총영어인원: { $size: "$영어배열" },
      },
    },
  ])
  .forEach(printjson);

// Q5. 이름이 '문'으로 시작하는 학생 이름만 필터링해서 배열로 출력하자.
print("-- Q5. 이름이 '문'으로 시작하는 학생 이름만 필터링 --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        이름목록: { $push: "$name" },
      },
    },
    {
      $project: {
        _id: 0,
        문으로시작: {
          $filter: {
            input: "$이름목록",
            as: "이름",
            cond: { $regexMatch: { input: "$$이름", regex: "^문" } },
          },
        },
      },
    },
  ])
  .forEach(printjson);

// Q5-1
print("-- Q5-1. Filter students whoes name does not start with '이'")
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        이름목록: { $push: "$name" },
      },
    },
    {
      $project: {
        Result: {
          $filter: {
            input: "$이름목록",
            as: "이름",
            cond: {$not:{ $regexMatch: { input: "$$이름", regex: "^이" }}},
          },
        },
      },
    },
  ])
  .forEach(printjson);

// Q6. 이름 배열에서 세 번째 학생만 출력하자.
print("-- Q6. 이름 배열에서 세 번째 학생만 출력하자. --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        이름목록: { $push: "$name" },
      },
    },
    {
      $project: {
        _id: 0,
        세번째학생: { $arrayElemAt: ["$이름목록", 2] },
      },
    },
  ])
  .forEach(printjson);

// Q6-1. 이름 배열에서 last 학생만 출력하자.
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        이름목록: { $push: "$name" },
      },
    },
    {
      $project: {
        _id: 0,
        last학생: { $arrayElemAt: ["$이름목록", {$subtract:[{$size:"$이름목록"},1]}] },
      },
    },
  ])
  .forEach(printjson);

// Q7. 이름 목록을 앞에서 3명만 잘라서 출력하자.
print("-- Q7. 이름 목록에서 앞 3명만 추출하자. --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        이름목록: { $push: "$name" },
      },
    },
    {
      $project: {
        _id: 0,
        상위3명: { $slice: ["$이름목록", 3] },
      },
    },
  ])
  .forEach(printjson);

  // Q7-1 이름 목록을 last 3명만 잘라서 출력하자.
print("-- Q7. 이름 목록에서 앞 3명만 추출하자. --");
db.students_scores.aggregate([
  {
    $group: {
      _id: null,
      이름목록: { $push: "$name" }
    }
  },
  {
    $project: {
      _id: 0,
      Last3명: {
        $slice: ["$이름목록", -3]
      }
    }
  }
])
  .forEach(printjson);

// Q8. 모든 이름을 대문자로 변환하여 배열로 출력하자.
print("-- Q8. 모든 이름을 대문자로 변환하여 배열로 출력하자. --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        이름목록: { $push: "$name" },
      },
    },
    {
      $project: {
        _id: 0,
        대문자이름: {
          $map: {
            input: "$이름목록",
            as: "이름",
            in: { $toUpper: "$$이름" },
          },
        },
      },
    },
  ])
  .forEach(printjson);

// Q9. 모든 이름의 첫 글자만 배열로 출력하자.
print("-- Q9. 모든 이름의 첫 글자만 배열로 출력하자. --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        이름목록: { $push: "$name" },
      },
    },
    {
      $project: {
        _id: 0,
        첫글자목록: {
          $map: {
            input: "$이름목록",
            as: "이름",
            in: { $substrCP: ["$$이름", 0, 1] },
          },
        },
      },
    },
  ])
  .forEach(printjson);

// Q10. 중복 없이 이름을 배열로 수집하자.
print("-- Q10. 중복 없이 이름을 배열로 수집하자. --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        유일이름목록: { $addToSet: "$name" },
      },
    },
  ])
  .forEach(printjson);

  // Q11. 중복 없이 이름을 배열로 수집하자.
print("-- Q11. 중복 없이 이름을 배열로 수집하자. --");
db.students_scores
  .aggregate([
    {
      $group: {
        _id: null,
        유일이름목록: { $addToSet: "$name" },
      }
    }, {
      $out:"result"

    }
  ])
  .forEach(printjson);
