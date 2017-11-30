package ru.ark.servlets;

import ru.ark.Clinic.Cat;
import ru.ark.Clinic.Dog;
import ru.ark.Clinic.Parrot;
import ru.ark.Clinic.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClinicServlet extends HttpServlet {

    final List<Pet> pets = new CopyOnWriteArrayList<Pet>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "     <title>Clinic Pets</title>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Add panel:</h1>" +
                        addForm(req) +
                        this.viewPets(this.pets) +
                        "<hr>" +
                        searchForm(req) +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        add(req);
        doGet(req, resp);
    }


    private String viewPets(List<Pet> pets) {
        StringBuilder sb = new StringBuilder();
        if (!pets.isEmpty()) {
            sb.append("<p style='font-weight:bold'>Pets:</p>");
            sb.append("<table style='border: 1px solid black'>");
            sb.append("<tr><td style='border: 2px solid black'>").append("Type").append("</td>")
                    .append("<td style='border: 2px solid black'>").append("Name").append("</td></tr>");
            for (Pet pet : pets) {
                sb.append("<tr><td style='border: 2px solid black'>").append(pet.getClass().getSimpleName())
                        .append("</td>").append("<td style='border: 2px solid black'>").append(pet.getName())
                        .append("</td></tr>");
            }
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String addForm(HttpServletRequest req) {
        return "   <form action='" + req.getContextPath() + "/' method='post'>" +
                "   Pet type:" +
                "   <select name='typePet'>" +
                "   <option value='1'>Cat" +
                "   <option value='2'>Dog" +
                "   <option value='3'>Parrot" +
                "   </select>" +
                "   Pet name:" +
                "   <input type='text' name='nameAdd'>" +
                "   <input type='submit' name='add'  value='Add'>" +
                "   </form>";
    }

    private void add(HttpServletRequest req) {
        if (req.getParameter("nameAdd") != null) {
            String petName = req.getParameter("nameAdd");
            String typePet = req.getParameter("typePet");
            switch (Integer.valueOf(typePet)) {
                case 1:
                    this.pets.add(new Cat(petName));
                    break;
                case 2:
                    this.pets.add(new Dog(petName));
                    break;
                case 3:
                    this.pets.add(new Parrot(petName));
                    break;
            }

        }
    }

    private String searchForm(HttpServletRequest req) {
        return "<h1>Search panel</h1>" +
                "   <form action='" + req.getContextPath() + "/' method='post'>" +
                " Pet name:" +
                " <input type='text' name='searchPet'>" +
                " <input type='submit' name='search' value='Search'>" +
                search(req) +
                " </form>";
    }

    private String search(HttpServletRequest req) {
        String result = "<br>";
        if (req.getParameter("searchPet") != null) {
            List<Pet> searchedList = new ArrayList<Pet>();
            for (Pet pet : this.pets) {
                if (pet.getName().equalsIgnoreCase(req.getParameter("searchPet"))) {
                    searchedList.add(pet);
                }
            }
            if (searchedList.isEmpty()) {
                result = "<p style='text-decoration:underline'>Pet wasn't find</p>";
            } else result = viewPets(searchedList);
        }
        return result;
    }
}
