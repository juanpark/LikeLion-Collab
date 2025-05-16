beans {
    myCollection(com.sec04.MyCollection) {
        items = ["Item A", "Item B", "Item C"] 

        myarray = ["Item A array", "Item B array", "Item C array"] 
        myset = ["Item A0set", "Item B1set", "Item C2set"] 

        mymap = [ // Map
            "key1": "Item A0set",
            "key2": "Item B1set",
            "key3": "Item A2set"
        ]

        myAddr = [ 
            "person1": ref("my01"),  //id가 my01인 bean 참조 
            "person2": ref("my02")
        ]
    }

    my01(com.sec01.MyAddress) {
        constructorArg(0, "홍길동")
        constructorArg(1, "서울시")
        constructorArg(2, "02-0000-000")
    }

    my02(com.sec01.MyAddress,"정길동","제주도" ,"00-0000-000")
}

