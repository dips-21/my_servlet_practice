package dips;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonServlet extends HttpServlet {
    final List<Person> personList = new ArrayList<>(5);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.write("results are ......");
        response.setContentType("text/html");
        final String Query = "select * from Person where name=? ";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cdac", "dips", "mypass123")) {

            PreparedStatement stmt = conn.prepareStatement(Query);
            String name = request.getParameter("name");
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                out.write("<html><body>");
                out.write("<br>");
                out.write("ID: " + rs.getInt("PersonID"));
                out.write(",Name: " + rs.getString("name"));
                out.write(",Age: " + rs.getInt("age"));
                out.write(",Gender: " + rs.getString("gender"));
                out.write(",Contact: " + rs.getInt("contact"));
                out.write(",Address: " + rs.getString("address"));
                out.write(",Hobby: " + rs.getString("hobby"));
                out.write("</br>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            out.write("</body> </html>");
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        int contact = Integer.parseInt(request.getParameter("contact"));
        String address = request.getParameter("address");
        String hobby = request.getParameter("hobby");

        Person person = new Person(id, name, age, gender, password, contact, address, hobby);
        try {
            save(person);
            out.write("person registered");
        } catch (SQLException e) {
            out.write("could not save" + e);
        } finally {
            out.close();
        }

    }


    void save(Person person) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cdac",
                "dips", "mypass123")) {
            final String Query = "insert into Person values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setInt(1, person.id);
            stmt.setString(2, person.name);
            stmt.setInt(3, person.age);
            stmt.setString(4, person.gender);
            stmt.setInt(5, person.contact);
            stmt.setString(6, person.address);
            stmt.setString(7, person.hobby);
            stmt.setString(8, person.password);
            int rs = stmt.executeUpdate();

        }
    }


}
