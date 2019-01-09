import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class VisitaBO {

private String mensaje = "";
private VisitaDAO vDAO = new VisitaDAO();
	
	public String agregarVisita(Visita vis) throws SQLException {
		Connection conn = Conexion.getConnection();
		try {
			mensaje = vDAO.agregarVisita(conn, vis);
			conn.commit();
		} catch (Exception e) {
			mensaje = mensaje + " " + e.getMessage();
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
	
	public String eliminarVisita(long id) throws SQLException {
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
	
	public void mostrarVisita(TableView<Visita> tv) {
		Connection conn = Conexion.getConnection();
		tv.setItems(vDAO.mostrarVisita(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void opciones(ComboBox<String> cb) {
		Connection conn = Conexion.getConnection();
		cb.setItems(vDAO.Opciones(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void detalle(Long id, TextArea ta) {
		ObservableList<String> d = FXCollections.observableArrayList();
		Connection conn = Conexion.getConnection();
		long a[] = new long [3];
		 a = vDAO.DetalleAdmision(Integer.parseInt(vDAO.Detalle(conn, id).get(1)), conn);
		d = vDAO.DetalleR(vDAO.Detalle(conn, id), conn, a[0], a[1], a[2]);
		if(d.get(6).equalsIgnoreCase("Consulta")) {
			ta.setText("DETALLE DE LA VISITA:\n"
					+ "Nombre del paciente: " + d.get(9) + "\n"
					+ "Nombre del medico: " + d.get(10) + "\n"
					+ "Nombre del hospital" + d.get(11) + "\n"
					+ "Numero de la visita: " + d.get(0) + "\n"
					+ "Numero de la admision: " + d.get(1) + "\n"
					+ "Fecha de la visita: " + d.get(2) + "\n"
					+ "Descripcion de la visita: " + d.get(3) + "\n"
					+ "Hora de la visita: " + d.get(4) + "\n"
					+ "Enfermedad: " + d.get(5) + "\n"
					+ "Tipo del a visita: " + d.get(6) + "\n"
					+ "Tipo de la consulta: " + d.get(7) + "\n"
					+ "Sintomas: " + d.get(8));
		}
		else {
			ta.setText("DETALLE DE LA VISITA:\n"
					+ "Nombre del paciente: " + d.get(8) + "\n"
					+ "Nombre del medico: " + d.get(9) + "\n"
					+ "Nombre del hospital: " + d.get(10) + "\n"
					+ "Numero de la visita: " + d.get(0) + "\n"
					+ "Numero de la admision: " + d.get(1) + "\n"
					+ "Fecha de la visita: " + d.get(2) + "\n"
					+ "Descripcion de la visita: " + d.get(3) + "\n"
					+ "Hora de la visita: " + d.get(4) + "\n"
					+ "Enfermedad: " + d.get(5) + "\n"
					+ "Tipo del a visita: " + d.get(6) + "\n"
					+ "Numero de camilla: " + d.get(7));
		}
		
	}
}
