package com.codegym.mapper;

import com.codegym.model.NewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewModel>{
    @Override
    public NewModel mapRow(ResultSet resultSet) {
        NewModel newModel = new NewModel();
        try {
            newModel.setId(resultSet.getLong("id"));
            newModel.setTitle(resultSet.getString("title"));
            return newModel;
        } catch (SQLException e) {
            return null;
        }

    }
}
