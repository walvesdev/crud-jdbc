package app;

import java.sql.SQLException;

import dao.ClienteDAO;
import model.Cliente;

public class App {

	 
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ClienteDAO dao = new ClienteDAO();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Mariana da Silva");
		cliente1.setEndereco("Casa Nova Mariana");
		
//		Cliente cliente2 = new Cliente();
//		cliente1.setNome("Maria da Silva");
//		cliente1.setEndereco("Maria Nova");
		
		
//		dao.inserir(cliente1);
//		dao.pesquisarTodos();
//		dao.pesquisarId(5);
//		dao.alterar(cliente1, 7);
		dao.deletar(13);
		dao.pesquisarTodos();


	}

}
