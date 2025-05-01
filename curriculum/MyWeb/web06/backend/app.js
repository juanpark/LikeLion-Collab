
const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors());
app.use(express.json());
app.use('/api/travels', require('./routes/travelRoutes'));

// 테스트용 기본 라우트
app.get('/', (req, res) => {
  res.send('Backend server is running');
});

// 여행지 관련 API 엔드포인트는 여기에 추가 예정
// app.use('/api/travels', require('./routes/travelRoutes'));

const PORT = 3001;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
