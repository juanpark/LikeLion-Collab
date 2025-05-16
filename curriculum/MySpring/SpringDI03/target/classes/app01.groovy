beans{
	myaddress(com.sec01.MyAddress,"박길");
	myaddress02(com.sec01.MyAddress,"최제","seoul","111-111-111")
	myaddress03(com.sec01.MyAddress){
		name = "kimkulds"
		addr = "seoul"
		tel = "01-123-4123"
	}
	info(com.sec01.AddressInfo){
		address = ref(myaddress03)
		age = 30;
	}
}