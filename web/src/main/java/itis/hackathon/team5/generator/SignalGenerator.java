package itis.hackathon.team5.generator;


import itis.hackathon.team5.dao.SensorDaoImpl;
import itis.hackathon.team5.dao.SensorTypeDao;
import itis.hackathon.team5.dao.SignalDaoImpl;
import itis.hackathon.team5.model.Sensor;

import java.sql.SQLException;
import java.util.List;

public class SignalGenerator {

    private final SensorDaoImpl sensorDao;
    private final SignalDaoImpl signalDao;
    public SignalGenerator() {
        sensorDao = new SensorDaoImpl();
        signalDao = new SignalDaoImpl();
    }

    public void run() {

        try {
            List<Sensor> list = sensorDao.getAll();
            for (Sensor sensor: list) {
                if (sensor.isWork()) {
                    int sensorId = sensor.getId();
                    int value = Generator.getInt(1, SensorTypeDao.getCount(sensorId) + 1);
                    signalDao.save(sensorId, value);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
