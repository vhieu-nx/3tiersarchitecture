package com.codegym.dao.impl;

import com.codegym.dao.ICategoryDAO;

import com.codegym.mapper.CategoryMapper;
import com.codegym.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
//    @Override
//    public List<CategoryModel> findAll() {
//
//        String sql = "SELECT *FROM category";
//        return query(sql,new CategoryMapper());
//    }

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT *FROM category";
        return query(sql,new CategoryMapper());
    }
}
