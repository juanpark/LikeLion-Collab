package com.sec16.appletree;

import java.util.Scanner;

public class AppleTreeMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("동기화 실험 번호를 입력하세요 (1~5): ");
        int caseNum = scanner.nextInt();

        @SuppressWarnings("resource")
		AppleTreeCompetition competition = switch (caseNum) {
            case 1 -> new AppleTreeCase1_Bug();
            case 2 -> new AppleTreeCase2();
            case 3 -> new AppleTreeCase3_WaitNotify();
            case 4 -> new AppleTreeCase4_Async();
            case 5 -> new AppleTreeCase5_AwaitSignal();
            default -> throw new IllegalArgumentException("Invalid case number");
        };
        competition.startCompetition();
        scanner.close();
    }
}