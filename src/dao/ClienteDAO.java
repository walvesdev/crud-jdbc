package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO {

	
	
	public void inserir(Cliente cliente) throws ClassNotFoundException, SQLException {

		Connection conexao = DBConnect.conectar();
		
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO cliente (nome, endereco) values (?,?)");
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEndereco());
		stmt.executeUpdate();
		
		System.out.println("Inserido com Sucesso!");
		stmt.close();
		conexao.close();
		

	}

	public Cliente pesquisarId(int idCliente) throws SQLException, ClassNotFoundException {
		
		Cliente cliente = null;
		
		Connection conexao = DBConnect.conectar();
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT  id, nome, endereco FROM cliente WHERE id = ?");
		stmt.setInt(1, idCliente);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			cliente = new Cliente();	
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setEndereco(rs.getString("endereco"));
			
		}
		stmt.close();
		conexao.close();	
		System.out.println("===============     Pesquisa por ID       ==============");
		System.out.println("Id= "+cliente.getId()+" Nome= "+cliente.getNome()+" Endereço= "+cliente.getEndereco());
		System.out.println("========================================================");
		
		return cliente;
	}

	public List<Cliente> pesquisarTodos() throws SQLException, ClassNotFoundException {
		
		Connection conexao = DBConnect.conectar();
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM cliente;");
		ResultSet rs = stmt.executeQuery();
		
		List<Cliente> lista = new ArrayList<>();
		
		while(rs.next()) {
		
			Cliente cliente = new Cliente();	
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setEndereco(rs.getString("endereco"));
			
			lista.add(cliente);
			System.out.println("Id= "+cliente.getId()+" Nome= "+cliente.getNome()+" Endereço= "+cliente.getEndereco());
			System.out.println("========================================================");
			
		}
		 
		stmt.close();
		conexao.close();
		return lista;
	}

	public void alterar(Cliente cliente, int id) throws SQLException, ClassNotFoundException {

		Connection conexao = DBConnect.conectar();
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE cliente SET nome = ?, endereco = ? WHERE id = ?");
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEndereco());
		stmt.setInt(3, id);		
		stmt.executeUpdate();
		
		System.out.println("Alterado Cliene "+cliente.getNome()+" com ID= "+cliente.getId());
		
		conexao.close();
	}

	public void deletar(int id) throws SQLException, ClassNotFoundException {

		Connection conexao = DBConnect.conectar();
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM cliente WHERE id = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();
		conexao.close();
		
	}
}
