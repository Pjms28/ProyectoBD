import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.sql.Statement;

//Capa de datos
//Ojo se deberan crear secuencias
//LICENCIA_SEQ'
//Esas secuencias seran agregadas a oracle
//E

public class LicenciaDAO {
	private String mensaje = "";
	
	public String agregarLicencia(Connection conn, Licencia lin) throws ParseException {
		PreparedStatement pst= null;
		String sql="INSERT INTO LICENCIA (LICENCIAID, DESCRIPCION, SERVICIOID, FECHA_INICIO, FECHA_FIN) " + "VALUES(LICENCIA_SEQ.NEXTVAL,?,?,?,?)"; 
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, lin.getServicioID());
			pst.setString(2, lin.getDescripcion());

			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = format.parse(lin.getFecha_inicio());
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			pst.setDate(3, sqldate);
		
			java.util.Date date2 = format.parse(lin.getFecha_fin());
			java.sql.Date sqldate2 = new java.sql.Date(date.getTime());
			pst.setDate(4, sqldate2);
			pst.execute();
			pst.close();
			
			mensaje = "GUARDADO CORRECTAMENTE";
			
			
		}catch(SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR9: \n" + e.getMessage();
		}
		return mensaje;
		
	}
	
	public String modificarLicencia(Connection conn, Licencia lin) {
		PreparedStatement pst= null;
		String sql="UPDATE LICENCIA SET DESCRIPCION = ?, SERVICIOID = ?, FECHA_INICIO = ?, FECHA_FIN = ?"
				+ "WHERE LICENCIAID = ?"; 
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, lin.getDescripcion());
			pst.setInt(2, lin.getServicioID());
			pst.setString(3, lin.getFecha_inicio());
			pst.setString(4, lin.getFecha_fin());
			pst.setInt(5, lin.getServicioID());
			pst.execute();
			pst.close();
			mensaje = "MODIFICADO CORRECTAMENTE";
			
			
		}catch(SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
		}
		
		return mensaje;
		
	}
	public String eliminarLicencia(Connection conn, int id) {
		PreparedStatement pst= null;
		String sql="DELETE FROM VISITA WHERE LICENCIAID = ?"; 
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			pst.close();
			mensaje = "Eliminado CORRECTAMENTE";
			
			
		}catch(SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR: \n" + e.getMessage();
		}
		return mensaje;
		
	}
	
	public ObservableList<Licencia> mostrarVisita(Connection conn) {
		ObservableList<Licencia> lic = FXCollections.observableArrayList();
		String sql = "SELECT * FROM LICENCIA";
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				lic.add(new Licencia(rs.getInt(1),rs.getString(2), rs.getDate(3).toString(),  rs.getDate(4).toString()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lic;
	}
	
	

}
