package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

private Connection connection;
	
	public DaoUsuario() {
	
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeanCursoJsp usuario) {
		
		try {
			String sql= "insert into usuario (login,senha, nome, telefone) values(?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.setString(3, usuario.getNome());
			insert.setString(4, usuario.getTelefone());
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
	
	public List<BeanCursoJsp> listar() throws Exception{
		List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>();
		String sql = "Select * from usuario";
		PreparedStatement statment = connection.prepareStatement(sql);
		ResultSet resultSet = statment.executeQuery();
		while(resultSet.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setNome(resultSet.getString("nome"));
			beanCursoJsp.setTelefone(resultSet.getString("telefone"));
			listar.add(beanCursoJsp);
		}
		return listar;
	}
	
	public void delete(String id){
		String sql ="delete from usuario where id = '"+id+"'";
		try {
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	public BeanCursoJsp consultar(String id) throws SQLException {
		String sql = "Select * from usuario where id='"+id+"'";
		PreparedStatement preparedStatment = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatment.executeQuery();
		if(resultSet.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setNome(resultSet.getString("nome"));
			beanCursoJsp.setTelefone(resultSet.getString("telefone"));
			return beanCursoJsp;
		}
		return null;
	}

	public boolean validarLogin(String login) throws SQLException {
		String sql = "Select count(1) as qtd from usuario where login='"+login+"'";
		PreparedStatement preparedStatment = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatment.executeQuery();
		if(resultSet.next()) {
			return resultSet.getInt("qtd")<=0;/*Retorna true*/
		}
		
		return false;
	}
	
	public boolean validarLoginUpdate(String login, String id) throws SQLException {
		String sql = "Select count(1) as qtd from usuario where login='"+login+"' and id <>"+id;
		PreparedStatement preparedStatment = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatment.executeQuery();
		if(resultSet.next()) {
			return resultSet.getInt("qtd")<=0;/*Retorna true*/
		}
		
		return false;
	}
	
	public boolean validarSenha(String senha) {
		if(senha.length()>=3) {
			return true;
		}else {
			return false;	
		}
		
	}
	
	public void atualizar(BeanCursoJsp usuario) {
		try {
			String sql = "update usuario set login = ?, senha = ?, nome = ?, telefone = ? where id = "+ usuario.getId();
			PreparedStatement preparedStatment;
			preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setString(1, usuario.getLogin());
			preparedStatment.setString(2, usuario.getSenha());
			preparedStatment.setString(3, usuario.getNome());
			preparedStatment.setString(4, usuario.getTelefone());
			preparedStatment.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
