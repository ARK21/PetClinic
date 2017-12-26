package ru.ark.servlets;


import models.User;
import ru.ark.Clinic.Cat;
import ru.ark.Clinic.Dog;
import ru.ark.Clinic.Parrot;
import store.UserStore;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class ShowClientsServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", UserStore.getUsers());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/user/View.jsp").forward(request,response);

    }
}
