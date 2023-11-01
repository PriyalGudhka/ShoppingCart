package com.mycompany.parkingapplication;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author priyalgudhka
 */
@WebServlet(urlPatterns = {"/ParkingApplication.xls"})
public class ParkingApplication extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver"); // Loads the driver

            String url = "jdbc:relique:csv:";
            String csvFilePath = request.getRealPath("/excelsheet");
            String finalURL = url + csvFilePath;

            String fileName = request.getParameter("fileName");
            System.out.println("URL is : " + url);
            Connection con = null;
            try {
                con = DriverManager.getConnection(finalURL);
            } catch (SQLException ex) {
                Logger.getLogger(ParkingApplication.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * from " + fileName);
            out.println("<table border='1'>");
            while (rs.next()) {
                out.println("<tr>");
                String col1 = rs.getString(1);
                String col2 = rs.getString(2);
                String col3 = rs.getString(3);
                String col4 = rs.getString(4);
                String col5 = rs.getString(5);
                String col6 = rs.getString(6);
                String col7 = rs.getString(7);
                String col8 = rs.getString(8);
                String col9 = rs.getString(9);
                String col10 = rs.getString(10);
                String col11 = rs.getString(11);
                String col12 = rs.getString(12);

                out.println("<td>" + col1 + "</td>");
                out.println("<td>" + col2 + "</td>");
                out.println("<td>" + col3 + "</td>");
                out.println("<td>" + col4 + "</td>");
                out.println("<td>" + col5 + "</td>");
                out.println("<td>" + col6 + "</td>");
                out.println("<td>" + col7 + "</td>");
                out.println("<td>" + col8 + "</td>");
                out.println("<td>" + col9 + "</td>");
                out.println("<td>" + col10 + "</td>");
                out.println("<td>" + col11 + "</td>");
                out.println("<td>" + col12 + "</td>");

                out.println("<tr>");

            }

            out.println("</table>");

            out.println("<hr/>");

        } catch (ClassNotFoundException ex) {
            out.println("Class Not Found Exception");
        } catch (SQLException ex) {
            out.println("File Not Found");
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
        processRequest(request, response);
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
