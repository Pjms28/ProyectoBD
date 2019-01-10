
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VisitaDAO {
	
	private String mensaje = "";
	
	public String agregarVisita(Connection conn, Visita vis) throws ParseException {
		PreparedStatement pst = null;
		System.out.println(vis.getTipoVisita());
		if(vis.getTipoVisita().equals("CONSULTA")) {
			String sql = "INSERT INTO VISITA (SERVICIOID, ADMISIONID, FECHA, DESCRIPCION, HORA, ENFERMEDAD, TIPOVISITA, TIPOCONSULTA, SINTOMAS)"
					+ "VALUES(VISITA_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
			
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, vis.getAdmisionID());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
					+ "VALUES(VISITA_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
			
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, vis.getAdmisionID());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
	
	public String modificarVisita(Connection conn, Visita vis) throws ParseException {
		PreparedStatement pst = null;
		
			String sql = "UPDATE VISITA SET FECHA = ?, DESCRIPCION = ?, HORA = ?, ENFERMEDAD = ?, TIPOVISITA = ?, TIPOCONSULTA = ?, SINTOMAS = ?, NUMEROCAMILLA = ?, ADMISIONID = ?"
					+ "WHERE SERVICIOID = ?";
			try {
				pst = conn.prepareStatement(sql);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = format.parse(vis.getFecha());
				java.sql.Date sqldate = new java.sql.Date(date.getTime());
				pst.setDate(1, sqldate);
				pst.setString(2, vis.getDescripcion());
				pst.setString(3, vis.getHora());
				pst.setString(4, vis.getEnfermedad());
				pst.setString(5, vis.getTipoVisita());
				pst.setString(6, vis.getTipoConsulta());
				pst.setString(7, vis.getSintomas());
				pst.setInt(8, vis.getNumeroCamilla());
				pst.setInt(9, vis.getAdmisionID());
				pst.setLong(10, vis.getServicioID());
				mensaje = "MODIFICADO CORRECTAMENTE";
				pst.execute();
				pst.close();
			} catch (SQLException e) {
				mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			} 	
		return mensaje;
	}
	
	public String eliminarVisita(Connection conn, long id) {	
		String sql = "DELETE FROM VISITA WHERE SERVICIOID = ?";
		PreparedStatement pst = null;	
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, id);
			mensaje = "Eliminado CORRECTAMENTE";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			mensaje = "Por favor verificar si existen Recetas o Licencias con esta visita antes de eliminar";
		} 		
		
		return mensaje;
	}
	
	public ObservableList<Visita> mostrarVisita(Connection conn) {
		ObservableList<Visita> vis = FXCollections.observableArrayList();
		String sql = "SELECT * FROM VISITA";
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				vis.add(new Visita(rs.getLong(1),rs.getString(7), rs.getString(6)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vis;
	}
	
	public ObservableList<String> Opciones(Connection conn){
		ObservableList<String> opciones = FXCollections.observableArrayList();
		String sql = "SELECT * FROM ENFERMEDAD";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				opciones.add(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return opciones;
	}
	
	public ObservableList<String> Detalle(Connection conn, long visitaid){
		ObservableList<String> detalle = FXCollections.observableArrayList();
		String sql = "SELECT * FROM VISITA WHERE SERVICIOID = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, visitaid);
			rs = pst.executeQuery();
			while(rs.next()) {
				detalle.addAll(String.valueOf(rs.getInt(1)),String.valueOf(rs.getInt(2)),String.valueOf(rs.getDate(3)), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
				if(rs.getString(7).equalsIgnoreCase("Consulta")) {
					detalle.addAll(rs.getString(8),rs.getString(9));
				}
				else {
					detalle.add(String.valueOf(rs.getInt(11)));
				}
			}
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return detalle;
	}
	
	public long [] DetalleAdmision(int Aid, Connection conn){
		long a[] = new long[2];
		String sql = "SELECT * FROM ADMISIONES WHERE ADMISIONID = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		long Pid = 0;
		long Mid = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Aid);
			rs = pst.executeQuery();
			while(rs.next()) {
				Pid = rs.getLong(2);
				Mid = rs.getLong(3);
			}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a[0] = Pid;
		a[1] = Mid;
		return a;
	}
	
	public ObservableList<String> DetalleR(ObservableList<String> detalle,Connection conn, long Pid,long Mid, long Hid) {
		String sql = "SELECT NOMBRE FROM PERSONA WHERE CEDULA = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, Pid);
			rs = pst.executeQuery();
			while(rs.next()) {
				detalle.add(rs.getString(1));
			}
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		sql = "SELECT NOMBRE FROM PERSONA WHERE CEDULA = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, Mid);
			rs = pst.executeQuery();
			while(rs.next()) {
				detalle.add(rs.getString(1));
			}
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		sql = "SELECT NOMBRE_HOSPITAL FROM HOSPITAL WHERE HOSPITALID = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, Hid);
			rs = pst.executeQuery();
			while(rs.next()) {
				detalle.add(rs.getString(1));
			}
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return detalle;
	}
		
}