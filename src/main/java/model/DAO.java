import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	
	private String root = "root";
	
	private String password = "1234";
	
	private String url = "jdbc:mysql://localhost:3306/agendamento?useTimezone=true&serverTimezone=UTC";
	
	private String driver = "com.mysql.jc.jdbc.Driver";
	
	Clientes cliente = new Clientes();

	private Connection conexao() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(root,password,url);
			
		
			
		}catch(ClassNotFoundException e) {
			System.out.println("Erro, não foi possível encontrar o driver "+e);
		}catch(SQLException erro) {
			System.out.println("Erro ao estabelecer conexão "+erro);
		}
		
		return conn;
	}
	
	
	//Método de criar
	
	
	public void insertCliente(Clientes cliente) {
		String insert = "insert into clientes(nomeCliente,dataMarcada,horario,valor) values (?,?,?,?)";
		
		try {
			Connection conn = conexao();
			
			PreparedStatement queryInsert = conn.prepareStatement(insert);
			
			queryInsert.setString(1, cliente.getNome());
			queryInsert.setString(2, cliente.getDataMarcada());
			queryInsert.setString(3, cliente.getHorario());
			queryInsert.setString(4, cliente.getValor());
			
			queryInsert.executeQuery();
			
			queryInsert.close();
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query: "+e);
		}
		
	}
	
	//Metodo exibir
	
	public ArrayList<Clientes> exibirClientes(){
		
		ArrayList<Clientes> clientes = new ArrayList();
		
		String readSQL = "select * from clientes";
		
		try {
			Connection conn = conexao();
			
			PreparedStatement querySelect = conn.prepareStatement(readSQL);
			
			ResultSet retorno = querySelect.executeQuery();
			
			while(retorno.next()) {
				String id = retorno.getString(1);
				String nome = retorno.getString(2);
				String data = retorno.getString(3);
				String horario = retorno.getString(4);
				String valor = retorno.getString(5);
				
				clientes.add(new Clientes(id,nome,data,horario,valor));
				conn.close();
			}
			
			return clientes;
			
			
		}catch(SQLException e) {
			System.out.println(e);
			
			return null;
		}
		
	}
	
	
	//Buscar cliente especifico
	
	public void findCliente(Clientes cliente) {
		String selectSQL = "select * from clientes where id_cliente = ?";
		
		try {
			Connection conn = conexao();
			
			PreparedStatement queryFind = conn.prepareStatement(selectSQL);
			
			queryFind.setString(1, cliente.getId_cliente());
			
			ResultSet retorno = queryFind.executeQuery();
			
			while(retorno.next()) {
				cliente.setId_cliente(retorno.getString(1));
				cliente.setNome(retorno.getString(2));
				cliente.setDataMarcada(retorno.getString(3));
				cliente.setHorario(retorno.getString(4));
				cliente.setValor(retorno.getString(5));
				
				
			}
			
			conn.close();
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query select: "+e);
		}
	}
	
}
	

	
	
	
	

