import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class RecetaBO {
	
	private String mensaje= "";
	private RecetaDAO rDAO= new RecetaDAO();
	
	public String agregarReceta( Receta rec) throws ParseException, SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.agregarReceta(conn, rec);
			conn.commit();
			}catch (Exception e) {
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
	
	public String modificarReceta(Receta rec) throws SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.modificarReceta(conn, rec);
			conn.commit();
			}catch (Exception e) {
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
	
	public String eliminarReceta( int id) throws SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.eliminarReceta(conn, id);
			conn.commit();
			}catch (Exception e) {
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
	
	public void mostrarReceta(TableView<Receta> tv) {
		Connection conn = Conexion.getConnection();
		tv.setItems(rDAO.mostrarReceta(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void opciones1(ComboBox<Integer> cb) {
		Connection conn = Conexion.getConnection();
		cb.setItems(rDAO.Opcion1(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void opciones2(ComboBox<Integer> cb2) {
		Connection conn = Conexion.getConnection();
		cb2.setItems(rDAO.Opcion2(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void opciones3(ComboBox<Integer> cb3) {
		Connection conn = Conexion.getConnection();
		cb3.setItems(rDAO.Opcion3(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void opciones4(ComboBox<Integer> cb4) {
		Connection conn = Conexion.getConnection();
		cb4.setItems(rDAO.Opcion4(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
