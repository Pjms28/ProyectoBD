import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
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
	
	public String modificarReceta(Connection conn, Receta rec) {
		PreparedStatement pst = null;
		String sql = "UPDATE RECETA SET  DESCRIPCION= ?, FECHA= ?, HORA= ?"
				+ "WHERE RECETAID = ?";
		
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1, rec.getDescripcion());
			pst.setString(2, rec.getFecha());
			pst.setString(3, rec.getHora());
			pst.setInt(4, rec.getRecetaID());
			mensaje = "MODIFICADO CORRECTAMENTE";
			pst.execute();
			pst.close();
			
				
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
	
	public void mostrarVisita(Connection conn, TableView<Receta> tv) {
		
	}

}
