
const mysql = require('mysql2');

const pool = mysql.createPool({
  host: 'localhost',
  user: 'mydb',
  password: 'admin1234', // 실제 비밀번호로 변경
  database: 'travel_db'
});

module.exports = pool.promise();

/*
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/my_emp
user=mydb
password=admin1234
*/