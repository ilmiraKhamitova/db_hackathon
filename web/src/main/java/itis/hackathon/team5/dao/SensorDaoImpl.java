package itis.hackathon.team5.dao;

import itis.hackathon.team5.model.Sensor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static itis.hackathon.team5.util.DatabaseConnectionUtil.getConnection;

public class SensorDaoImpl {

    public List<Sensor> getAll() throws SQLException {
        Statement statement = getConnection().createStatement();
        String sql = "SELECT * from sensor";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Sensor> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(
                        new Sensor(
                            resultSet.getInt("id"),
                            resultSet.getInt("type"),
                            resultSet.getBoolean("work"),
                            resultSet.getTimestamp("date")
                        )
                );
            }
        return list;
    }
}
