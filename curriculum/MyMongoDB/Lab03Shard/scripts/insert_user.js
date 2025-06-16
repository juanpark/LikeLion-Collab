let bulk = [];
for (let i = 1001; i < 1000000; i++) {
  bulk.push({
    insertOne: {
      document: {
        userId: i,
        name: "userName" + i,
        createdAt: new Date().getTime()
      }
    }
  });

  // 1000건마다 실행
  if (bulk.length === 1000) {
    db.user.bulkWrite(bulk);
    bulk = [];
  }
}
// 남은 데이터 처리
if (bulk.length > 0) {
  db.user.bulkWrite(bulk);
}
