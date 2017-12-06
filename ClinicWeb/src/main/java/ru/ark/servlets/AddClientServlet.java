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

    private final UserStore STORE = UserStore.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request != null) {
            String clientName = request.getParameter("clientName");
            int petType = Integer.valueOf(request.getParameter("petType"));
            String petName = request.getParameter("petName");
            try {
                switch (petType) {
                    case 1:
                        UserStore.add(new User(UserStore.getUsers().size() + 1, clientName, new Cat(petName)));
                        break;
                    case 2:
                        UserStore.add(new User(UserStore.getUsers().size() + 1, clientName, new Dog(petName)));
                        break;
                    case 3:
                        UserStore.add(new User(UserStore.getUsers().size() + 1, clientName, new Parrot(petName)));
                        break;
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
           response.sendRedirect("/view");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}