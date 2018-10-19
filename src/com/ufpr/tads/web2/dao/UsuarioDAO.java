package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ufpr.tads.web2.beans.Usuario;

public class UsuarioDAO {

    public void create(Usuario usu) throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        stmt = con.prepareStatement("INSERT INTO tb_usuario (login_usuario, nome_usuario, senha_usuario) VALUES ( ?, ?, ?)");
        stmt.setString(1, usu.getLogin());
        stmt.setString(2, usu.getNome());
        stmt.setString(3, usu.getSenha());

        stmt.executeUpdate();

        System.out.println("Salvo no banco! ");

        ConnectionFactory.closeConnection(con, stmt);
    }

    public List<Usuario> buscarTodos() throws Exception {
        List<Usuario> lista = new ArrayList<>();

        Connection conexao = ConnectionFactory.getConnection();

        String sql = "SELECT login_usuario, nome_usuario, senha_usuario FROM tb_usuario";

        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setLogin(rs.getString(1));
            usuario.setNome(rs.getString(2));
            usuario.setSenha(rs.getString(3));
            
            lista.add(usuario);
        }

        return lista;
    }

    public boolean buscarBanco(String login, String senha) throws Exception {
        Usuario usuario = null;
        Connection conexao = ConnectionFactory.getConnection();

        String sql = "select * from tb_usuario where login_usuario=(?) and senha_usuario=(?)";

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, senha);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            return true;
        }

        return false;
    }
    
    public String buscarNome(String login) throws Exception {
        String nome = null;
        Connection conexao = ConnectionFactory.getConnection();
        
        String sql = "select nome_usuario from tb_usuario where login_usuario=(?)";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, login);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if(resultSet.next()){
            nome = resultSet.getString(1);
        }
        
        return nome;
    }

}
