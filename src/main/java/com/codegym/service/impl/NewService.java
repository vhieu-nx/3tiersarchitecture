package com.codegym.service.impl;
import com.codegym.dao.INewDAO;
import com.codegym.model.NewModel;
import com.codegym.service.INewService;

import javax.inject.Inject;
import java.util.List;

public class NewService implements INewService {
@Inject
private INewDAO newDAO;
    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {

        return newDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewModel save(NewModel newModel) {
        Long newId = newDAO.save(newModel);
        System.out.println(newId);
        return null;
    }
}
