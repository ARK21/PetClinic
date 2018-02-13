package ru.ark.servlets;

import models.User;
import store.Storage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddClientServlet extends HttpServlet {

    private final Storage STORAGE = Storage.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request != null) {
            String clientName = request.getParameter("clientName");
            String petType = request.getParameter("petType");
            String petName = request.getParameter("petName");
            STORAGE.add(new User(0, clientName, STORAGE.createPet(petType, petName) ));
            response.sendRedirect("/view");
        }

    }
}