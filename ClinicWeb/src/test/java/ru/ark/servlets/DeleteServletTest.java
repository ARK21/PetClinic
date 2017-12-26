package ru.ark.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DeleteServletTest extends Mockito {

    @Test
    public void deleteClient() throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        int sizeBefore = UserStore.getUsers().size();
        when(request.getParameter("id")).thenReturn("33");
        new DeleteServlet().doGet(request, response);
        int sizeAfter = UserStore.getUsers().size();
        assertTrue(sizeBefore > sizeAfter);
    }
}