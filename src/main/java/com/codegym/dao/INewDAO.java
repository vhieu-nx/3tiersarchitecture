package com.codegym.dao;

import com.codegym.model.NewModel;


import java.util.List;

public interface INewDAO extends GenericDAO<NewModel>{
    List<NewModel> findByCategoryId(Long categoryId);
    Long save(NewModel newModel);

}
