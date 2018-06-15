/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet;

import pl.ssoch.dietcomposer.data.FactoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.data.DishesDAO;
import pl.ssoch.dietcomposer.data.DishesDAOFake;
import pl.ssoch.dietcomposer.services.DishManager;
import pl.ssoch.dietcomposer.services.Menu;
import pl.ssoch.dietcomposer.services.MenuGenerator;
import pl.ssoch.dietcomposer.services.MenuGeneratorImpl;

/**
 *
 * @author Seba
 */
@WebServlet(name = "MenuComposerServlet", urlPatterns = {"/menuComposer"})
public class MenuComposerServlet extends HttpServlet {
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
        

        MenuGenerator menuGen = FactoryDAO.getMenuGenerator();
        Menu menu = menuGen.createMenu(Integer.parseInt(request.getParameter("calories")));
        DishType dishType = DishType.valueOf(request.getParameter("meal"));
        List<Dish> dishList = menu.getDishesForType(dishType);
        
        request.setAttribute("dishList", dishList);
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/menuComposer.jsp");
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
