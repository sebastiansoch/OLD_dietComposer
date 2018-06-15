/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author Seba
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
        
        List<DishTapeInfo> meals = new ArrayList<>();
        meals.add(new DishTapeInfo(DishType.BREAKFAST, "Sniadanie"));
        meals.add(new DishTapeInfo(DishType.SECOND_BREAKFAST, "Drugie Sniadanie"));
        meals.add(new DishTapeInfo(DishType.SOUP, "Zupa"));
        meals.add(new DishTapeInfo(DishType.MAIN_COURSE, "Drugie danie"));
        meals.add(new DishTapeInfo(DishType.TEA, "Podwieczorek"));
        meals.add(new DishTapeInfo(DishType.SUPPER, "Kolacja"));
        
        
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
       request.setAttribute("dishType", meals);
       
       dispatcher.forward(request, response);
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
        doGet(request, response);
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
