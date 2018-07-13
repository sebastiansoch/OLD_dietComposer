/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.ssoch.dietcomposer.viewhelper.HomeViewHelper;

/**
 *
 * @author Seba
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends MainServlet {

    @Override
    protected void run(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        HomeViewHelper hvh = new HomeViewHelper();
        List<String> meals = hvh.getMeals();

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
        request.setAttribute("dishType", meals);

        dispatcher.forward(request, response);
    }
}
