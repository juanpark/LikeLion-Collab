package work.com.workshop3;

public class TvTest {
	
	public static class Tv {
		private String name;
		private int price;
		private String descript;
		
		public Tv() {};
		
		// Constructor
		public Tv(String name, int price, String description) {
			this.name = name;
			this.price = price;
			this.descript = descript;
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
		 * @return the descript
		 */
		public String getDescript() {
			return descript;
		}
	
	
	
		/**
		 * @param descript the descript to set
		 */
		public void setDescript(String descript) {
			this.descript = descript;
		}
		
		@Override
		public String toString() {
			return String.format("%10s %10d %10s", name, price, descript);
		}
	}


	public static void main(String[] args) {
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		Tv tv3 = new Tv();
		
		tv1.setName("INFINIA");
		tv1.setPrice(1500000);
		tv1.setDescript("LED TV");
		
		tv2.setName("XCANVAS");
		tv2.setPrice(1000000);
		tv2.setDescript("LCD TV");
		
		tv3.setName("CINEMA");
		tv3.setPrice(2000000);
		tv3.setDescript("3D TV");
		
		Tv[] tvs = {tv1, tv2, tv3};
		
		for (Tv tv : tvs) {
			System.out.println(tv);
		}
		
		int maxPrice = 0;
		for (Tv tv : tvs) {
			if tv
		}
		
	}
}
