package com.neu.assignment2_part5;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author priyalgudhka
 */
@WebServlet(urlPatterns = {"/Store.xls"})
public class ReadStoreExcelServlet extends HttpServlet {

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

            String fileName = request.getParameter("fileName");
            String xlsFilePath = request.getRealPath("/excelsheet/") + fileName;

            try ( FileInputStream fis = new FileInputStream(new File(xlsFilePath));  HSSFWorkbook workbook = new HSSFWorkbook(fis)) {
                HSSFSheet worksheet = workbook.getSheetAt(0);
                Iterator<Row> iterator = worksheet.iterator();

                out.println("<table border='1'>");
                while (iterator.hasNext()) {

                    Row row = iterator.next();
                    Iterator<Cell> individualCell = row.cellIterator();
                    out.println("<tr>");

                    while (individualCell.hasNext()) {
                        Cell cell = individualCell.next();
                        switch (cell.getCellType()) {

                            case NUMERIC:
                                out.print("<td>" + cell.getNumericCellValue() + "</td>");
                                break;

                            case STRING:
                                out.print("<td>" + cell.getStringCellValue() + "</td>");
                                break;
                        }
                    }
                    out.println("</tr>");
                }
                out.println("</table>");

            }
        } catch (IOException exception) {
            out.println("File Not Found Exception");

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
