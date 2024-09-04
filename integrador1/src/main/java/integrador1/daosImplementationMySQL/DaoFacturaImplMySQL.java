 package integrador1.daosImplementationMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integrador1.entities.Factura;

import integrador1.daos.DaoFactura;

public class DaoFacturaImplMySQL implements DaoFactura {

	private Connection conex;
	
	public DaoFacturaImplMySQL(Connection conex) {
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
		try {
			PreparedStatement ps = conex.prepareStatement(query);
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
			ps.executeUpdate();
			ps.close();
			conex.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createTable() {
		String query = "CREATE TABLE IF NOT EXISTS factura(idFactura INT, "
				+ " idCliente INT,"
				+ " PRIMARY KEY(idFactura), "
				+ "FOREIGN KEY (idCliente) REFERENCES cliente(idCliente))";
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
