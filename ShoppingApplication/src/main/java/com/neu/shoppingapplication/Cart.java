/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.neu.shoppingapplication;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author priyalgudhka
 */
public class Cart extends HttpServlet {

    private ArrayList<String> books;
    private ArrayList<String> laptops;
    private ArrayList<String> cds;

    public List itemsAddedInBag = new ArrayList();
    public ArrayList<String> displayItemsByCategory;

    @Override
    public void init() {
        books = new ArrayList<>();
        laptops = new ArrayList<>();
        cds = new ArrayList<>();

        books.add("Java Servlet Programming [$29.95]");
        books.add("Oracle Database Programming [$48.95]");
        books.add("System Analysis and Design With UML [$14.95]");
        books.add("Object Oriented Software Engineering [$35.99]");
        books.add("Java Web Services [$27.99]");

        laptops.add("Apple MacBook Pro with 13.3' Display [$1299.99]");
        laptops.add("Asus Laptop with Centrno 2 Black [$949.95]");
        laptops.add("HP Pavlion Laptop with Centrino 2 DV7 [$1199.95]");
        laptops.add("Toshiba Satellite Laptop with Centrino 2- Copper [$899.99]");
        laptops.add("Sony VAIO Laptop with Core 2 DUO [$779.99]");

        cds.add("I'm Going To Tell You A Secret by Madonna [$26.99]");
        cds.add("Baby One More Time by Britney Spears [$10.95]");
        cds.add("Justified by Justin Timberlake [$9.97]");
        cds.add("Loose by Nelly Furtado [$13.98]");
        cds.add("Gold Digger by Kanye West [$27.99]");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession session = request.getSession(true);
            String selectedCategory = request.getParameter("itemsPurchased");
            displayItemsByCategory = new ArrayList<>();
            String itemSelected = request.getParameter("addItem");

            if (selectedCategory == null) {
                selectedCategory = session.getAttribute("category").toString();
            }

            if (selectedCategory.equalsIgnoreCase("Books")) {
                for (int addBook = 0; addBook < books.size(); addBook++) {
                    displayItemsByCategory.add(books.get(addBook));
                }
            } else if (selectedCategory.equalsIgnoreCase("Laptops")) {
                for (int addLaptop = 0; addLaptop < laptops.size(); addLaptop++) {
                    displayItemsByCategory.add(laptops.get(addLaptop));
                }

            } else if (selectedCategory.equalsIgnoreCase("CDs")) {
                for (int addCD = 0; addCD < cds.size(); addCD++) {
                    displayItemsByCategory.add(cds.get(addCD));
                }
            }

            if (itemSelected != null) {
                String[] selectedItems = request.getParameterValues("addItem");
                itemsAddedInBag.addAll(Arrays.asList(selectedItems));
            }

            session.setAttribute("itemsAdded", displayItemsByCategory);
            session.setAttribute("category", selectedCategory);
            session.setAttribute("bagItems", itemsAddedInBag);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException exception) {
                System.out.println(exception);
            }
        } catch (Exception exception) {

            System.out.println(exception);
        } finally {
            request.logout();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String itemsToBeRemoved = request.getParameter("removedItems");
        Object cartItem = session.getAttribute("bagItems");

        if (cartItem.getClass().isArray()) {
            itemsAddedInBag = Arrays.asList((Object[]) cartItem);
        }

        if (itemsToBeRemoved != null) {
            String[] listOfItemsToBeRemoved = request.getParameterValues("removedItems");
            itemsAddedInBag.removeAll(Arrays.asList(listOfItemsToBeRemoved));
        }

        session.setAttribute("bagItems", itemsAddedInBag);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
