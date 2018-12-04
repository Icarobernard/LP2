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
import model.Cliente;
@WebServlet (name="ManterClienteController", urlPatterns = "/ManterClienteController")
public class ManterClienteController extends HttpServlet {

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
                    Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("clientes",Cliente.obterTodosClientes());
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Cliente cliente = Cliente.obterClientes(id);
                request.setAttribute("cliente", cliente);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
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
        int id = Integer.parseInt(request.getParameter("txtIdCliente"));
        String nome = request.getParameter("txtNomeCliente");
        String sexo = request.getParameter("optTipoSexoCliente");
        String cpf = request.getParameter("txtCpfCliente");
        String email = request.getParameter("txtEmailCliente");
        String telefone = request.getParameter("txtTelefoneCliente");
        String login = request.getParameter("txtLoginCliente");
        String senha = request.getParameter("txtSenhaCliente");
        String logradouro = request.getParameter("txtLogradouroCliente");
        String cep = request.getParameter("txtCepCliente");
        String numero = request.getParameter("txtNumeroCliente");
        String complemento = request.getParameter("txtComplementoCliente");
        String bairro = request.getParameter("txtBairroCliente");
        String cidade = request.getParameter("txtCidadeCliente");
        String estado = request.getParameter("optTipoEstado");

        try {
           // Cliente cliente = new Cliente(nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
            if (operacao.trim().equals("Incluir")) {
                Cliente cliente = new Cliente(nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
                cliente.gravar();
            } else if (operacao.equals("Editar")) {
                Cliente cliente = new Cliente(id,nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
                cliente.alterar();
            } else if (operacao.equals("Excluir")) {
                Cliente cliente = new Cliente(id,nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
                cliente.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
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
