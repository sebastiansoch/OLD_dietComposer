/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.ssoch.dietcomposer.viewhelper.DishComponentViewHelper;

/**
 *
 * @author Seba
 */
@WebServlet(name = "DishDetailsServlet", urlPatterns = {"/dishDetails"})
public class DishDetailsServlet extends MainServlet {

    @Override
    protected void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pickedDish = request.getParameter("pickedDish");
        
        Map<String, List<DishComponentViewHelper>> dishesComponents = new HashMap<>();
        HttpSession session = request.getSession();
        dishesComponents.putAll((Map<String, List<DishComponentViewHelper>>) session.getAttribute("dishesComponents"));

        List<DishComponentViewHelper> dishComponents = dishesComponents.get(pickedDish);
        request.setAttribute("dishName", pickedDish);
        request.setAttribute("dishComponents",dishComponents);
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/dishDetails.jsp");
        dispatcher.forward(request, response);
    }

}
