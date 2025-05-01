
const mysql = require('mysql2'); // mysql 플러그인 호출 

const pool = mysql.createPool({
  host: 'localhost',
  user: 'mydb',
  password: 'admin1234', // 실제 비밀번호로 변경
  database: 'travel_db'
});

module.exports = pool.promise();  // DB 연결 객체를 promise 기반으로 내보내겠다 

/*
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/my_emp
user=mydb
password=admin1234
*/