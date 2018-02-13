package ru.ark.servlets;

import store.Storage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ShowClientsServlet extends HttpServlet {

    private final Storage STORAGE = Storage.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", STORAGE.values());
        request.getRequestDispatcher("/user/View.jsp").forward(request,response);

    }
}
