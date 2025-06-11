db.Product.aggregate([{
        $match: {
            Category: "material",
            Price: {
                $gte: 50,
            },
        },
    },
    {
        $group: {
            _id: null,
            total_price: {
                $sum: {
                    $cond: {
                        if: {
                            $gt: ["$Price", 150],
                        },
                        then: {
                            $multiply: ["$Price", 0.9],
                        },
                        else: "$Price",
                    },
                },
            },
        },
    },
    {
        $project: {
            _id: 0,
            total_price: 1,
        },
    },
]);