package com.codegym.dao.impl;

import com.codegym.dao.INewDAO;
import com.codegym.mapper.NewMapper;
import com.codegym.model.CategoryModel;
import com.codegym.model.NewModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news WHERE categoryid = ?";
        return query(sql, new NewMapper(), categoryId);
    }

    @Override
    public Long save(NewModel newModel) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        Long id = null;
        try {
            String sql = "Insert into news(title,contend,categoryid) values (?,?,?)";
             connection = getConnection();preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,newModel.getTitle());
            preparedStatement.setString(2,newModel.getContent());
            preparedStatement.setLong(3,newModel.getCategoryId());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                id =   resultSet.getLong(1);
            }
            connection.commit();
            return id;

        } catch (SQLException e) {
            if (connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
