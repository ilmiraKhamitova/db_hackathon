package itis.hackathon.team5.generator;


import itis.hackathon.team5.dao.SensorDao;
import itis.hackathon.team5.dao.SensorTypeDao;
import itis.hackathon.team5.dao.SignalDao;
import itis.hackathon.team5.model.Sensor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SignalGenerator {

    private final SensorDao sensorDao;
    private final SignalDao signalDao;
    private final SensorTypeDao sensorTypeDao;
    public SignalGenerator(Connection connection) {
        sensorDao = new SensorDao(connection);
        signalDao = new SignalDao(connection);
        sensorTypeDao = new SensorTypeDao(connection);

    }

    public void run() {

        try {
            List<Sensor> list = sensorDao.getAll();
            for (Sensor sensor: list) {
                if (sensor.isWork()) {
                    int sensorId = sensor.getId();
                    int value = Generator.getInt(1, sensorTypeDao.getCount(sensor.getType()) + 1);
                    signalDao.save(sensorId, value);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
