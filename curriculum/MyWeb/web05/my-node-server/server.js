const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const port = 7777; // 원하는 포트 번호

app.use(cors());
app.use(bodyParser.json());

// 간단한 데이터 (나중에 데이터베이스 연동 등을 할 수 있습니다.)
const data = { message: 'Hello from Node.js server!' };

// GET 요청 처리 (예시)
app.get('/api/data', (req, res) => {
  res.json(data);
});

// POST 요청 처리 (예시)
app.post('/api/data', (req, res) => {
  console.log('Received data:', req.body);
  res.json({ received: req.body });
});

app.listen(port, () => {
  console.log(`Node.js 서버가 http://localhost:${port} 에서 실행 중입니다.`);
});