package com.test02.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;




public interface GoodsMapper{	
	@Select("SELECT * FROM goodsinfo")
	@Results({
	    @Result(property = "code", column = "code"),
	    @Result(property = "name", column = "name"),
	    @Result(property = "price", column = "price"),
	    @Result(property = "maker", column = "maker")
	})
	List<GoodsVo> listGoods();

	@Select("SELECT * FROM goodsinfo WHERE code = #{code}")
	@Results({
	    @Result(property = "code", column = "code"),
	    @Result(property = "name", column = "name"),
	    @Result(property = "price", column = "price"),
	    @Result(property = "maker", column = "maker")
	})
	GoodsVo findGoods(String code);
	
	
	@Insert("insert into goodsinfo(code, name, price, maker)\r\n"
			+ "		values (#{code},#{name},#{price},#{maker})\r\n"
			+ " ")
	int insertGoods(GoodsVo vo);
	
	@Delete("delete from goodsinfo where name =#{name}")
	int deleteGoods(String name);
	
	
	@Update("update goodsinfo\r\n"
			+ "		set name =#{name},\r\n"
			+ "		price =#{price},\r\n"
			+ "		maker=#{maker}\r\n"
			+ "		where code =#{code}")
	int updateGoods(GoodsVo vo);
}

