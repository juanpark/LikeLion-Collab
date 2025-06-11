db.emp.aggregate([{
            $project: {
                _id: 0,
                ename: 1,
                mgr: {
                    $cond: {
                        if: {
                            $eq: ["$mgr", ""]
                        },
                        then: "N/A",
                        else: "$mgr"
                    }
                }
            }}]);
