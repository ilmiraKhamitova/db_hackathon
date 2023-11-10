package itis.hackathon.team5.servlet;

import itis.hackathon.team5.dao.SensorDao;
import itis.hackathon.team5.model.Sensor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static itis.hackathon.team5.util.DatabaseConnectionUtil.getConnection;

@WebServlet(name="signals", urlPatterns = "/signals")
public class SignalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/signal.ftl");
    }
}
