package com.test01;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

/**
 * MyBatis기반 GoodsInfo Dao 클래스, SqlSessionFactory 초기화 , Mapper xml 호출을 사용한 CRUD
 * 실행
 * 
 */

@Component("test")
public class GoodsDao {
	///// 1. SqlSessionFactory 초기화
	private static SqlSessionFactory factory;
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}// static end

	///// 2. 전체 출력 mybatis.goodsMapper.listgoods
	public List<GoodsVo> listGoods() {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("mybatis.goodsMapper.listgoods");
		}
	}

	//// 3. 상품 추가
	public int insertGoods(GoodsVo vo) {	
		try (SqlSession session = factory.openSession()) {
			     int res  = session.insert("mybatis.goodsMapper.insertgoods", vo);
			     if (res > 0) session.commit();
			     else session.rollback();
			     return res;
		}		
	}

	/// 4. 상품정보 수정 
	public int udpateGoods(GoodsVo vo) {
		try (SqlSession session = factory.openSession()) {
            int res = session.update("mybatis.goodsMapper.updateGoods", vo);
            if (res > 0) session.commit();
            else session.rollback();
            return res;
        }
	}
	/// 5. 상품 삭제(상품명으로 삭제 )  
   public int deleteGoods(String name) {
	   try (SqlSession session = factory.openSession()) {
           int res = session.delete("mybatis.goodsMapper.deleteGoods", name);
           if (res > 0) session.commit();
           else session.rollback();
           return res;
       }
   }   
   ///6. 상품 조회(코드 기준 )  
   public GoodsVo findGoods(String code) {
       try (SqlSession session = factory.openSession()) {
           return session.selectOne("mybatis.goodsMapper.findGoods", code);
       }
   }
}// class end







