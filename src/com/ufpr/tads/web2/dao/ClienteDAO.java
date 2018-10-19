package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ufpr.tads.web2.dao.ConnectionFactory;
import com.ufpr.tads.web2.beans.Cliente;

public class ClienteDAO {

	public List<Cliente> listarClientes() throws Exception {
		List<Cliente> lista = new ArrayList<>();

		Connection conexao = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM tb_cliente";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setId_cliente(rs.getInt(1));
			cliente.setCpf_cliente(rs.getString(2));
			cliente.setNome_cliente(rs.getString(3));
			cliente.setEmail_cliente(rs.getString(4));
			cliente.setData_cliente(rs.getDate(5));
			cliente.setRua_cliente(rs.getString(6));
			cliente.setNr_cliente(rs.getInt(7));
			cliente.setCep_cliente(rs.getString(8));
			cliente.setCidade_cliente(rs.getString(9));
			lista.add(cliente);
		}

		return lista;
	}
	
	public Cliente listarCliente(String nome) throws Exception {
		Cliente cliente = null;

		Connection conexao = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM tb_cliente where nome_cliente = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, nome);
		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			cliente = new Cliente();
			cliente.setId_cliente(rs.getInt(1));
			cliente.setCpf_cliente(rs.getString(2));
			cliente.setNome_cliente(rs.getString(3));
			cliente.setEmail_cliente(rs.getString(4));
			cliente.setData_cliente(rs.getDate(5));
			cliente.setRua_cliente(rs.getString(6));
			cliente.setNr_cliente(rs.getInt(7));
			cliente.setCep_cliente(rs.getString(8));
			cliente.setCidade_cliente(rs.getString(9));
			
			return cliente;
		}

		return null;
	}
	
	public Cliente listarClienteID(int idUsuario) throws Exception {
		Cliente cliente = null;

		Connection conexao = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM tb_cliente where id_cliente = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idUsuario);
		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			cliente = new Cliente();
			cliente.setId_cliente(rs.getInt(1));
			cliente.setCpf_cliente(rs.getString(2));
			cliente.setNome_cliente(rs.getString(3));
			cliente.setEmail_cliente(rs.getString(4));
			cliente.setData_cliente(rs.getDate(5));
			cliente.setRua_cliente(rs.getString(6));
			cliente.setNr_cliente(rs.getInt(7));
			cliente.setCep_cliente(rs.getString(8));
			cliente.setCidade_cliente(rs.getString(9));
			
			return cliente;
		}

		return null;
	}

	public int addCliente(Cliente cliente) throws Exception {
		int idGerado = 0;
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "insert into tb_cliente (cpf_cliente,nome_cliente,email_cliente,data_cliente, rua_cliente,nr_cliente,cep_cliente,cidade_cliente,uf_cliente) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, cliente.getCpf_cliente());
		statement.setString(2, cliente.getNome_cliente());
		statement.setString(3, cliente.getEmail_cliente());
		statement.setDate(4, cliente.getData_cliente());
		statement.setString(5, cliente.getRua_cliente());
		statement.setInt(6, cliente.getNr_cliente());
		statement.setString(7, cliente.getCep_cliente());
		statement.setString(8, cliente.getCidade_cliente());
		statement.setString(9, cliente.getUf_cliente());
		statement.execute();

		ResultSet rs = statement.getGeneratedKeys();
		/* se foi gerado um id de respost de cadastro */
		if (rs.next()) {
			idGerado = rs.getInt(1);
		}

		return idGerado;
	}

	public void editarCliente(Cliente cliente, int idCliente) throws Exception {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "update tb_cliente set id_cliente = ?, cpf_cliente = ?,nome_cliente = ?, email_cliente = ?, data_cliente = ?, rua_cliente = ?, nr_cliente = ?, cep_cliente = ?, cidade_cliente = ?, uf_cliente = ? where id_cliente = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idCliente);
		statement.setString(2, cliente.getCpf_cliente());
		statement.setString(3, cliente.getNome_cliente());
		statement.setString(4, cliente.getEmail_cliente());
		statement.setDate(5, cliente.getData_cliente());
		statement.setString(6, cliente.getRua_cliente());
		statement.setInt(7, cliente.getNr_cliente());
		statement.setString(8, cliente.getCep_cliente());
		statement.setString(9, cliente.getCidade_cliente());
		statement.setString(10, cliente.getUf_cliente());
		statement.setInt(11, idCliente);
		statement.execute();
	}

	public void removerCliente(int idCliente) throws Exception {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "delete from tb_cliente where id_cliente=?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idCliente);
		statement.execute();
	}

}
