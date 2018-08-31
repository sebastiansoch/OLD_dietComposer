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

        Map<DishType, Double> caloriesForType = new HashMap<>();
        if (req.getParameter("breakfast") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_breakfast")) / 100);
            caloriesForType.put(DishType.BREAKFAST, cal);
        }

        if (req.getParameter("second_breakfast") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_breakfast")) / 100);
            caloriesForType.put(DishType.SECOND_BREAKFAST, cal);
        }

        if (req.getParameter("soup") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_breakfast")) / 100);
            caloriesForType.put(DishType.SOUP, cal);
        }

        if (req.getParameter("main_course") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_breakfast")) / 100);
            caloriesForType.put(DishType.MAIN_COURSE, cal);
        }

        if (req.getParameter("tea") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_breakfast")) / 100);
            caloriesForType.put(DishType.TEA, cal);
        }

        if (req.getParameter("supper") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_breakfast")) / 100);
            caloriesForType.put(DishType.SUPPER, cal);
        }
    }

}
