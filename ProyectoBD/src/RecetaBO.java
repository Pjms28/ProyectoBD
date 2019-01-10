import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import org.controlsfx.control.textfield.TextFields;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RecetaBO {
	
	private String mensaje= "";
	private RecetaDAO rDAO= new RecetaDAO();
	
	public String agregarReceta( Receta rec) throws ParseException, SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.agregarReceta(conn, rec);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	
	public String agregarRecetaAnalisis(RecetaAnalisis reca) throws ParseException, SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.agregarRecetaAnalisis(conn, reca);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	
	
	public String agregarRecetaMedicina(RecetaMedicina recm) throws ParseException, SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.agregarRecetaMedicina(conn, recm);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	
	
	
	public String modificarReceta(Receta rec) throws SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.modificarReceta(conn, rec);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	
	public String modificarRecetaAnalisis(RecetaAnalisis reca) throws SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.modificarRecetaAnalisis(conn, reca);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	
	public String modificarRecetaMedicina(RecetaMedicina recm) throws SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.modificarRecetaMedicamento(conn, recm);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	

	
	public String eliminarReceta( int id) throws SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.eliminarReceta(conn, id);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	
	public String eliminarRecetaAnalisis(int id) throws SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.eliminarRecetaAnalisis(conn, id);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	
	public String eliminarRecetaMedicina( int id) throws SQLException {
		Connection conn = Conexion.getConnection();
		try{
			mensaje= rDAO.eliminarRecetaMedicina(conn, id);
			conn.commit();
			}catch (Exception e) {
				mensaje = mensaje + " " +e.getMessage();
				conn.rollback();
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
	
	
	
	public void mostrarRecetaMedicina(TableView<RecetaMedicina> tv) {
		Connection conn = Conexion.getConnection();
		tv.setItems(rDAO.mostrarTReceta(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void mostrarRecetaAnalisis(TableView<RecetaAnalisis> tv) {
		Connection conn = Conexion.getConnection();
		tv.setItems(rDAO.mostrarTAReceta(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void mostrarReceta(TableView<Receta> tv) {
		Connection conn = Conexion.getConnection();
		tv.setItems(rDAO.mostrarReceta(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void opciones1(ComboBox<Integer> cb) {
		Connection conn = Conexion.getConnection();
		cb.setItems(rDAO.Opcion1(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void  Id(String id, TextField t) {
		t.setText(id);
	}
	
	
	public void opciones3(ComboBox<Integer> cb3) {
		Connection conn = Conexion.getConnection();
		cb3.setItems(rDAO.Opcion3(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void opciones4(ComboBox<Integer> cb4) {
		Connection conn = Conexion.getConnection();
		cb4.setItems(rDAO.Opcion4(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void info(int id, TextField Paciente, TextField Medico) {
		Connection conn = Conexion.getConnection();
		long a[] = new long [2];
		ObservableList<String> d = FXCollections.observableArrayList();
		d = rDAO.Detalle(conn, id);
		a = rDAO.DetalleAdmision(Integer.parseInt(d.get(0)), conn);
		d = rDAO.DetalleR(d, conn, a[0], a[1]);
		Paciente.setText(d.get(1));
		Medico.setText(d.get(2));
	}
	
	public void autoCompleteM(TextField t) {
		Connection conn = Conexion.getConnection();
		TextFields.bindAutoCompletion(t, rDAO.autoM(conn));
	}
	
	public void autoCompleteA(TextField t) {
		Connection conn = Conexion.getConnection();
		TextFields.bindAutoCompletion(t, rDAO.autoA(conn));
	}
	
	public int idM(String n) {
		Connection conn = Conexion.getConnection();
		int a = 0;
		a = rDAO.idM(conn, n).get(0);
		return a;
	}

	public int idA(String n) {
		Connection conn = Conexion.getConnection();
		int a = 0;
		a = rDAO.idA(conn, n).get(0);
		return a;
	}
}
