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

public class RecetaDAO {
	private String mensaje = "";
	
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
	
	public ObservableList<Receta> mostrarReceta(Connection conn) {
		ObservableList<Receta> rec = FXCollections.observableArrayList();
		String sql = "SELECT * FROM RECETA";
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				rec.add(new Receta(rs.getInt(1),rs.getInt(2),rs.getDate(4).toString(),rs.getString(3),rs.getString(5)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rec;
		
		
	}

}
