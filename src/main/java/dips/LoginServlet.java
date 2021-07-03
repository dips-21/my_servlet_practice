package dips;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    //5 -->{}
    //6--> {}
    //7 -->{}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cdac",
                "dips", "mypass123")) {
            final String Query = "select PersonID from Person where PersonID=? and password=? ";
            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setInt(1,id);
            stmt.setString(2,password);
            ResultSet resultSet = stmt.executeQuery();
            boolean isValid = false;
            while (resultSet.next()) {
                isValid = true;
            }
            PrintWriter out = response.getWriter();
            if (isValid) {
                out.write("Logged in");
                HttpSession session = request.getSession(true);
                session.setAttribute("isL`1oggedIn", true);
            } else {
                out.write("not matched user id and password");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
