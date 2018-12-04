package dao;

import model.Trabalho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoDAO {

    public static void gravar(Trabalho trabalho) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "insert into trabalho (data_inicio, data_fim,"
                    + "descricao, categoria, "
                    + "disponibilidade, "
                    + "horas,anunciante_idAnunciante)" + "values (?,?,?,?,?,?,?)";

            comando = conexao.prepareStatement(sql);
            comando.setString(1, trabalho.getDataInicio());
            comando.setString(2, trabalho.getDataFim());
            comando.setString(3, trabalho.getDescricao());
            comando.setString(4, trabalho.getCategoria());
            comando.setString(5, trabalho.getDisponibilidade());
            comando.setString(6, trabalho.getHoras());

            comando.setInt(7, trabalho.getIdAnunciante());

            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }

    }

    public static void alterar(Trabalho trabalho) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "update trabalho set data_inicio=?, data_fim=?,"
                    + "descricao=?, categoria=?, "
                    + "disponibilidade=?, horas=?, anunciante_idAnunciante=? "
                    + " where id=?";

            comando = conexao.prepareStatement(sql);
            comando.setString(1, trabalho.getDataInicio());
            comando.setString(2, trabalho.getDataFim());
            comando.setString(3, trabalho.getDescricao());
            comando.setString(4, trabalho.getCategoria());
            comando.setString(5, trabalho.getDisponibilidade());
            comando.setString(6, trabalho.getHoras());
            comando.setInt(7, trabalho.getAnunciante().getId());

            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }

    }

    public static void excluir(Trabalho trabalho) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from trabalho where idTrabalho = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, trabalho.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Trabalho obterTrabalho(int id) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Trabalho trabalho = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM trabalho WHERE idTrabalho= ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, Math.toIntExact(id));
            ResultSet rs = comando.executeQuery();
            rs.first();

            //(int id, String categoria, String descricao, String dataInicio, String dataFim, String disponibilidade, String horas, int idAnunciante) {
            trabalho = new Trabalho( //cria  o objeto no singular
                        rs.getInt("idTrabalho"),
                        rs.getString("categoria"),
                        rs.getString("descricao"),
                        rs.getString("data_inicio"),
                        rs.getString("data_fim"),
                        rs.getString("disponibilidade"),
                        rs.getString("horas"),
                        null,
                        rs.getInt("anunciante_idAnunciante"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return trabalho;
    }

    public static List<Trabalho> obterTodosTrabalhos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Trabalho> trabalhos = new ArrayList<Trabalho>();//coloca o nome da lista no plural
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM trabalho";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Trabalho trabalho = new Trabalho( //ORDEM DA CLASSE
                        rs.getInt("idTrabalho"),
                        rs.getString("categoria"),
                        rs.getString("descricao"),
                        rs.getString("data_inicio"),
                        rs.getString("data_fim"),
                        rs.getString("disponibilidade"),
                        rs.getString("horas"),
                        null,
                        rs.getInt("anunciante_idAnunciante"));

                trabalhos.add(trabalho);  //add o objeto na lista e retorna a lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
            return trabalhos;//retorna a lista
        }
    }
}
