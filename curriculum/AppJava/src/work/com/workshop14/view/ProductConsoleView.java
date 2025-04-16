package work.com.workshop14.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import work.com.workshop14.model.Product;

public class ProductConsoleView {
	// 데이터베이스 컬럼 이름 > 한글 컬럼 이름과 매핑
	private static final Map<String, String> COLUMN_LABELS = Map.ofEntries(
		    Map.entry("PDNO", "제품번호"),
		    Map.entry("PDNAME", "제품카테고리"),
		    Map.entry("PDSUBNAME", "제품명"),
		    Map.entry("FACTNO", "공장번호"),
		    Map.entry("PDDATE", "생산일"),
		    Map.entry("PDCOST", " 원가 "),
		    Map.entry("PDPRICE", " 가격 "),
		    Map.entry("PDAMOUNT", " 재고 "),
		    Map.entry("FACNAME", "공장명"),
		    Map.entry("STONAME", "판매점명"),
		    Map.entry("STAMOUNT", "판매점재고수량")
		    
		);
	
	public void showMessage(String message) {
		System.out.println("[알림]: " + message);
	}
	
	public void createTable(String message) {
		showMessage(message);
	}
	
	public void insertRow(String message) {
		showMessage(message);
	}
	
	public void deleteRow(String message) {
		showMessage(message);
	}
	

	public void deleteTable(String message) {
		showMessage(message);
	}
	
	public void printTable(List<Map<String, Object>> rows) {
        if (rows == null || rows.isEmpty()) {
            System.out.println("출력할 데이터가 없습니다.");
            return;
        }

        // 1. 컬럼 모두 저장하기 (컬럼별 글 길이 포함)
        String[] columns = rows.get(0).keySet().toArray(new String[0]);
        int[] widths = new int[columns.length];
        
        // 2. 컬럼별 헤더 크기 비율로 계산하기 (한글 고려)
        for (int i = 0; i < columns.length; i++) {
            String header = COLUMN_LABELS.getOrDefault(columns[i], columns[i]);
 
            int headerWidth = (int)(header.length() * 1); // 비율 시행착오
            widths[i] = headerWidth;
        }

        // 열 크기와 비교
        for (Map<String, Object> row : rows) {
            for (int i = 0; i < columns.length; i++) {
                Object val = row.get(columns[i]);
                if (val != null) {
                    int valueWidth = val.toString().length();
                    widths[i] = Math.max(widths[i], valueWidth + 2);
                }
            }
        }

        // 3. 헤더 출력하기
        for (int i = 0; i < columns.length; i++) {
            String header = COLUMN_LABELS.getOrDefault(columns[i], columns[i]);
            
            System.out.printf("%-" + (widths[i] - 2) + "s", header);
        }
        System.out.println();

        // 4. 헤더와 열 분리
        for (int i = 0; i < columns.length; i++) {
            System.out.print("-".repeat(widths[i]));
        }
        System.out.println();

        // 5. 각 행 출력
        for (Map<String, Object> row : rows) {
            for (int i = 0; i < columns.length; i++) {
                Object val = row.get(columns[i]);
                System.out.printf("%-" + widths[i] + "s", val != null ? val.toString() : "0");
            }
            System.out.println();
        }
    }

}
