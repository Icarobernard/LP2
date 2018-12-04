package model;

import dao.TrabalhoDAO;
import java.sql.SQLException;
import java.util.List;

public class Trabalho {

    private int id;
    /* atributos descricao */
    private String categoria;
    private String descricao;

    /* atributos inicio e fim */
    private String dataInicio;
    private String dataFim;
    private String disponibilidade;
    private String horas;
    
    
    
    
    private Anunciante anunciante;
    private int idAnunciante;
    
 



    public Trabalho(int id, String categoria, String descricao, String dataInicio, String dataFim, String disponibilidade, String horas, Anunciante anunciante,int idAnunciante) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.disponibilidade = disponibilidade;
        this.horas = horas;
        this.idAnunciante= idAnunciante;
        this.anunciante=anunciante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
        
        
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }


    public static List<Trabalho> obterTodosTrabalhos() throws ClassNotFoundException, SQLException {
        return TrabalhoDAO.obterTodosTrabalhos();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        TrabalhoDAO.gravar(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        TrabalhoDAO.alterar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        TrabalhoDAO.excluir(this);
    }

    public static Trabalho obterTrabalhos(int id) throws ClassNotFoundException {
        return TrabalhoDAO.obterTrabalho(id);
    }

}
