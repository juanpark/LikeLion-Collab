db.Product.aggregate([
{$match : {Category :"food"}}
]);