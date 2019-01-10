import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

//saludos
//fd
public class RecetaDAO {
	private String mensaje = "";
	
	public String agregarRecetaAnalisis(Connection conn, RecetaAnalisis reca) throws ParseException {
		PreparedStatement pst1 = null;
		String sql1 = "INSERT INTO RECETAANALISIS (RECETAANALISISID, RECETAID, ANALISISID)"
				+ "VALUES(RECETAANALISIS_SEQ.NEXTVAL,?,?)";
		
		try{
			pst1 = conn.prepareStatement(sql1);
			
			pst1.setInt(1, reca.getRecetaID());
			pst1.setInt(2, reca.getAnalisisID());
			pst1.execute();
			pst1.close();
			mensaje = "GUARDADO CORRECTAMENTE";
			System.out.println(mensaje);
				
		} catch (SQLException e){
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			
			
		}
		
		return mensaje;
	}
	
	public String agregarRecetaMedicina(Connection conn, RecetaMedicina recm) throws ParseException {
		PreparedStatement pst1 = null;
		String sql1 = "INSERT INTO RECETAMEDINA (RECETAMEDICINAID, MEDICINAID, RECETAID, DOSIS)"
				+ "VALUES(RECETAMEDICINA_SEQ.NEXTVAL,?,?,?)";
		try{
			pst1 = conn.prepareStatement(sql1);
			pst1.setInt(1, recm.getMedicinaID());
			pst1.setInt(2, recm.getRecetaID());
			pst1.setString(3, recm.getDosis());
			mensaje = "GUARDADO CORRECTAMENTE";
			pst1.execute();
			pst1.close();
				
		} catch (SQLException e){
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			
			
		}
		return mensaje;
		
	}
	
	
	public String agregarReceta(Connection conn, Receta rec) throws ParseException {
		PreparedStatement pst = null;
		String sql = "INSERT INTO RECETA (RECETAID, SERVICIOID, DESCRIPCION, FECHA, HORA)"
				+ "VALUES(RECETA_SEQ.NEXTVAL,?,?,?,?)";
		
		try{
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rec.getServicioID());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = format.parse(rec.getFecha());
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			pst.setString(2, rec.getDescripcion());
			pst.setDate(3, sqldate);
			pst.setString(4, rec.getHora());
			mensaje = "GUARDADO CORRECTAMENTE";
			pst.execute();
			pst.close();
			
				
		} catch (SQLException e){
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			
			
		}
		return mensaje;
	}
	
	public ObservableList<Integer> Opcion1(Connection conn){
		ObservableList<Integer> opciones = FXCollections.observableArrayList();
		String sql = "SELECT SERVICIOID FROM VISITA";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				opciones.add(rs.getInt(1));
			}
		} catch (Exception e) {
	
			System.out.println(e.getMessage());
		}
		return opciones;
	}
	
	public ObservableList<Integer> Opcion2(Connection conn){
		ObservableList<Integer> opciones2 = FXCollections.observableArrayList();
		String sql = "SELECT RECETAID FROM RECETA";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				opciones2.add(rs.getInt(1));
			}
		} catch (Exception e) {
	
			System.out.println(e.getMessage());
		}
		return opciones2;
	}
	
	public ObservableList<Integer> Opcion3(Connection conn){
		ObservableList<Integer> opciones3 = FXCollections.observableArrayList();
		String sql = "SELECT MEDICINAID FROM MEDICINA";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				opciones3.add(rs.getInt(1));
			}
		} catch (Exception e) {
	
			System.out.println(e.getMessage());
		}
		return opciones3;
	}
	
	public ObservableList<Integer> Opcion4(Connection conn){
		ObservableList<Integer> opciones4 = FXCollections.observableArrayList();
		String sql = "SELECT ANALISISID FROM ANALISIS";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				opciones4.add(rs.getInt(1));
			}
		} catch (Exception e) {
	
			System.out.println(e.getMessage());
		}
		return opciones4;
	}
	
	public String modificarRecetaAnalisis(Connection conn, RecetaAnalisis reca) throws ParseException {
		PreparedStatement pst2 = null;
		String sql2 = "UPDATE RECETAANALISIS SET RECETAID= ?, ANALISISID= ?" + "WHERE RECETAANALISISID = ?";
		
		try{
			pst2 = conn.prepareStatement(sql2);
			pst2.setInt(1, reca.getRecetaID());
			pst2.setInt(2, reca.getAnalisisID());
			pst2.setInt(3, reca.getRecetaanalisisID());
			mensaje = "MODIFICADO CORRECTAMENTE";
			System.out.println(mensaje);
			pst2.execute();
			pst2.close();
				
		} catch (SQLException e){
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			
			
		}
		
		return mensaje;
	}
	
	public String modificarRecetaMedicamento(Connection conn, RecetaMedicina recm) throws ParseException {
		PreparedStatement pst1 = null;
		String sql1 = "UPDATE RECETAMEDINA SET MEDICINAID= ?, RECETAID= ?, DOSIS= ?" + "WHERE RECETAMEDICINAID = ?";
		
		try{
			pst1 = conn.prepareStatement(sql1);
			pst1.setInt(1, recm.getRecetaID());
			pst1.setInt(2, recm.getMedicinaID());
			pst1.setString(3, recm.getDosis());
			pst1.setInt(4, recm.getRecetamedicinaID());
			mensaje = "MODIFICADO CORRECTAMENTE";
			pst1.execute();
			pst1.close();
		
		} catch (SQLException e){
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			
			
		}
		
		return mensaje;
	}
	
	
	
	public String modificarReceta(Connection conn, Receta rec) throws ParseException {
		PreparedStatement pst = null;
		String sql = "UPDATE RECETA SET DESCRIPCION= ?, FECHA= ?, HORA= ?, SERVICIOID= ?" + "WHERE RECETAID = ?";
		
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1, rec.getDescripcion());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = format.parse(rec.getFecha());
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			pst.setDate(2,sqldate);
			pst.setString(3, rec.getHora());
			pst.setInt(4, rec.getServicioID());
			pst.setInt(5, rec.getRecetaID());
			mensaje = "MODIFICADO CORRECTAMENTE";
			pst.execute();
			pst.close();
			//System.out.println(mensaje);
				
		} catch (SQLException e){
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
			
			
		}
		
		return mensaje;
	}
	
	public String eliminarReceta(Connection conn, int id) {
		PreparedStatement pst = null;
		String sql = "DELETE FROM RECETA WHERE RECETAID = ?";
		
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
	public String eliminarRecetaMedicina(Connection conn, int id) {
		PreparedStatement pst1 = null;
		String sql1 = "DELETE FROM RECETAMEDINA WHERE RECETAMEDICINAID = ?";
		try {
			pst1 = conn.prepareStatement(sql1);
			pst1.setInt(1, id);
			mensaje = "Eliminado CORRECTAMENTE";
			pst1.execute();
			pst1.close();
		} catch (SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
		} 	
		return mensaje;
	}
	
	public String eliminarRecetaAnalisis(Connection conn, int id) {
		PreparedStatement pst2 = null;          
		String sql2 = "DELETE FROM RECETAANALISIS WHERE RECETAANALISISID = ?";
		try {
			pst2 = conn.prepareStatement(sql2);
			pst2.setInt(1, id);
			mensaje = "Eliminado CORRECTAMENTE";
			pst2.execute();
			pst2.close();
		} catch (SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
		} 	
		return mensaje;
	}
	
	
	
	public ObservableList<Receta> mostrarReceta(Connection conn) {
		ObservableList<Receta> rec = FXCollections.observableArrayList();
		String sql = "SELECT * FROM RECETA";
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				rec.add(new Receta(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDate(4).toString(),rs.getString(5)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rec;
		
		
	}
	
	public ObservableList<RecetaMedicina> mostrarTReceta(Connection conn) {
		ObservableList<RecetaMedicina> recm = FXCollections.observableArrayList();
		String sql = "SELECT * FROM RECETAMEDINA";
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				recm.add(new RecetaMedicina(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return recm;
		
		
	}
	
	public ObservableList<RecetaAnalisis> mostrarTAReceta(Connection conn) {
		ObservableList<RecetaAnalisis> reca = FXCollections.observableArrayList();
		String sql = "SELECT * FROM RECETAANALISIS";
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				reca.add(new RecetaAnalisis(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reca;
		
		
	}

}