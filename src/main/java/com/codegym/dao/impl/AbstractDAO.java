package com.codegym.dao.impl;

import com.codegym.dao.GenericDAO;
import com.codegym.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T>{
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jspservletjdbc";
            String username = "root";
            String password = "123456";
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public List<T> query(String sql, RowMapper rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //set parameter
            setParameter(preparedStatement,parameters);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add((T) rowMapper.mapRow(resultSet));
            }
            return results;

        } catch (SQLException e) {
            return null;
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
    }

    private void setParameter(PreparedStatement preparedStatement, Object... parameters) {
        try {
            for (int i = 0; i <=parameters.length ; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long){
                    preparedStatement.setLong(index,(Long) parameter);
                }else if (parameter instanceof String){
                    preparedStatement.setString(index,(String) parameter);
                }
                else if (parameter instanceof Integer){
                    preparedStatement.setInt(index,(Integer) parameter);
                }else if (parameter instanceof Timestamp){
                    preparedStatement.setTimestamp(index,(Timestamp) parameter);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
