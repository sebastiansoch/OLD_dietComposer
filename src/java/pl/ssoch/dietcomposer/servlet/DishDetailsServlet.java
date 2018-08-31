/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.ssoch.dietcomposer.viewhelper.DishDetailsViewHelper;

/**
 *
 * @author Seba
 */
@WebServlet(name = "DishDetailsServlet", urlPatterns = {"/dishDetails"})
public class DishDetailsServlet extends MainServlet {

    @Override
    protected void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishId = Integer.parseInt(request.getParameter("pickedDish"));
        
        DishDetailsViewHelper dishDetailsViewHelper = new DishDetailsViewHelper(dishId);
        request.setAttribute("dishDetails", dishDetailsViewHelper);
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/dishDetails.jsp");
        dispatcher.forward(request, response);
    }

}
