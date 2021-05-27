package com.codegym.service.impl;

import com.codegym.dao.ICategoryDAO;
import com.codegym.dao.impl.CategoryDAO;
import com.codegym.model.CategoryModel;
import com.codegym.service.ICategoryService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {
    //    private ICategoryDAO categoryDAO;
//    public CategoryService(){
//        categoryDAO  = new CategoryDAO();
//    }
    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
