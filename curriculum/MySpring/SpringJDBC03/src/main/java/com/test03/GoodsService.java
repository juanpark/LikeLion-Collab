package com.test03;

import java.util.List;

public interface GoodsService {
    List<GoodsVo> getAll();
    GoodsVo get(String code);
    void add(GoodsVo vo);
    void edit(GoodsVo vo);
    void delete(String name);
}
