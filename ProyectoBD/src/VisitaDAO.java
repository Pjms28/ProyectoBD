import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.scene.control.TableView;

public class VisitaDAO {
	
	private String mensaje = "";
	
	public String agregarVisita(Connection conn, Visita vis) throws ParseException {
		PreparedStatement pst = null;
		if(vis.getTipoVisita().equals("Consulta")) {
			String sql = "INSERT INTO VISITA (SERVICIOID, ADMISIONID, FECHA, DESCRIPCION, HORA, ENFERMEDAD, TIPOVISITA, TIPOCONSULTA, SINTOMAS)"
					+ "VALUES(VISITA_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
			
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, vis.getAdmisionID());
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				java.util.Date date = format.parse(vis.getFecha());
				java.sql.Date sqldate = new java.sql.Date(date.getTime());
				pst.setDate(2, sqldate);
				pst.setString(3, vis.getDescripcion());
				pst.setString(4, vis.getHora());
				pst.setString(5, vis.getEnfermedad());
				pst.setString(6, vis.getTipoVisita());
				pst.setString(7, vis.getTipoConsulta());
				pst.setString(8, vis.getSintomas());
				pst.execute();
				pst.close();
				mensaje = "GUARDADO CORRECTAMENTE";
			} catch (SQLException e) {
				mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			}
		}
		else {
			String sql = "INSERT INTO VISITA (SERVICIOID, ADMISIONID, FECHA, DESCRIPCION, HORA, ENFERMEDAD, TIPOVISITA, NUMEROCAMILLA) "
					+ "VALUES(VISITA_SEQ.NEXTVAL,?,?,?,?,?,?)";
			
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, vis.getAdmisionID());
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				java.util.Date date = format.parse(vis.getFecha());
				java.sql.Date sqldate = new java.sql.Date(date.getTime());
				pst.setDate(2, sqldate);
				pst.setString(3, vis.getDescripcion());
				pst.setString(4, vis.getHora());
				pst.setString(5, vis.getEnfermedad());
				pst.setString(6, vis.getTipoVisita());
				//pst.setString(7, vis.getTipoConsulta());				
				//pst.setInt(10, vis.getCitaID());
				pst.setInt(7, vis.getNumeroCamilla());
				mensaje = "GUARDADO CORRECTAMENTE";
				pst.execute();
				pst.close();
			} catch (SQLException e) {
				mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			}
		}
		
		return mensaje;
	}
	
	public String modificarVisita(Connection conn, Visita vis) {
		PreparedStatement pst = null;
		String sql = "UPDATE VISITA SET FECHA = ?, DESCRIPCION = ?, HORA = ?, ENFERMEDAD = ?, TIPOVISITA = ?, TIPOCONSULTA = ?, SINTOMAS = ?, NUMEROCAMILLA = ? "
				+ "WHERE SERVICIOID = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vis.getFecha());
			pst.setString(2, vis.getDescripcion());
			pst.setString(3, vis.getHora());
			pst.setString(4, vis.getEnfermedad());
			pst.setString(5, vis.getTipoVisita());
			pst.setString(6, vis.getTipoConsulta());
			pst.setString(7, vis.getSintomas());
			pst.setInt(8, vis.getNumeroCamilla());
			pst.setInt(9, vis.getServicioID());
			mensaje = "MODIFICADO CORRECTAMENTE";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
		} 		
		
		return mensaje;
	}
	
	public String eliminarVisita(Connection conn, int id) {
		PreparedStatement pst = null;
		String sql = "DELETE FROM VISITA WHERE SERVICIOID = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			mensaje = "Eliminado CORRECTAMENTE";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
		} 		
		
		return mensaje;
	}
	
	public void mostrarVisita(Connection conn, TableView<Visita> tv) {
	}
}
