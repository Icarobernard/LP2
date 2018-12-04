package controller;

import model.Trabalho;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet (name="PesquisaTrabalhoController", urlPatterns = "/PesquisaTrabalhoController")

public class PesquisaTrabalhoController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            request.setAttribute("trabalhos", Trabalho.obterTodosTrabalhos());
            RequestDispatcher view = request.getRequestDispatcher("gridTrabalho.jsp");
            view.forward(request, response);
        }catch (ClassNotFoundException e){
            throw  new ServletException(e);
        }catch (SQLException e){
            throw new ServletException(e);
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}