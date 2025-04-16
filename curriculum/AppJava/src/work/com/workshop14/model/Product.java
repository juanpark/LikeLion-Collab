package work.com.workshop14.model;

import java.sql.Date;

public class Product {
	private int pdNo;
	private String pdName;
	private String pdSubName;
	private String factNo;
	private Date pdDate;
	private int pdCost;
	private int pdPrice;
	private int pdAmount;
	
	// 생성자
	public Product( ) {}
	public Product(int pdNo, String pdName, String pdSubName, String factNo, Date pdDate, 
					int pdCost, int pdPrice, int pdAmount) {
		this.pdNo = pdNo;
		this.pdSubName = pdSubName;
		this.factNo = factNo;
		this.pdDate = pdDate;
		this.pdCost = pdCost;
		this.pdPrice = pdPrice;
		this.pdAmount = pdAmount;
	}

	// getter, setter
	public int getPdNo() {
		return pdNo;
	}

	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}
	
	public String getPdName() {
		return pdName;
	}
	
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	
	public String getPdSubName() {
		return pdSubName;
	}

	public void setPdSubName(String pdSubName) {
		this.pdSubName = pdSubName;
	}

	public String getFactNo() {
		return factNo;
	}

	public void setFactNo(String factNo) {
		this.factNo = factNo;
	}

	public Date getPdDate() {
		return pdDate;
	}

	public void setPdDate(Date pdDate) {
		this.pdDate = pdDate;
	}

	public int getPdCost() {
		return pdCost;
	}

	public void setPdCost(int pdCost) {
		this.pdCost = pdCost;
	}

	public int getPdPrice() {
		return pdPrice;
	}

	public void setPdPrice(int pdPrice) {
		this.pdPrice = pdPrice;
	}

	public int getPdAmount() {
		return pdAmount;
	}

	public void setPdAmount(int pdAmount) {
		this.pdAmount = pdAmount;
	}
	@Override
	public String toString() {
		return String.format(
				"%9s, %10s, %11s, %6s, %11s, %10s, %10s, %5s",
				pdNo, pdName, pdSubName, factNo, pdDate, pdCost, pdPrice, pdAmount);
	}
	
	
	
	
	

}
