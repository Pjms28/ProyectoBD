

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	

	private static Connection conn = null;
	private static String user = "PEDRO";
	private static String pass = "1234";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pass);
			conn.setAutoCommit(false);
			if(conn != null) {
				System.out.println("Conexion exitosa");
			}
			else {
				System.out.println("Error en la conexion");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}		
		return conn;
	}
	
	public void desconexion() {
		
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		//Conexion c = new Conexion();
		//c.getConnection();
	}
	
}
