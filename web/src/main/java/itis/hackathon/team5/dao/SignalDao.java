package itis.hackathon.team5.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SignalDao {

    private final Connection connection;

    public SignalDao(Connection connection) {
        this.connection = connection;
    }

    public void save(int sensorId, int value) throws SQLException {
        String sql = "insert into signal (sensor_id, value) values(?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, sensorId);
        preparedStatement.setInt(2, value);

        preparedStatement.executeUpdate();
    }

    public List<Object> get(int sensorId) throws SQLException {

//        search value id

        Statement statement = connection.createStatement();
        String sql = "select * from signal where sensor_id=" + sensorId + " order by id desc limit 1;";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int valueId = resultSet.getInt("value");


//        search table name

        statement = connection.createStatement();
        sql = "SELECT * from sensor_types WHERE id=" + sensorId + ";";
        resultSet = statement.executeQuery(sql);

        String tableName = null;
        if (resultSet.next()) {
            tableName = resultSet.getString("table_name");
        }

//        get columns number

        statement = connection.createStatement();
        sql = "select column_count from (select table_name, count(*) as column_count" +
                " from information_schema.\"columns\" " +
                " where table_schema = 'public' " +
                "GROUP by table_name order by column_count desc) as tncc where table_name ='" + tableName + "';";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        int number = resultSet.getInt(1);

//        get value

        statement = connection.createStatement();
        sql = "select * from " + tableName + " where id=" + valueId + ";";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        List<Object> list = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            list.add(resultSet.getObject(i));
        }

        return list;
    }
}
