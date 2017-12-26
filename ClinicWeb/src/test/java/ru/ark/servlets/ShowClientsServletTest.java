package ru.ark.servlets;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class ShowClientsServletTest extends Mockito {


    @Test
    public void showClient() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
      // new ShowClientsServlet().doGet(request, response);
    }
}