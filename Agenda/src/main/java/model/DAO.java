package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
// DAO = Data access object...
public class DAO {
	// Módulo de Conexão
	/** The driver. */
	// Parâmetros de Conexão...
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC"; 
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "backend@24";
	
	
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Método de conexão...
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	//  CRUD Create
	public void inserirContato(JavaBeans contato){
		String create = "insert into contatos(nome, phone, email) values(?, ?, ?)";
		String Dynamic_create = "insert into contatos(nome, phone, email) values("+ contato.getNome()+ ", " 
		+ contato.getPhone() + ", "
		+ contato.getEmail()
		+ ")";
		try {
			// Abrir conexão
			Connection con = conectar();
			// Preparar a consulta (query) para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo 
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getPhone());
			pst.setString(3, contato.getEmail());
			
			// Executar a Query...
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	// CRUD Read
	public ArrayList<JavaBeans> listarContatos(){
		ArrayList<JavaBeans> lista = new ArrayList<>();
		String read = "select * from contatos order by idcon";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
			    int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				
				JavaBeans Contato = new JavaBeans(idcon, nome, phone, email);
				lista.add(Contato);
				
			}
			con.close();
			return lista;
			
		} catch (Exception e) {
			System.out.println(""+e);
			return null;
		}
	}
	
	/**
	 * Teste conexão.
	 */
	// Teste de conexão...
	public void testeConexão() {
		try{
			Connection con = conectar();
			System.out.println(con);
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// CRUD UPDATE 
		/**
	 * Selecao contato.
	 *
	 * @param id the id
	 * @return the java beans
	 */
	// Selecionar contatos
	public JavaBeans selecaoContato(int id) {
		String read2 = "select * from contatos where idcon = " + id;
		JavaBeans contato = new JavaBeans();
		try {
			// Abrir conexão
			Connection con = conectar();
			// Preparar a consulta (query) para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(read2);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
			    contato.setIdcon(rs.getInt(1));
				contato.setNome(rs.getString(2));
				contato.setPhone(rs.getString(3));
				contato.setEmail(rs.getString(4));
				
			}
			
			// Encerrar a conexão com o banco
			con.close();
			return contato;
			
			
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Atualizar contato.
	 *
	 * @param contato the contato
	 */
	public void atualizarContato(JavaBeans contato){
		String update = "update contatos set nome=?, phone=?, email=? where idcon=?";
		try {
			// Abrir conexão
			Connection con = conectar();
			// Preparar a consulta (query) para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(update);
			
			// Substituir os parâmetros (?) pelo conteúdo 
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getPhone());
			pst.setString(3, contato.getEmail());
			pst.setInt(4, contato.getIdcon());
				
			// Executar a Query...
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar contato.
	 *
	 * @param idcon the idcon
	 */
	public void deletarContato(int idcon) {
		String delete = "delete from contatos where idcon = " + idcon;
		try {
			// Abrir conexão
			Connection con = conectar();
			// Preparar a consulta (query) para execução no banco de dados
			Statement stmt = con.createStatement();
			stmt.executeUpdate(delete);
			
			con.close();;

			
			
		}catch (Exception e){
			System.out.println(e);
		}
		
		
	}
	
}
