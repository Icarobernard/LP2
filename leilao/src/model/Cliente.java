package model;


import dao.ClienteDAO;
import java.util.List;
import java.sql.SQLException;

public class Cliente extends Usuario {

    public Cliente(int id, String nome, String sexo, String cpf, String email, String telefone, String login, String senha, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado) {
        super(id, nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
    }

    public Cliente(String nome, String sexo, String cpf, String email, String telefone, String login, String senha, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado) {
        super(nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
    }
    
    




    public static List<Cliente> obterTodosClientes() throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterTodosClientes();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
       ClienteDAO.gravar(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        ClienteDAO.alterar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        ClienteDAO.excluir(this);
    }

    public static Cliente obterClientes(int id) throws ClassNotFoundException {
        return ClienteDAO.obterClientes(id);
    }




}

