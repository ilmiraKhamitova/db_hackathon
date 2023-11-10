package itis.hackathon.team5.servlet;


import com.google.gson.Gson;
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
        Map<String, String> signals = new HashMap<>();
        try {
            List<Sensor> sensors = new SensorDao(getConnection(URL, USER, PASSWORD)).getAll();
            for (Sensor s : sensors) {
                Gson gson1 = new Gson();
                if (s.isWork()) {
                    List<String> list = signalDao.get(s.getId(), s.getType());
//                    TODO
                    String res = list.toString();
                    signals.put(("Sensor #" + s.getId()), res.substring(1, res.length() - 1));
                } else {
                    signals.put(("Sensor #" + s.getId()), "Sensor dead");
                }
            }
            System.out.println(gson.toJson(signals));
            resp.setContentType("application/json");
            resp.getWriter().write(gson.toJson(signals));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
