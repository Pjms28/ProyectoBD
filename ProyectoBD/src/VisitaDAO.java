import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.TableView;

public class VisitaDAO {
	
	private String mensaje = "";
	
	public String agregarVisita(Connection conn, Visita vis) throws ParseException {
		PreparedStatement pst = null;
		String sql = "INSERT INTO VISITA (SERVICIOID, ADMISIONID, FECHA, DESCRIPCION, HORA, ENFERMEDAD, TIPOVISITA, TIPOCONSULTA, SINTOMAS, CITAID, NUMEROCAMILLA) "
				+ "VALUES(VISITA_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, vis.getAdmisionID());
			Date d = new SimpleDateFormat("dd/MMM/yyyy").parse(vis.getFecha());
			pst.setDate(2,(java.sql.Date) d);
			pst.setString(3, vis.getDescripcion());
			pst.setString(4, vis.getHora());
			pst.setString(5, vis.getEnfermedad());
			pst.setString(6, vis.getTipoVisita());
			pst.setString(7, vis.getTipoConsulta());
			pst.setString(8, vis.getSintomas());
			pst.setInt(9, vis.getCitaID());
			pst.setInt(10, vis.getNumeroCamilla());
			mensaje = "GUARDADO CORRECTAMENTE";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
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
