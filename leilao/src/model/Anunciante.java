package model;
import dao.AnuncianteDAO;
import java.util.List;
import java.sql.SQLException;

public class Anunciante extends Usuario {

    public Anunciante(int id, String nome, String sexo, String cpf, String email, String telefone, String login, String senha, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado) {
        super(id, nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
    }

    public Anunciante(String nome, String sexo, String cpf, String email, String telefone, String login, String senha, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado) {
        super(nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
    }
    
        
    

    
    

    

    public static List<Anunciante> obterTodosAnunciantes() throws ClassNotFoundException, SQLException {
        return AnuncianteDAO.obterTodosAnunciantes();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        AnuncianteDAO.gravar(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        AnuncianteDAO.alterar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        AnuncianteDAO.excluir(this);
    }

    public static Anunciante obterAnunciantes(int id) throws ClassNotFoundException {
        return AnuncianteDAO.obterAnunciantes(id);
    }





}
