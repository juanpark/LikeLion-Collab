package com.sec07.mytest01;
/*
 * 영화 클래스
- 영화의 제목(title), 티켓 가격(ticketPrice), 개봉 연도(releaseYear) 저장
-생성자 및 getter/setter를 통해 영화 정보를 관리
 * 
 * 
 */
public class Movie {
    private String title;
    private int ticketPrice;
    private String releaseYear;

    public Movie() { }

    public Movie(String title, int ticketPrice, String releaseYear) {
        this.title = title;
        this.ticketPrice = ticketPrice;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
