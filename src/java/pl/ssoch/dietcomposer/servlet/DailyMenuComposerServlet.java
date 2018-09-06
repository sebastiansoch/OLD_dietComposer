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
 * @author ssoch
 */
@WebServlet(name = "DailyMenuComposerServlet", urlPatterns = {"/dailyMenuComposer"})
public class DailyMenuComposerServlet extends MainServlet {

    @Override
    protected void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<DishType, Double> caloriesForType = new HashMap<>();
        prepareDailyMenu(request, caloriesForType);

        MealComposerViewHelper mcvh = new MealComposerViewHelper(caloriesForType);

        request.setAttribute("dishesMetCondition", mcvh.getMetConditionsDishesInfo());
        request.setAttribute("dishesNotMetCondition", mcvh.getNotMetConditionsDishesInfo());

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/dailyMenuComposer.jsp");
        dispatcher.include(request, response);

    }

    private void prepareDailyMenu(HttpServletRequest req, Map<DishType, Double> caloriesForType) {
        int calories = Integer.parseInt(req.getParameter("calories"));

        if (req.getParameter("breakfast") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_breakfast")) / 100);
            caloriesForType.put(DishType.BREAKFAST, cal);
        }

        if (req.getParameter("second_breakfast") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_second_breakfast")) / 100);
            caloriesForType.put(DishType.SECOND_BREAKFAST, cal);
        }

        if (req.getParameter("soup") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_soup")) / 100);
            caloriesForType.put(DishType.SOUP, cal);
        }

        if (req.getParameter("main_course") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_main_course")) / 100);
            caloriesForType.put(DishType.MAIN_COURSE, cal);
        }

        if (req.getParameter("tea") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_tea")) / 100);
            caloriesForType.put(DishType.TEA, cal);
        }

        if (req.getParameter("supper") != null) {
            Double cal = calories * (Double.parseDouble(req.getParameter("cal_supper")) / 100);
            caloriesForType.put(DishType.SUPPER, cal);
        }
    }

}
