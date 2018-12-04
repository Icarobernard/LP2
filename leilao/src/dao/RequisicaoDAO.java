package dao;

import model.Requisicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequisicaoDAO {

    public static void gravar(Requisicao requisicao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "insert into solicitacao_trabalho (cliente_idCliente, trabalho_idTrabalho,"
                    + "data)" + "values (?,?,?)";

            comando = conexao.prepareStatement(sql);
            comando.setInt(1, requisicao.getIdCliente());
            comando.setInt(2, requisicao.getIdTrabalho());
            comando.setString(3, requisicao.getData());

            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }

    }

    public static void alterar(Requisicao requisicao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "update solicitacao_trabalho set data=?,cliente_idCliente=?, trabalho_idTrabalho=?"
                    + " where id=?";

            comando = conexao.prepareStatement(sql);
            comando.setInt(1, requisicao.getId());
            comando.setInt(2, requisicao.getIdCliente());
            comando.setInt(3, requisicao.getIdTrabalho());
            comando.setString(4, requisicao.getData());

            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }

    }

    public static void excluir(Requisicao requisicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from solicitacao_trabalho where id = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, requisicao.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Requisicao obterRequisicao(int id) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Requisicao requisicao = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM solicitacao_trabalho WHERE id= ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, Math.toIntExact(id));
            ResultSet rs = comando.executeQuery();
            rs.first();

       //(String data, int idCliente, Cliente cliente, int idTrabalho, Trabalho trabalho, int id)
            requisicao = new Requisicao( //cria  o objeto no singular
                    rs.getString("data"),
                    rs.getInt("cliente_idCliente"),
                    null,
                    rs.getInt("trabalho_idTrabalho"),
                    null,
                    rs.getInt("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return requisicao;
    }

    public static List<Requisicao> obterTodasRequisicoes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Requisicao> requisicoes = new ArrayList<Requisicao>();//coloca o nome da lista no plural
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM solicitacao_trabalho";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Requisicao requisicao = new Requisicao( //cria  o objeto no singular
                    rs.getString("data"),
                    rs.getInt("cliente_idCliente"),
                    null,
                    rs.getInt("trabalho_idTrabalho"),
                    null,
                    rs.getInt("id"));

                requisicoes.add(requisicao);  //add o objeto na lista e retorna a lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
            return requisicoes;//retorna a lista
        }
    }
}
