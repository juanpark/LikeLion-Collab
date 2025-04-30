const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const port = 7777; // 원하는 포트 번호

// 1. 미들웨어 등록
app.use(cors());
app.use(bodyParser.json());

// 간단한 데이터 (나중에 데이터베이스 연동 등을 할 수 있습니다.)
const data = { message: 'Hello from Node.js server!' };

// 2. 라우팅 설정 = http 메서드 + 경로
// GET 요청 처리 (예시)
app.get('/', (req, res) => {
    res.send('Hello World!');
    console.log('Hello World!');
  })

app.get('/api/data', (req, res) => {
  res.json(data);
});

app.get('/api/text', (req, res) => {
    res.json(text);
})


// POST 요청 처리 (예시 1)
app.post('/api/data', (req, res) => {
  console.log('Received data:', req.body);
  res.json({ received: req.body });
});

// POST 요청 처리 (예시 2 - 텍스트 전송)
app.post('/api/text', (req, res) => {
    const {text} = req.body;
    console.log('Received Text:', text);
    res.json({ message: `서버가 받은 텍스트 : ${text}`});
  });

// POST 요청 처리 (예시 3 - 유저정보 : 이름, 주소)
app.post('/api/user', (req, res) => {
    const {username, email, addr} = req.body;
    console.log(`Received Text : ${username} ${email} ${addr}`);
    res.json({status:`success`, user : req.body});
});

// POST 요청 처리 (예시 4 - 서버시간 리턴)
app.post('/api/time', (req, res) => {
    const now = new Date();
    res.json({serverTime: now.toISOString()});
});

// 3. 서버시작 
app.listen(port, () => {
  console.log(`Node.js 서버가 http://localhost:${port} 에서 실행 중입니다.`);
});

// POST 요청 처리 (예시 4 - 클라이언트에서 이름을 받아 텍스트 전송 )
// React_Basic/react09_FormSubmit.jsx
app.post('/api/name', (req, res) => {
    const {text} = req.body;
    console.log('Received Text:', text);
    res.json({ message: `서버가 받은 텍스트 : ${text}`});
  });

// 4. 템플릿 엔진 설정 app.set() 

/*
// 5. Error Handler Definition
// 선언
function error(err, req, res, next) {

    // respond with 500 "Integnal Server Error".
    console.error(err.stack);
    res.status(500).send('Internal Server Error');
}
// 라우터 
app.get('/', function() {
    // Caught and passed down to the rrorHandler middleware
    throw new Error('something broke');
});

// 등록
app.use(errorHandle); 
*/

// app.locals 앱 전체 영역, res.locals 요청과 응답 사이클에 한정 
// 템플릿 변수, 전역설정, 앱 공통 데이터 등의 속성 

