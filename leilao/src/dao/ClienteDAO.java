/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static void gravar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "insert into cliente(nome, cpf,"
                    + "cep, logradouro, "
                    + "bairro, cidade, estado ,email, "
                    + "senha, telefone,sexo,login,numero)" + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            comando = conexao.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getCep());
            comando.setString(4, cliente.getLogradouro());
            comando.setString(5, cliente.getBairro());
            comando.setString(6, cliente.getCidade());
            comando.setString(7, cliente.getEstado());
            comando.setString(8, cliente.getEmail());
            comando.setString(9, cliente.getSenha());
            comando.setString(10, cliente.getTelefone());
            comando.setString(11, cliente.getSexo());
            comando.setString(12, cliente.getLogin());
            comando.setString(13, cliente.getNumero());
           

            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }

    }

    public static void alterar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "update cliente set nome=?, sexo=?, cpf=?, email=?, "
                    + "telefone=?, login=?, senha=?, cep=?, logradouro=?, "
                    + "numero=?, complemento=?, bairro=?, cidade=?, estado=? "
                    + "where idCliente=?";

            comando = conexao.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getSexo());
            comando.setString(3, cliente.getCpf());
            comando.setString(4, cliente.getEmail());
            comando.setString(5, cliente.getTelefone());
            comando.setString(6, cliente.getLogin());
            comando.setString(7, cliente.getSenha());
            comando.setString(8, cliente.getCep());
            comando.setString(9, cliente.getLogradouro());
            comando.setString(10, cliente.getNumero());
            comando.setString(11, cliente.getComplemento());
            comando.setString(12, cliente.getBairro());
            comando.setString(13, cliente.getCidade());
            comando.setString(14, cliente.getEstado());
            comando.setInt(15, cliente.getId());

            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }

    }

    public static void excluir(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from cliente where idCliente = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, (int) cliente.getId());
            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

 
    public static Cliente obterClientes(int idCliente) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Cliente cliente = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM cliente WHERE idCliente= ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, Math.toIntExact(idCliente));
            ResultSet rs = comando.executeQuery();
            rs.first();
            cliente = new Cliente( //cria  o objeto no singular
                    rs.getInt("idCliente"),
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
        return cliente;
    }

    public static List<Cliente> obterTodosClientes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<Cliente>();//coloca o nome da lista no plural
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM cliente";
            ResultSet rs = comando.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente( //cria  o objeto no singular
                        rs.getInt("idCliente"),
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
                clientes.add(cliente);  //add o objeto na lista e retorna a lista
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
            return clientes;//retorna a lista
        }

    }
}
