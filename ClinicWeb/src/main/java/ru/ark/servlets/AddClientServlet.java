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

public class AddClientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request != null) {
            String clientName = request.getParameter("clientName");
            String petType = request.getParameter("petType");
            String petName = request.getParameter("petName");
            try {
                UserStore.add(new User(1, clientName, UserStore.createPet(petType, petName)));
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
           response.sendRedirect("/view");
        }

    }
}