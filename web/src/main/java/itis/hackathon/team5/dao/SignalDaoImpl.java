package itis.hackathon.team5.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static itis.hackathon.team5.generator.Generator.getInt;
import static itis.hackathon.team5.util.DatabaseConnectionUtil.getConnection;

public class SignalDaoImpl {
    public void save(int sensor_id, int value){
        try {
            String sql = "insert into signal (sensor_id, value) values(?,?);";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, sensor_id);
            preparedStatement.setInt(2, value);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
