
const model = require('../models/travelModel'); // 모델 컴포넌트를 가져온다 

// 클라이언트 값을 서버유효성 검사 / 페이지 이동 <클라이언트 값 <-> Dao> <클라이언트 값을 biz <-> dao> <클라이언트 값을 <-> biz>
// pool.promise();를 선언해서 aync/await을 선언해서 사용한다 

exports.getAll = async (req, res) => {
  try {
    const [rows] = await model.getAllTravels();
    res.json(rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.getOne = async (req, res) => {
  try {
    const [rows] = await model.getTravelById(req.params.id);
    if (rows.length === 0) return res.status(404).json({ error: 'Not found' });
    res.json(rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.create = async (req, res) => {
  try {
    await model.createTravel(req.body);
    res.status(201).json({ message: 'Travel created' });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.update = async (req, res) => {
  try {
    await model.updateTravel(req.params.id, req.body);
    res.json({ message: 'Travel updated' });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.delete = async (req, res) => {
  try {
    await model.deleteTravel(req.params.id);
    res.json({ message: 'Travel deleted' });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};
