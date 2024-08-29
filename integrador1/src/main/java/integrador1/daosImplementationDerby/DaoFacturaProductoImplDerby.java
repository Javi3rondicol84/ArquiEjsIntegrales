package integrador1.daosImplementationDerby;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import integrador1.daos.DaoFacturaProducto;
import integrador1.entities.Factura;
import integrador1.entities.FacturaProducto;


public class DaoFacturaProductoImplDerby implements DaoFacturaProducto{
	private Connection conex;

	public DaoFacturaProductoImplDerby(Connection conex) {
		this.conex = conex;
	}
	@Override
	public void insert(FacturaProducto facturaProducto) {
		String query = "INSERT INTO factura (idFacutura INT,idProducto INT,cantidad INT) VALUES (?,?,?)";
		try {
			PreparedStatement ps = conex.prepareStatement(query);
			ps.setInt(1,facturaProducto.getIdFactura());
			ps.setInt(2,facturaProducto.getIdProducto());
			ps.setInt(3,facturaProducto.getCantidad());
			ps.executeUpdate();
			ps.close();
			conex.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<FacturaProducto> getAll() {
		List<FacturaProducto> facturasProductos = new ArrayList<>();
		String query = "SELECT * FROM facturaProducto";
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				facturasProductos.add(new FacturaProducto(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return facturasProductos;
	}

	@Override
	public void deleteTable() {
		String query = "DROP TABLE IF EXISTS facturaProducto";
		try {
			PreparedStatement ps = conex.prepareStatement(query);
			ps.executeQuery();
			ps.close();
			conex.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createTable() {
		String query = "CREATE TABLE IF NOT EXISTS facturaProducto(idFactura INT, "
				+ " idProducto INT,"
				+ " cantidad INT,";
		try {
			PreparedStatement ps = conex.prepareStatement(query);
			ps.executeQuery();
			ps.close();
			conex.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
