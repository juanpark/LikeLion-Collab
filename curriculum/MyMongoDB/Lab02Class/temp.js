db.students.aggregate([
{
$lookup: {
from: "Score",
localField: "name",
foreignField: "name",
as: "scoreInfo"
}
}
])