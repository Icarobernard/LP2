/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Anunciante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AnuncianteDAO {

    public static void gravar(Anunciante anunciante) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "insert into anunciante (nome, cpf,"
                    + "cep, logradouro, "
                    + "bairro, cidade, estado ,email, "
                    + "senha, telefone,sexo,login,numero)" + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            comando = conexao.prepareStatement(sql);
            comando.setString(1, anunciante.getNome());
            comando.setString(2, anunciante.getCpf());
            comando.setString(3, anunciante.getCep());
            comando.setString(4, anunciante.getLogradouro());
            comando.setString(5, anunciante.getBairro());
            comando.setString(6, anunciante.getCidade());
            comando.setString(7, anunciante.getEstado());
            comando.setString(8, anunciante.getEmail());
            comando.setString(9, anunciante.getSenha());
            comando.setString(10, anunciante.getTelefone());
            comando.setString(11, anunciante.getSexo());
            comando.setString(12, anunciante.getLogin());
            comando.setString(13, anunciante.getNumero());

            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }

    }
    
    public static Anunciante logar(String login, String senha) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Anunciante anunciante = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM anunciante where login=? and senha=?";

            comando = conexao.prepareStatement(sql);
            
            comando.setString(1, login);
            comando.setString(2, senha);
           
            ResultSet rs= comando.executeQuery();
            if(rs.first()){
                
                anunciante = new Anunciante(
                    rs.getInt("idAnunciante"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("cep"),
                    rs.getString("logradouro"),
                    rs.getString("numero"),
                    rs.getString("complemento"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"));
            }

            comando.close();
            conexao.close();

        } catch (SQLException e) {
         }finally {
            BD.fecharConexao(conexao, comando);
        }
    return anunciante;
    }

    public static void alterar(Anunciante anunciante) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "update anunciante set nome=?, sexo=?, cpf=?, email=?, "
                    + "telefone=?, login=?, senha=?, cep=?, logradouro=?, "
                    + "numero=?, complemento=?, bairro=?, cidade=?, estado=? "
                    + "where idAnunciante=?";

            comando = conexao.prepareStatement(sql);
            comando.setString(1, anunciante.getNome());
            comando.setString(2, anunciante.getSexo());
            comando.setString(3, anunciante.getCpf());
            comando.setString(4, anunciante.getEmail());
            comando.setString(5, anunciante.getTelefone());
            comando.setString(6, anunciante.getLogin());
            comando.setString(7, anunciante.getSenha());
            comando.setString(8, anunciante.getCep());
            comando.setString(9, anunciante.getLogradouro());
            comando.setString(10, anunciante.getNumero());
            comando.setString(11, anunciante.getComplemento());
            comando.setString(12, anunciante.getBairro());
            comando.setString(13, anunciante.getCidade());
            comando.setString(14, anunciante.getEstado());
            comando.setInt(15, anunciante.getId());

            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }

    }

    public static void excluir(Anunciante anunciante) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from anunciante where idAnunciante = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, anunciante.getId());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Anunciante obterAnunciantes(int idAnunciante) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Anunciante anunciante = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM anunciante WHERE idAnunciante= ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, Math.toIntExact(idAnunciante));
            ResultSet rs = comando.executeQuery();
            rs.first();
            anunciante = new Anunciante(
                    rs.getInt("idAnunciante"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("cep"),
                    rs.getString("logradouro"),
                    rs.getString("numero"),
                    rs.getString("complemento"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return anunciante;
    }

    public static List<Anunciante> obterTodosAnunciantes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Anunciante> anunciantes = new ArrayList<Anunciante>();//coloca o nome da lista no plural
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM anunciante";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Anunciante anunciante = new Anunciante( //cria  o objeto no singular
                        rs.getInt("idAnunciante"),
                        rs.getString("nome"),
                        rs.getString("sexo"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("cep"),
                        rs.getString("logradouro"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"));
                anunciantes.add(anunciante);  //add o objeto na lista e retorna a lista
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
             return anunciantes;//retorna a lista
        }
       

    }

}
