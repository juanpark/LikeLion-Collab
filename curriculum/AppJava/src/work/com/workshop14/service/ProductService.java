package work.com.workshop14.service;

import java.util.List;
import java.util.Map;

import work.com.workshop14.model.Product;

public interface ProductService {
	// SELECT * FROM PRODUCTS;
	List<Map<String, Object>> selectAllProducts();
	
	// 4-1번 문제
	List<Map<String, Object>> problem4_1();
	
	// 4-2번 문제
	List<Map<String, Object>> problem4_2();
	
	// 4-3번 문제
	String problem4_3();
	
	// 4-4번 문제
	String problem4_4();
	
	// 4-5번 문제
	String problem4_5();
	
	// 7
	String dropDiscarded();
	
	// 8
	List<Map<String, Object>> selectAllDiscarded();

	
	
}
