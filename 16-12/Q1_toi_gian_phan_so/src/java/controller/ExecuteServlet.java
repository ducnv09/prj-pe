/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/**
 *
 * @author Asus
 */
public class ExecuteServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExecuteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExecuteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("index.html").forward(request, response);
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
        String numberator_raw = request.getParameter("numberator");
        String denominator_raw = request.getParameter("denominator");
        int numberator;
        int denominator;
        PrintWriter out = response.getWriter();
        try {
            numberator = Integer.parseInt(numberator_raw);
            denominator = Integer.parseInt(denominator_raw);

            if (numberator > 0 && denominator > 0) {
                numberator = numberator / ucln(numberator, denominator);
                denominator = denominator / ucln(numberator, denominator);
                out.println("<h1>" + numberator + "/" + denominator +"</h1>");
            } else {
                out.println("<h1>You must input numerator > 0 and denominator > 0</h1>");
            }
        } catch (NumberFormatException e) {
            out.println("<h1>You must input numerator > 0 and denominator > 0</h1>");
        }
    }

    private int ucln(int a, int b) {
        if (a % b != 0) {
            return ucln(b, a % b);
        } else {
            return b;
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
