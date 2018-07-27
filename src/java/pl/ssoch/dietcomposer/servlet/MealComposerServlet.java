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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        int calories = Integer.parseInt(request.getParameter("calories"));
        List<DishType> dishType = new ArrayList<>();
        dishType.add(DishType.valueOf(request.getParameter("meal")));
        MealComposerViewHelper mcvh = new MealComposerViewHelper(dishType, calories);
        
        HttpSession session = request.getSession();
        session.setAttribute("dishesComponents", mcvh.getDishesComponents());
        
        request.setAttribute("dishesMetCondition", mcvh.getMetConditionsDishesInfo());
        request.setAttribute("dishesNotMetCondition", mcvh.getNotMetConditionsDishesInfo());
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/mealComposer.jsp");
        dispatcher.forward(request, response);

    }
}
