package com.test03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper mapper;

    @Override
    public List<GoodsVo> getAll() {
        return mapper.listGoods();
    }

    @Override
    public GoodsVo get(String code) {
        return mapper.findGoods(code);
    }

    @Override
    @Transactional
    public void add(GoodsVo vo) {
        mapper.insertGoods(vo);
    }

    @Override
    @Transactional
    public void edit(GoodsVo vo) {
        mapper.updateGoods(vo);
    }

    @Override
    @Transactional
    public void delete(String name) {
        mapper.deleteGoods(name);
    }
}
