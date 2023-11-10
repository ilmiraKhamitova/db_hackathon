package itis.hackathon.team5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static itis.hackathon.team5.util.DatabaseConnectionUtil.getConnection;

public class SensorTypeDao {
    public static Integer getCount(int id){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "SELECT * from sensor_types WHERE id=" + id + ";";
            ResultSet resultSet = statement.executeQuery(sql);

            String table_name = null;
            if (resultSet.next()) {
                table_name = resultSet.getString("table_name");
            }

            sql = "select count(*) from " + table_name + ";";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()){
                return resultSet.getInt(1);
            }
            return 0;
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
