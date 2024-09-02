package integrador1.daosImplementationDerby;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integrador1.daos.DaoFactura;
import integrador1.entities.Factura;

public class DaoFacturaImplDerby implements DaoFactura{
	
	private Connection conex;
	
	public DaoFacturaImplDerby(Connection conex) {
		this.conex = conex; 
	}

	@Override
	public void insert(Factura factura) {
		String query = "INSERT INTO factura (idFactura, idCliente) VALUES (?,?)";
		try {
			PreparedStatement ps = conex.prepareStatement(query);
			ps.setInt(1, factura.getIdFactura());
			ps.setInt(2, factura.getIdCliente());
			ps.executeUpdate();
			ps.close();
			conex.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Factura> getAll() {
		List<Factura> facturas = new ArrayList<>();
		String query = "SELECT * FROM factura";
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				facturas.add(new Factura(rs.getInt(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return facturas;
	}

	@Override
	public void deleteTable() {
		String query = "DROP TABLE IF EXISTS factura";
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
		String query = "CREATE TABLE factura(idFactura INT, "
				+ " idCliente INT,"
				+ " PRIMARY KEY(idFactura), "
				+ "FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente))";
		try {
			PreparedStatement ps = conex.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
			conex.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
