
package model;
import dao.RequisicaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Requisicao {
    
    private int id;
    private String data; //data da requisição
    private int idCliente;
    private Cliente cliente;
    
    private int idTrabalho;
    private Trabalho trabalho;

    public Requisicao(String data, int idCliente, Cliente cliente, int idTrabalho, Trabalho trabalho, int id) {
        this.data = data;
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.idTrabalho = idTrabalho;
        this.trabalho = trabalho;
        this.id= id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdTrabalho() {
        return idTrabalho;
    }

    public void setIdTrabalho(int idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
  
    
       public static List<Requisicao> obterTodasRequisicoes() throws ClassNotFoundException, SQLException {
        return RequisicaoDAO.obterTodasRequisicoes();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        RequisicaoDAO.gravar(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        RequisicaoDAO.alterar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        RequisicaoDAO.excluir(this);
    }

    public static Requisicao obterRequisicoes(int id) throws ClassNotFoundException {
        return RequisicaoDAO.obterRequisicao(id);
    }
    
    
}

