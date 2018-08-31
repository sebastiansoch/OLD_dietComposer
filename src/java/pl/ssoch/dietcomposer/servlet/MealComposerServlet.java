/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.viewhelper.MealComposerViewHelper;

/**
 *
 * @author Seba
 */
@WebServlet(name = "MealComposerServlet", urlPatterns = {"/mealComposer"})
public class MealComposerServlet extends MainServlet {

    @Override
    protected void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Double calories = Double.parseDouble(request.getParameter("calories"));
        DishType dishType = DishType.valueOf(request.getParameter("meal"));
        Map<DishType, Double> caloriesForType = new HashMap<>();
        caloriesForType.put(dishType, calories);
        MealComposerViewHelper mcvh = new MealComposerViewHelper(caloriesForType);
       
        request.setAttribute("dishesMetCondition", mcvh.getMetConditionsDishesInfo());
        request.setAttribute("dishesNotMetCondition", mcvh.getNotMetConditionsDishesInfo());
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/mealComposer.jsp");
        dispatcher.forward(request, response);

    }
}
