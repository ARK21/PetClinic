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

public class AddClientServletTest extends Mockito {

    @Test
    public void addClient() throws SQLException, ClassNotFoundException, ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("clientName")).thenReturn("test");
        when(request.getParameter("petType")).thenReturn("Parrot");
        when(request.getParameter("petName")).thenReturn("test");

        int size = UserStore.getUsers().size();
        assertTrue(UserStore.getUsers().size() == size);

        new AddClientServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("clientName");
        verify(request, atLeast(1)).getParameter("petType");
        verify(request, atLeast(1)).getParameter("petName");
        assertFalse(UserStore.getUsers().size() == size);

    }

}