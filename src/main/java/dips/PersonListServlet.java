package dips;

import com.sun.net.httpserver.HttpServer;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
code in servlet library
Object userServlet= getServlet(className) //classname from web.xml ,create object using reflection
if(userServlet instanceof HttpServlet){
    HttpServlet s=(HttpServlet)userServlet
if (http get)
s.doGet()
        else if (http post)
s.doPost()
Servlet s;}
else{ GenericServlet s=(GenericServlet)userServlet
        s.service()
        }*/

public class PersonListServlet extends HttpServlet {
    final List<Person> personList = new ArrayList<>(5);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        final String Query = "insert into PersonList values(?,?, ?,?,?)";
        String name = request.getParameter("name");
      Person matchedPerson=null;
        for (Person p : personList) {
            if(p.name.equals(name)) {
               matchedPerson=p;
                break;
            }
        }
        if(matchedPerson!=null) {
            String msg = String.format("name:%s , age: %s , hobby: %s", matchedPerson.name, matchedPerson.age, matchedPerson.hobby);
            out.write(msg);
        }else {
            out.write("person is not registered");
        }

out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("sex");
        int contact = Integer.parseInt(request.getParameter("contact"));
        String address = request.getParameter("address");
        String hobby = request.getParameter("hobby");
             List<Person> personList = new ArrayList<>(5);
            //Person person = new Person(name, age, gender, contact, address, hobby);
          //  personList.add(person);


        out.write("person registered");
        out.close();

        }

        }


