import java.sql.Connection;
import java.sql.SQLException;

public class VisitaBO {

private String mensaje = "";
private VisitaDAO vDAO = new VisitaDAO();
	
	public String agregarVisita(Visita vis) throws SQLException {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = vDAO.agregarVisita(conn, vis);
			conn.commit();
		} catch (Exception e) {
			mensaje = mensaje + " " +e.getMessage();
			conn.rollback();
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
	
	public String modificarVisita(Visita vis) throws SQLException {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = vDAO.modificarVisita(conn, vis);
			conn.commit();
		} catch (Exception e) {
			mensaje = mensaje + " " +e.getMessage();
			conn.rollback();
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
	
	public String eliminarVisita(int id) throws SQLException {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = vDAO.eliminarVisita(conn, id);
			conn.commit();
		} catch (Exception e) {
			mensaje = mensaje + " " +e.getMessage();
			conn.rollback();
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
	
	public void mostrarVisita() {
	}
}
