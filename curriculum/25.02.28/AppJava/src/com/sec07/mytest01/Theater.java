package com.sec07.mytest01;
/*
여러 영화를 관리하는 영화관 클래스_Theater
- 영화 목록을 배열(Movie[])로 저장
- 영화 목록 출력 (printMovieList())
- 전체 티켓 가격 계산 (printTotalTicketPrice())
 */
public class Theater {
    private Movie[] movieList;

    public Theater(Movie[] movies) {
        movieList = new Movie[movies.length];
        for (int i = 0; i < movies.length; i++) {
            movieList[i] = movies[i];
        }
    }

    public void printMovieList() {
        System.out.println("========= 2025년 상영 예정 영화 목록 ===");
        for (Movie movie : movieList) {
            System.out.printf("%-20s%6d원  (%s 개봉)\n", 
                movie.getTitle(), movie.getTicketPrice(), movie.getReleaseYear());
        }
    }

    public void printTotalTicketPrice() {
        System.out.println("=====================");
        int sum = 0;
        for (Movie movie : movieList) {
            sum += movie.getTicketPrice();
        }
        System.out.println("총 티켓 가격: " + sum + "원");
    }
}
