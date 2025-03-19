package com.sec13.myNio;

/*
b_FileCRUD.java
BasicFileAttributes:    기본적인 파일 속성에 접근 (모든 파일 시스템 공통) ->      size(), creationTime(), lastAccessTime(), lastModifiedTime(), isDirectory(), isRegularFile(), isSymbolicLink(), isOther()
DosFileAttributes    :Windows DOS 파일 시스템 속성에 접근    -> isReadOnly(), isHidden(), isArchive(), isSystem()
PosixFileAttributes:    POSIX 호환 파일 시스템(Linux, macOS 등) 속성에 접근 ->    owner(), group(), permissions()
AclFileAttributes:    액세스 제어 목록(ACL) 속성에 접근     -> getEntries()
UserDefinedFileAttributes:    사용자 정의 파일 속성에 접근 ->     list(), read(String name, ByteBuffer dst), write(String name, ByteBuffer src)
FileOwnerAttributeView     : 파일 소유자 속성에 접근 및 수정    -> getOwner(), setOwner(UserPrincipal owner)
PosixFileAttributeView    POSIX : 파일 속성에 접근 및 수정    -> setPermissions(Set<PosixFilePermission> perms)
AclFileAttributeView    : ACL 속성에 접근 및 수정    -> setAcl(List<AclEntry> aclList)
UserDefinedFileAttributeView :    사용자 정의 파일 속성에 접근 및 수정 ->     delete(String name)
FileStoreAttributeView     : 파일 저장소 속성에 접근    -> getTotalSpace(), getUsableSpace(), getUnallocatedSpace()
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;

public class b_FileCRUD {

    private static final String FILE_PATH_STRING = "d:/test/AA.txt"; // 공용 상수
    private static final Path FILE_PATH = Paths.get(FILE_PATH_STRING); //공용 상수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //입력 객체 생성

        while (true) {
            System.out.println("\n파일 작업 메뉴:");
            System.out.println("1. 생성 (Create)");
            System.out.println("2. 읽기 (Read)");
            System.out.println("3. 쓰기 (Update)");
            System.out.println("4. 삭제 (Delete)");
            System.out.println("5. 이동 (Move)");
            System.out.println("6. 파일 정보 보기");
            System.out.println("0. 종료");
            System.out.print("원하는 작업을 선택하세요: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        createFile();
                        break;
                    case "2":
                        readFile();
                        break;
                    case "3":
                        writeFile(scanner);
                        break;
                    case "4":
                        deleteFile();
                        break;
                    case "5":
                        moveFile(scanner);
                        break;
                    case "6":
                        displayFileInfo();
                        break;
                    case "0":
                        System.out.println("프로그램을 종료합니다.");
                        scanner.close();  //스캐너 소멸
                        return;           //메소드 종료
                    default:
                        System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                }
            } catch (IOException e) {
                System.err.println("IO 오류 발생: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("예상치 못한 오류 발생: " + e.getMessage());
            }
        }
    }

    private static void createFile() throws IOException {
        if (!Files.exists(FILE_PATH)) {
            Files.createFile(FILE_PATH);
            System.out.println("파일 생성 완료: " + FILE_PATH_STRING);
        } else {
            System.out.println("파일이 이미 존재합니다: " + FILE_PATH_STRING);
        }
    }

    private static void readFile() throws IOException {
        if (Files.exists(FILE_PATH)) { //경로가 존재하면
            System.out.println("\n파일 내용:");
            List<String> lines = Files.readAllLines(FILE_PATH);
            for (String line : lines) {
                System.out.println(line);
            }
        } else {
            System.out.println("파일이 존재하지 않습니다: " + FILE_PATH_STRING);
        }
    }

    private static void writeFile(Scanner scanner) throws IOException {
        System.out.println("파일에 쓸 내용을 입력하세요 (각 줄 입력 후 Enter, [완료] 입력 시 종료):");
        List<String> linesToWrite = new java.util.ArrayList<>(); //한줄씩 입력받아 저장할 객체
        String line = null; //한줄 입력 받을 변수
        while (true) {
            line = scanner.nextLine(); //한줄 입력 
            if (line.equalsIgnoreCase("[완료]")) { //대소문자 구분하지 않고 괄호 안의 있는 글자가 맞다면 break
                break;
            }
            linesToWrite.add(line); // 리스트객체 add
        }
        /// 파일 쓰기
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) { //버퍼에 쓰겠다.
            for (String content : linesToWrite) { //String으로 풀어서
                writer.write(content); // 버퍼가 가지고 있는 write에 쓰기
                writer.newLine(); //줄바꿈
            }
        }
        System.out.println("파일 쓰기 완료: " + FILE_PATH_STRING);
    }

    private static void deleteFile() throws IOException {
        if (Files.exists(FILE_PATH)) {
            Files.delete(FILE_PATH);
            System.out.println("파일 삭제 완료: " + FILE_PATH_STRING);
        } else {
            System.out.println("파일이 존재하지 않습니다: " + FILE_PATH_STRING);
        }
    }

    private static void moveFile(Scanner scanner) throws IOException {
        if (Files.exists(FILE_PATH)) {
            System.out.print("이동할 대상 경로를 입력하세요: ");
            String targetPathString = scanner.nextLine();
            Path targetPath = Paths.get(targetPathString); //타겟패스
            //대상 경로에 파일이 이미 존재하면 덮어쓰자 StandardCopyOption.REPLACE_EXISTING
            Files.move(FILE_PATH, targetPath, StandardCopyOption.REPLACE_EXISTING); //copyOption:
            System.out.println("파일을 다음 경로로 이동했습니다: " + targetPathString);
            // 파일 경로 업데이트
            // FILE_PATH = targetPath; // final 변수이므로 이렇게 업데이트할 수 없습니다.
            // 필요하다면 FILE_PATH_STRING 변수를 업데이트하고 FILE_PATH를 다시 생성해야 합니다.
            System.out.println("주의: 프로그램 내의 파일 경로는 업데이트되지 않았습니다.");
        } else {
            System.out.println("파일이 존재하지 않습니다: " + FILE_PATH_STRING);
        }
    }

    private static void displayFileInfo() throws IOException {
        if (Files.exists(FILE_PATH)) {
            BasicFileAttributes attrs = Files.readAttributes(FILE_PATH, BasicFileAttributes.class);
            System.out.println("\n파일 정보:");
            System.out.println("  파일 이름: " + FILE_PATH.getFileName());
            System.out.println("  절대 경로: " + FILE_PATH.toAbsolutePath());
            System.out.println("  크기: " + attrs.size() + " bytes");
            System.out.println("  생성 시간: " + formatFileTime(attrs.creationTime()));
            System.out.println("  마지막 접근 시간: " + formatFileTime(attrs.lastAccessTime()));
            System.out.println("  마지막 수정 시간: " + formatFileTime(attrs.lastModifiedTime()));
            System.out.println("  디렉토리 여부: " + Files.isDirectory(FILE_PATH));
            System.out.println("  일반 파일 여부: " + Files.isRegularFile(FILE_PATH));
            System.out.println("  숨김 파일 여부: " + Files.isHidden(FILE_PATH));
            System.out.println("  읽기 가능 여부: " + Files.isReadable(FILE_PATH));
            System.out.println("  쓰기 가능 여부: " + Files.isWritable(FILE_PATH));
            System.out.println("  실행 가능 여부: " + Files.isExecutable(FILE_PATH));
        } else {
            System.out.println("파일이 존재하지 않습니다: " + FILE_PATH_STRING);
        }
    }

    private static String formatFileTime(FileTime fileTime) { //fileTime: 파일이 가지는 시간 정보 객체(파일 수정, 삭제, 이동한 시간 등)
    //현재 운영체제가 가진 파일의 엑세스 타임 정보를 세팅해서 문자열로 리턴해줘
        Instant instant = fileTime.toInstant(); //객체를 초기화 생성
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); //파일이 가진 정보 객체, 시스템 값
        return dateTime.toString(); //데이트타임 객체를 문자열로 리턴
    }
}