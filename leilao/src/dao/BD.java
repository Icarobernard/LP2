/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BD {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/lp", "root", "");

    }

    public static void fecharConexao(Connection conexao, Statement comando) {

        try {
            if (comando != null) {
                comando.close();
            }


            if (comando != null) {
                comando.close();
            }
        }catch (SQLException ignored) {

        }

    }

}
