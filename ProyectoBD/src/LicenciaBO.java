import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

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
	public void mostrarLicencia(TableView<Licencia> tv) {
		Connection conn = Conexion.getConnection();
		tv.setItems(ldao.mostrarVisita(conn)); 
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void opciones(ComboBox<String> cb) {
		Connection conn = Conexion.getConnection();
		cb.setItems(ldao.servicioID(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void detalle(int id, TextArea ta) {
		ObservableList<String> d = FXCollections.observableArrayList();
		Connection conn = Conexion.getConnection();
		long a[] = new long [3];
		d = ldao.L1(conn, id);
		d = ldao.Detalle(d, conn, Integer.valueOf(d.get(2)));
		a = ldao.DetalleAdmision(Integer.valueOf(d.get(6)), conn);
		d = ldao.DetalleR(d, conn, a[0], a[1], a[2]);
		if(d.get(11).equalsIgnoreCase("Consulta")) {
			ta.setText("DETALLE DE LA LICENCIA:\n"
					+ "Nombre del paciente: " + d.get(14) + "\n"
					+ "Nombre del medico: " + d.get(15) + "\n"
					+ "Nombre del hospital" + d.get(16) + "\n"
					+ "Numero de la visita: " + d.get(5) + "\n"
					+ "Numero de la admision: " + d.get(6) + "\n"
					+ "Fecha de la visita: " + d.get(7) + "\n"
					+ "Descripcion de la visita: " + d.get(8) + "\n"
					+ "Hora de la visita: " + d.get(9) + "\n"
					+ "Enfermedad: " + d.get(10) + "\n"
					+ "Tipo del a visita: " + d.get(11) + "\n"
					+ "Tipo de la consulta: " + d.get(12) + "\n"
					+ "Sintomas: " + d.get(13));
		}
		else {
			ta.setText("DETALLE DE LA LICENCIA:\n"
					+ "Nombre del paciente: " + d.get(13) + "\n"
					+ "Nombre del medico: " + d.get(14) + "\n"
					+ "Nombre del hospital: " + d.get(15) + "\n"
					+ "Numero de la visita: " + d.get(5) + "\n"
					+ "Numero de la admision: " + d.get(6) + "\n"
					+ "Fecha de la visita: " + d.get(7) + "\n"
					+ "Descripcion de la visita: " + d.get(8) + "\n"
					+ "Hora de la visita: " + d.get(9) + "\n"
					+ "Enfermedad: " + d.get(10) + "\n"
					+ "Tipo del a visita: " + d.get(11) + "\n"
					+ "Numero de camilla: " + d.get(12));
		}
		
		ta.setText(ta.getText() + "\n"
				+ "Numero de licencia: " + d.get(0) + "\n"
				+ "Descripcion: " + d.get(1) + "\n"
				+ "Fecha de Inicio: " + d.get(3) + "\n"
				+ "Fecha de Fin: " + d.get(4));
	}

}
