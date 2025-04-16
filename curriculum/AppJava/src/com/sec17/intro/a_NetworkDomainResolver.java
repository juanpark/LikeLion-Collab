package com.sec17.intro;

import java.net.*;
import java.util.Arrays;

public class a_NetworkDomainResolver {

	public static void main(String[] args) {
		String urlString = "https://www.python.org";

		try {
			// 1. 문자열을 URL 객체로 변환
			URL url = URI.create(urlString).toURL();
			System.out.println("URL: " + url);
			System.out.println("프로토콜: " + url.getProtocol());
			System.out.println("호스트명: " + url.getHost());
			System.out.println("경로: " + url.getPath());
			System.out.println("포트: " + (url.getPort() == -1 ? "기본 포트" : url.getPort()));

			// 2. 도메인 → IP 주소 변환
			InetAddress address = InetAddress.getByName(url.getHost());
			System.out.println("도메인 IP 주소: " + address.getHostAddress());

			// 3. IP → 호스트 역변환
			InetAddress reverseLookup = InetAddress.getByName(address.getHostAddress());
			System.out.println("IP의 호스트명 역변환: " + reverseLookup.getHostName());

			// 4. 해당 도메인에 등록된 모든 IP 조회
			InetAddress[] all = InetAddress.getAllByName(url.getHost());
			System.out.println("등록된 IP 주소 목록:");
			Arrays.stream(all).forEach(ip -> System.out.println(" - " + ip.getHostAddress()));

		} catch (MalformedURLException e) {
			System.err.println("URL 형식 오류: " + e.getMessage());
		} catch (UnknownHostException e) {
			System.err.println("도메인 조회 실패: " + e.getMessage());
		}
	}
}
