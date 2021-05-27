package com.codegym.dao;

import com.codegym.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
    List<CategoryModel>  findAll();
}
