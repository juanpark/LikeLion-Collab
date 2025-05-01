
const db = require('../config/db');

exports.getAllTravels = () => {
  return db.query('SELECT * FROM travels');
};

exports.getTravelById = (id) => {
  return db.query('SELECT * FROM travels WHERE id = ?', [id]);
};

exports.createTravel = (data) => {
  const { title, location, googleMapsUrl, startDate, endDate, description, imageUrl } = data;
  return db.query(
    'INSERT INTO travels (title, location, googleMapsUrl, startDate, endDate, description, imageUrl) VALUES (?, ?, ?, ?, ?, ?, ?)',
    [title, location, googleMapsUrl, startDate, endDate, description, imageUrl]
  );
};

exports.updateTravel = (id, data) => {
  const { title, location, googleMapsUrl, startDate, endDate, description, imageUrl } = data;
  return db.query(
    'UPDATE travels SET title = ?, location = ?, googleMapsUrl = ?, startDate = ?, endDate = ?, description = ?, imageUrl = ? WHERE id = ?',
    [title, location, googleMapsUrl, startDate, endDate, description, imageUrl, id]
  );
};

exports.deleteTravel = (id) => {
  return db.query('DELETE FROM travels WHERE id = ?', [id]);
};
