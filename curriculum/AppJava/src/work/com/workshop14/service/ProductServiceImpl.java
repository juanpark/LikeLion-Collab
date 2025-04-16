package work.com.workshop14.service;

import java.util.List;
import java.util.Map;

import work.com.workshop14.dao.*;
import work.com.workshop14.model.Product;

public class ProductServiceImpl implements ProductService {

	private final ProductDao dao = new ProductDaoImpl();

	@Override
	public List<Map<String, Object>> selectAllProducts() {
		return dao.selectAllProducts();
	}

	@Override
	public List<Map<String, Object>> problem4_1() {
		// TODO Auto-generated method stub
		return dao.problem4_1();
	}

	@Override
	public List<Map<String, Object>> problem4_2() {
		// TODO Auto-generated method stub
		return dao.problem4_2();
	}

	@Override
	public String problem4_3() {
		return dao.problem4_3();
	}

	@Override
	public String problem4_4() {
		// TODO Auto-generated method stub
		return dao.problem4_4();
	}

	@Override
	public String problem4_5() {
		// TODO Auto-generated method stub
		return dao.problem4_5();
	}

	@Override
	public List<Map<String, Object>> selectAllDiscarded() {
		// TODO Auto-generated method stub
		return dao.selectAllDiscarded();
	}

	@Override
	public String dropDiscarded() {
		// TODO Auto-generated method stub
		return dao.dropDiscarded();
	}

}
