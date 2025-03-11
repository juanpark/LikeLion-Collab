package com.sec07.mytest01;

public class TheaterTest {
    public static void main(String[] args) {
        Movie[] movies = new Movie[3];
        movies[0] = new Movie("아바타 3", 18000, "2025년");
        movies[1] = new Movie("아이언맨 리턴즈", 20000, "2025년");

        movies[2] = new Movie();
        movies[2].setTitle("인터스텔라 2");
        movies[2].setTicketPrice(19000);
        movies[2].setReleaseYear("2025년");

        Theater theater = new Theater(movies);
        theater.printMovieList();
        theater.printTotalTicketPrice();
    }
}
