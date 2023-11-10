package itis.hackathon.team5.servlet;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import itis.hackathon.team5.dao.SensorDao;
import itis.hackathon.team5.dao.SignalDao;
import itis.hackathon.team5.model.Sensor;

import javax.servlet.ServletConfig;
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

import static itis.hackathon.team5.main.*;
import static itis.hackathon.team5.servlet.SignalServlet.*;
import static itis.hackathon.team5.util.DatabaseConnectionUtil.getConnection;

@WebServlet(name = "response", urlPatterns = "/respsignals")
public class ResponseServlet extends HttpServlet {
    private SignalDao signalDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        signalDao = new SignalDao(getConnection(URL, USER, PASSWORD));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Map<String, Gson> signals = new HashMap<>();
        try {
            List<Sensor> sensors = new SensorDao(getConnection(URL, USER, PASSWORD)).getAll();
            for (Sensor s : sensors) {
                Gson gson1 = new Gson();
                if (s.isWork()) {
                    List<Object> list = signalDao.get(s.getId());
                    gson1.toJson(list);
//                    TODO
                    signals.put(("Датчик №" + s.getId() + " (" + s.getId() + ")"), gson1);
                } else {
                    gson1.toJson("Датчик выключен");
                    signals.put(("Датчик №" + s.getId() + " (" + s.getId() + ")"), gson1);
                }
            }
            resp.setContentType("application/json");
            resp.getWriter().write(gson.toJson(signals));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
