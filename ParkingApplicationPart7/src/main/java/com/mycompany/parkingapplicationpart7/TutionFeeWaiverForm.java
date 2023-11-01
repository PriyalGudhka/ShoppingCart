package com.mycompany.parkingapplicationpart7;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author priyalgudhka
 */
@WebServlet(name = "helloServlet", value = "/tutionwaiver")
public class TutionFeeWaiverForm extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String academicTerm = request.getParameter("academicTerm");
            String academicYear = request.getParameter("academicYear");
            String employeeStatus = request.getParameter("employeeStatus");
            String other = request.getParameter("employeeStatusOther");

            String studentName = request.getParameter("name");
            String relationToEmp = request.getParameter("relationToEmployee");
            String northeasternId = request.getParameter("northeasternId");
            String diffEmployeeName = request.getParameter("differentEmpName");
            String employeeId = request.getParameter("employeeNortheasternId");
            String department = request.getParameter("department");
            String campusLocation = request.getParameter("campusLocation");
            String phoneNumber = request.getParameter("phoneNumber");
            String supName = request.getParameter("supervisorName");
            String courseNo1 = request.getParameter("courseNumber1");
            String courseName1 = request.getParameter("courseName1");
            String supervisorSignature1 = request.getParameter("supervisorSignature1");
            String creditHours1 = request.getParameter("creditHours1");
            String day1 = request.getParameter("day1");
            String time1 = request.getParameter("time1");

            String discipline = request.getParameter("discipline");
            String courseNo2 = request.getParameter("courseNumber2");
            String courseName2 = request.getParameter("courseName2");
            String supervisorSignature2 = request.getParameter("supervisorSignature2");
            String creditHours2 = request.getParameter("creditHours2");
            String day2 = request.getParameter("day2");
            String time2 = request.getParameter("time2");

            String courseNo3 = request.getParameter("courseNumber3");
            String courseName3 = request.getParameter("courseName3");
            String supervisorSignature3 = request.getParameter("supervisorSignature3");
            String creditHours3 = request.getParameter("creditHours3");
            String day3 = request.getParameter("day3");
            String time3 = request.getParameter("time3");

            String employeeSignature = request.getParameter("employeeSignature");
            String date = request.getParameter("date");
            String hrmSignature = request.getParameter("hrmSignature");
            String date1 = request.getParameter("hrmDate");

            out.println("<!doctype html>");
            out.println("<html>");
            out.println("<head><title>Tuition Wavier Form</title></head>");
            out.println("<body>");
            out.println("<h2>Tution Fee Waiver Details</h2>");

            out.println("<h4>Academic Term : " + academicTerm + "</h4>");
            out.println("<h4>Academic Year : " + academicYear + "</h4>");
            out.println("<h4>Employee Status : " + employeeStatus + "</h4>");
            out.println("<h4>Other : " + other + "</h4>");
            out.println("<h4>Student Name : " + studentName + "</h4>");
            out.println("<h4>Relation To Employee : " + relationToEmp + "</h4>");
            out.println("<h4>Northeastern Id : " + northeasternId + "</h4>");
            out.println("<h4>Different Employee Name : " + diffEmployeeName + "</h4>");
            out.println("<h4>Employee Northeastern Id : " + employeeId + "</h4>");
            out.println("<h4>Department : " + department + "</h4>");
            out.println("<h4>Campus Location : " + campusLocation + "</h4>");
            out.println("<h4>Phone Number : " + phoneNumber + "</h4>");
            out.println("<h4>Supervisor Name : " + supName + "</h4>");
            out.println("<h4>Program : " + discipline + "</h4>");

            out.println("<h4>Course Number 1 : " + courseNo1 + "</h4>");
            out.println("<h4>Course Name 1 : " + courseName1 + "</h4>");
            out.println("<h4>Supervisor Signature 1 : " + supervisorSignature1 + "</h4>");
            out.println("<h4>Credit Hours 1 : " + creditHours1 + "</h4>");
            out.println("<h4>Day 1 : " + day1 + "</h4>");
            out.println("<h4>Time 1 : " + time1 + "</h4>");

            out.println("<h4>Course Number 2 : " + courseNo2 + "</h4>");
            out.println("<h4>Course Name 2 : " + courseName2 + "</h4>");
            out.println("<h4>Supervisor Signature 2 : " + supervisorSignature2 + "</h4>");
            out.println("<h4>Credit Hours 2 : " + creditHours2 + "</h4>");
            out.println("<h4>Day 2 : " + day2 + "</h4>");
            out.println("<h4>Time 2 : " + time2 + "</h4>");

            out.println("<h4>Course Number 3 : " + courseNo3 + "</h4>");
            out.println("<h4>Course Name 3 : " + courseName3 + "</h4>");
            out.println("<h4>Supervisor Signature 3 : " + supervisorSignature3 + "</h4>");
            out.println("<h4>Credit Hours 3 : " + creditHours3 + "</h4>");
            out.println("<h4>Day 3 : " + day3 + "</h4>");
            out.println("<h4>Time 3 : " + time3 + "</h4>");

            out.println("<h4>Employee Signature : " + employeeSignature + "</h4>");
            out.println("<h4>Employee Signature Date : " + date + "</h4>");
            out.println("<h4>HRM Signature : " + hrmSignature + "</h4>");
            out.println("<h4>Date : " + date1 + "</h4>");

            out.println("</body></html>");
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
