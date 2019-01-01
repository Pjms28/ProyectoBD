import java.sql.Connection;
import java.sql.SQLException;

public class LicenciaBO {
	private String mensaje = "";
	private LicenciaDAO ldao = new LicenciaDAO();
	
	public String agregarLicencia(Licencia lin) throws SQLException {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = ldao.agregarLicencia(conn, lin);
			conn.commit();
		} catch (Exception e) {
			mensaje = mensaje + " " +e.getMessage();
			conn.rollback();
			// TODO: handle exception
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return mensaje;
		
	}
	
	public String modificarLicencia(Licencia lin) throws SQLException {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = ldao.modificarLicencia(conn, lin);
			conn.commit();
		} catch (Exception e) {
			mensaje = mensaje + " " +e.getMessage();
			conn.rollback();
			// TODO: handle exception
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return mensaje;
		
		
	}
	public String eliminarLicencia(int id) throws SQLException {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = ldao.eliminarLicencia(conn, id);
			conn.commit();
		} catch (Exception e) {
			mensaje = mensaje + " " +e.getMessage();
			conn.rollback();
			// TODO: handle exception
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return mensaje;
		
	}
	public void listarLicencia() {

		
	}

}
