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

/**
 *
 * @author ssoch
 */
@WebServlet(name = "DailyMenuComposerServlet", urlPatterns = {"/dailyMenuComposer"})
public class DailyMenuComposerServlet extends MainServlet {

    @Override
    protected void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        prepareDailyMenu(req);
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/dailyMenuComposer.jsp");
        dispatcher.include(req, resp);
    }

    private void prepareDailyMenu(HttpServletRequest req) {
        int calories = Integer.parseInt(req.getParameter("calories"));
        
        Map<Enum, Boolean> chosenDishes = new HashMap<>();
        
        if (req.getParameter("breakfast") != null) {
            chosenDishes.put(DishType.BREAKFAST, true );
        } else {
            chosenDishes.put(DishType.BREAKFAST, false );
        }
               
        if (req.getParameter("second_breakfast") != null) {
            chosenDishes.put(DishType.SECOND_BREAKFAST, true );
        } else {
            chosenDishes.put(DishType.SECOND_BREAKFAST, false );
        }

        if (req.getParameter("soup") != null) {
            chosenDishes.put(DishType.SOUP, true );
        } else {
            chosenDishes.put(DishType.SOUP, false );
        }

        if (req.getParameter("main_course") != null) {
            chosenDishes.put(DishType.MAIN_COURSE, true );
        } else {
            chosenDishes.put(DishType.MAIN_COURSE, false );
        }

        if (req.getParameter("tea") != null) {
            chosenDishes.put(DishType.TEA, true );
        } else {
            chosenDishes.put(DishType.TEA, false );
        }

        if (req.getParameter("supper") != null) {
            chosenDishes.put(DishType.SUPPER, true );
        } else {
            chosenDishes.put(DishType.SUPPER, false );
        }
        
    }

}
