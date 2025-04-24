
let score = 85;
if (score >= 90) {
  console.log("A 학점");
} else if (score >= 80) {
  console.log("B 학점");
} else {
  console.log("C 이하");
}
let m_avg = Math.floor(score / 10);
switch (m_avg) {
  case 10:
  case 9: console.log("A"); break;
  case 8: console.log("B"); break;
  case 7: console.log("C"); break;
  default : console.log("F"); break;
}