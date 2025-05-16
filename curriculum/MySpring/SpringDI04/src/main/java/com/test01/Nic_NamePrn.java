package com.test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mynamePrn")
public class Nic_NamePrn {
	Nic_Name nic_name;

	@Autowired // 자동 인젝
	public void setNic_name(Nic_Name nic_name) {
		this.nic_name = nic_name;
	}

	@Override
	public String toString() {
		return "Nic_NamePrn [nic_name=" + nic_name + "]";
	}

}
