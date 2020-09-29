package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Produto;
import connection.SingleConnection;

public class DaoProduto {

	private Connection connection;

	public DaoProduto() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Produto produto) {
		try {
			String sql = "insert into produto(nome, quantidade, valor) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, produto.getNome());
			insert.setDouble(2, produto.getQuantidade());
			insert.setDouble(3, produto.getValor());
			insert.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> listar = new ArrayList<Produto>();
		String sql = "Select * from produto";
		PreparedStatement statment = connection.prepareStatement(sql);
		ResultSet resultSet = statment.executeQuery();
		while (resultSet.next()) {
			Produto produto = new Produto();
			produto.setId(resultSet.getLong("id"));
			produto.setNome(resultSet.getString("nome"));
			produto.setQuantidade(resultSet.getDouble("quantidade"));
			produto.setValor(resultSet.getDouble("valor"));
			listar.add(produto);
		}
		return listar;
	}

	public void delete(String id) {

		try {
			String sql = "delete from produto where id='" + id + "'";
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public Produto consultar(String id) throws SQLException {
		String sql = "Select * from produto where id ='" + id + "'";
		PreparedStatement preparedStatment = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatment.executeQuery();
		if (resultSet.next()) {
			Produto produto = new Produto();
			produto.setId(resultSet.getLong("id"));
			produto.setNome(resultSet.getString("nome"));
			produto.setQuantidade(resultSet.getDouble("quantidade"));
			produto.setValor(resultSet.getDouble("valor"));
			return produto;
		}else {
			return null;
		}
	}
	
	public boolean validarNome(String nome) throws SQLException {
		String sql = "Select count(1) as qtd from produto where nome='"+nome+"'";
		PreparedStatement preparedStatment = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatment.executeQuery();
		if(resultSet.next()) {
			return resultSet.getInt("qtd")<=0;/*Retorna true*/
		}
		
		return false;
	}
	
	public void atualizar(Produto produto) {
		try {
			String sql = "update produto set nome = ?, quantidade = ?, valor = ? where id = "+ produto.getId();
			PreparedStatement preparedStatment;
			preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setString(1, produto.getNome());
			preparedStatment.setDouble(2, produto.getQuantidade());
			preparedStatment.setDouble(3, produto.getValor());
			preparedStatment.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
