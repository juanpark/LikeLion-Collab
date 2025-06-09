package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLabEventBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabEventBoardApplication.class, args);
	}

}

/*
[1] Postman
POST
http://localhost:8080/posts
Content-Type: application/json

{
  "title": "멋사 벡엔드 15기 최고의 조는 어디인가?",
  "content": "회고2조가 최고라고 하더라!"
}

[2] Postman
POST
http://localhost:8080/comments/3
Content-Type: application/json
{
  "writer": "멋쟁이호랑이",
  "content": "나도 그렇게 생각함"
}

[3] Postman
DELETE 
http://localhost:8080/posts/1

 */