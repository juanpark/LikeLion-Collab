package com.test01;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

/*
* MyBatis 기반 GoodsInfo Dao 클래스
* SqlSessionFactory 초기화
* Mapper xml 호출을 사용한 CRUD 실행
* */


@Component("test")
public class GoodsDao {

  // 1. SqlSessionFactory 초기화
  private static final SqlSessionFactory sqlSessionFactory;
  static{
    try {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // 2. 전체 출력 mybatis.goodsMapper.listgoods
  public List<GoodsVo> listGoods(){
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      List<GoodsVo> all = sqlSession.selectList("mybatis.goodsMapper.listGoods");
      return all;
    }
  }

  // 3. 상품 추가
  public int insertGoods(GoodsVo vo){
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      int res = sqlSession.insert("mybatis.goodsMapper.insertGoods",vo);
      if(res > 0){
        sqlSession.commit();
      }else{
        sqlSession.rollback();
      }
      return res;
    }
  }

  // 4. 상품정보 수정
  public int updateGoods(String name){
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      int res = sqlSession.update("mybatis.goodsMapper.updateGoods",name);
      if(res > 0){
        sqlSession.commit();
      }else{
        sqlSession.rollback();
      }
      return res;
    }
  }

  // 5. 상품 삭제(상품명으로 삭제)
  public GoodsVo findGoods(String code){
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      return sqlSession.selectOne("mybatis.goodsMapper.findGoods",code);
    }
  }
}
