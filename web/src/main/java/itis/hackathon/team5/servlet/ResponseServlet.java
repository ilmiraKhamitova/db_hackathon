package itis.hackathon.team5.servlet;


import com.google.gson.Gson;
import itis.hackathon.team5.dao.SensorDao;
import itis.hackathon.team5.dao.SignalDao;
import itis.hackathon.team5.model.Sensor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static itis.hackathon.team5.servlet.SignalServlet.*;
import static itis.hackathon.team5.util.DatabaseConnectionUtil.getConnection;

@WebServlet(name = "response", urlPatterns = "/respsignals")
public class ResponseServlet extends HttpServlet {
    public static final String URL = "jdbc:postgresql://localhost:5432/hacaton_db";
    public static final String USER = "hacaton";
    public static final String PASSWORD = "qwerty123";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Map<String, String> signals = new HashMap<>();
        try {
            List<Sensor> sensors = new SensorDao(getConnection(URL, USER, PASSWORD)).getAll();
            for(Sensor s: sensors){
                if (s.isWork()){
                    signals.put(("Датчик №" + s.getId() + " (" + s.getId() + ")"), SignalDao.get(s.getId()));
                } else {
                    signals.put(("Датчик №" + s.getId() + " (" + s.getId() + ")"), "Датчик выключен");
                }
            }
            resp.setContentType("application/json");
            resp.getWriter().write(gson.toJson(signals));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
