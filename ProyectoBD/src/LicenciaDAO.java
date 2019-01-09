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
		String sql="INSERT INTO LICENCIA (LICENCIAID, DESCRIPCION, SERVICIOID, FECHA_INICIO, FECHA_FIN) " + 
		"VALUES(LICENCIA_SEQ.NEXTVAL,?,?,?,?)"; 
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, lin.getDescripcion());
			pst.setInt(2, lin.getServicioID());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = format.parse(lin.getFecha_inicio());
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			pst.setDate(3, sqldate);
			
		
			java.util.Date date2 = format.parse(lin.getFecha_fin());
			java.sql.Date sqldate2 = new java.sql.Date(date2.getTime());
			pst.setDate(4, sqldate2);
			pst.execute();
			pst.close();
			
			mensaje = "GUARDADO CORRECTAMENTE";
			
			
		}catch(SQLException e) {
			mensaje = "HA OCURRIDO EL SIGUENTE ERROR9: \n" + e.getMessage();
		}
		return mensaje;
		
	}
	
	public String modificarLicencia(Connection conn, Licencia lin) throws ParseException {
		PreparedStatement pst= null;
		String sql="UPDATE LICENCIA SET DESCRIPCION = ?, SERVICIOID = ?, FECHA_INICIO = ?, FECHA_FIN = ?"
				+ "WHERE LICENCIAID = ?"; 
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, lin.getDescripcion());
			pst.setInt(2, lin.getServicioID());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = format.parse(lin.getFecha_inicio());
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			pst.setDate(3, sqldate);
			
		
			java.util.Date date2 = format.parse(lin.getFecha_fin());
			java.sql.Date sqldate2 = new java.sql.Date(date2.getTime());
			
			pst.setDate(3, sqldate);
			pst.setDate(4, sqldate2);
			
			pst.setInt(5, lin.getLicenciaID());
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
		String sql = "DELETE FROM LICENCIA WHERE LICENCIAID = ?"; 
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
				lic.add(new Licencia(rs.getInt(1),rs.getString(2), rs.getDate(4).toString(), rs.getDate(5).toString()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lic;
	}
	
	public ObservableList<String> servicioID(Connection conn){
		ObservableList<String> opciones = FXCollections.observableArrayList();
		String sql = "SELECT * FROM VISITA";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				opciones.add(String.valueOf(rs.getInt(1)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return opciones;
		
	}
	
	public ObservableList<String> L1(Connection conn, int id) {
		ObservableList<String> lic = FXCollections.observableArrayList();
		String sql = "SELECT * FROM LICENCIA WHERE LICENCIAID = ?";
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				lic.addAll(String.valueOf(rs.getInt(1)),rs.getString(2),String.valueOf(rs.getInt(3)) ,rs.getDate(4).toString(), rs.getDate(5).toString());
			}
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lic;
	}
	
	public ObservableList<String> Detalle(ObservableList<String> detalle, Connection conn, int visitaid){
		String sql = "SELECT * FROM VISITA WHERE SERVICIOID = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, visitaid);
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
	
	public long [] DetalleAdmision(int Aid, Connection conn){
		long a[] = new long[3];
		String sql = "SELECT * FROM ADMISIONES WHERE ADMISIONID = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		long Pid = 0;
		long Mid = 0;
		long Hid = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Aid);
			rs = pst.executeQuery();
			while(rs.next()) {
				Pid = rs.getLong(2);
				Mid = rs.getLong(3);
				Hid = rs.getLong(5);
			}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a[0] = Pid;
		a[1] = Mid;
		a[2] = Hid;
		return a;
	}


}
