package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Requisicao;
@WebServlet (name="ManterRequisicaoController", urlPatterns = "/ManterRequisicaoController")

public class ManterRequisicaoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmaOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                try {
                    prepararOperacao(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ManterRequisicaoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Requisicao requisicao = Requisicao.obterRequisicoes(id);
                request.setAttribute("requisicao", requisicao);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterRequisicao.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");

        int id = Integer.parseInt(request.getParameter("txtId"));
        int idTrabalho = Integer.parseInt(request.getParameter("txtIdTrabalho"));
        int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
        String data = request.getParameter("txtData");
        
        

        try {
            
            if (operacao.trim().equals("Incluir")) {
                Requisicao requisicao = new Requisicao(data, idCliente, null, idTrabalho, null, id);
                requisicao.gravar();
            } else if (operacao.equals("Editar")) {
               Requisicao requisicao = new Requisicao(data, idCliente, null, idTrabalho, null, id);

                requisicao.alterar();
            } else if (operacao.equals("Excluir")) {
                Requisicao requisicao = new Requisicao(data, idCliente, null, idTrabalho, null, id);
                requisicao.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaTrabalhoController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterRequisicaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterRequisicaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
