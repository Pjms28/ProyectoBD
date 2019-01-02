import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;

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
			pst.setString(1, lin.getDescripcion());
			pst.setInt(2, lin.getServicioID());
			
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
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
	public void mostrarLicencia() {

		
	}
	
	

}
