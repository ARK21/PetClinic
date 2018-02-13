package ru.ark.servlets;

import models.User;
import store.Storage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {

    private final Storage STORAGE = Storage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("parse from doGEt: " + id);
        req.setAttribute("user", STORAGE.get(id));
        req.getRequestDispatcher("/user/Edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("parse from doPost: " + id);
        String clientName = req.getParameter("clientName");
        String petType = req.getParameter("petType");
        String petName = req.getParameter("petName");
        STORAGE.edit(new User(id, clientName, STORAGE.createPet(petType, petName)));
        resp.sendRedirect("/view");
    }
}
