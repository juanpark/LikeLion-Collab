package work.com.workshop3;


	
class Tv {
	private String name;
	private int price;
	private String description;
	
	// needed when there is a constructor
	public Tv() {};
	
	// Constructor
	public Tv(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}



	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param descript the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10d %-10s", name, price, description);
	}
}

public class TvTest{
	public static void main(String[] args) {
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		Tv tv3 = new Tv();
		
		tv1.setName("INFINIA");
		tv1.setPrice(1500000);
		tv1.setDescription("LED TV");
		
		tv2.setName("XCANVAS");
		tv2.setPrice(1000000);
		tv2.setDescription("LCD TV");
		
		tv3.setName("CINEMA");
		tv3.setPrice(2000000);
		tv3.setDescription("3D TV");
		
		Tv[] tvs = {tv1, tv2, tv3};
		
		for (Tv tv : tvs) {
			System.out.println(tv);
		}
		
		int maxPrice = tvs[0].getPrice();
		for (int i = 0; i < tvs.length; i++) {
			if (tvs[i].getPrice() > maxPrice) {
				maxPrice = i;
			}
		}
		System.out.println("가격이 가장 비싼 제품: " + tvs[maxPrice].getName());
		
		int minPrice = tvs[0].getPrice();
		for (int i = 0; i < tvs.length; i++) {
			if (tvs[i].getPrice() < minPrice) {
				minPrice = i;
			}
		}
		System.out.println("가격이 가장 저렴한 제품: " + tvs[minPrice].getName());
	
		
		
	}
}
