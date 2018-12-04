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
import model.Anunciante;
import model.Trabalho;
@WebServlet (name="ManterTrabalhoController", urlPatterns = "/ManterTrabalhoController")

public class ManterTrabalhoController extends HttpServlet {

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
                    Logger.getLogger(ManterTrabalhoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("trabalhos", Trabalho.obterTodosTrabalhos());
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Trabalho trabalho = Trabalho.obterTrabalhos(id);
                request.setAttribute("trabalho", trabalho);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterTrabalho.jsp");
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
        String descricao = request.getParameter("txtDescricao");
        String dataInicio = request.getParameter("txtDataInicio");
        String dataFim = request.getParameter("txtDataFim");
        String categoria = request.getParameter("optCategoria");
        String disponibilidade = request.getParameter("optDisponibilidade");
        String horas = request.getParameter("txtHoras");
        int idAnunciante = Integer.parseInt(request.getParameter("txtIdAnunciante"));

        try {
            // Cliente cliente = new Cliente(nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
            //(int id, String categoria, String descricao, String dataInicio, String dataFim, String disponibilidade, String horas, Anunciante anunciante,int idAnunciante) {

            if (operacao.trim().equals("Incluir")) {
                Trabalho trabalho = new Trabalho(id, categoria, descricao, dataInicio, dataFim, disponibilidade, horas, null, idAnunciante);
                trabalho.gravar();
            } else if (operacao.equals("Editar")) {
                Trabalho trabalho = new Trabalho(id, categoria, descricao, dataInicio, dataFim, disponibilidade, horas, null, idAnunciante);

                trabalho.alterar();
            } else if (operacao.equals("Excluir")) {
                Trabalho trabalho = new Trabalho(id, categoria, descricao, dataInicio, dataFim, disponibilidade, horas, null, idAnunciante);
                trabalho.excluir();
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
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
