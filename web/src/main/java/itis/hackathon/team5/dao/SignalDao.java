package itis.hackathon.team5.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class SignalDao {

    private final Connection connection;

    public SignalDao(Connection connection) {
        this.connection = connection;
    }

    public void save(int sensor_id, int value){
        try {
            String sql = "insert into signal (sensor_id, value) values(?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sensor_id);
            preparedStatement.setInt(2, value);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
