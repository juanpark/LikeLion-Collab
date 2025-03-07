package work.com.workshop3;
// made by 송치호 배열 활용
public class TvTest1 {

    public static class Tv {
        private String name;
        private int price;
        private String description;

        public Tv() {}

        public Tv(String name, int price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%10s %10d %10s", name, price, description);
        }


    }

    public static void main(String[] args) {
        Tv a = new Tv("INFINIA",1500000, "LED TV");
        Tv b = new Tv("XCANVAS",1000000, "LCD TV");
        Tv c = new Tv("CINEMA",2000000, "3D TV");

        Tv tvArray[] = {a,b,c};

        for (Tv tv : tvArray) {
            System.out.println(tv);
        }

        String exp = tvArray[0].name;
        String cheap = tvArray[0].name;
        int maxPrice = tvArray[0].price;
        int minPrice = tvArray[0].price;


        for(int i=0;i<tvArray.length;i++) {
            if(tvArray[i].price>maxPrice) {
                maxPrice = tvArray[i].price;
                exp = tvArray[i].name;
            }

            if(tvArray[i].price<minPrice) {
                minPrice = tvArray[i].price;
                cheap = tvArray[i].name;
            }
        }

        System.out.println("가격이 가장 비싼 제품: " + exp);
        System.out.println("가격이 가장 저렴한 제품: " + cheap);

    }


}