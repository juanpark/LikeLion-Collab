package com.test03;

import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GoodsMapper {

    @Select("SELECT * FROM goodsinfo WHERE code = #{code}")
    GoodsVo findGoods(String code);

    @Select("SELECT * FROM goodsinfo")
    List<GoodsVo> listGoods();

    @Insert("INSERT INTO goodsinfo(code, name, price, maker) VALUES(#{code}, #{name}, #{price}, #{maker})")
    int insertGoods(GoodsVo vo);

    @Update("UPDATE goodsinfo SET name=#{name}, price=#{price}, maker=#{maker} WHERE code=#{code}")
    int updateGoods(GoodsVo vo);

    @Delete("DELETE FROM goodsinfo WHERE name = #{name}")
    int deleteGoods(String name);
}
