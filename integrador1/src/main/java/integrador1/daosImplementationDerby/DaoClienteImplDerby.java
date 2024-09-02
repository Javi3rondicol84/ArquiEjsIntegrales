package integrador1.daosImplementationDerby;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integrador1.daos.DaoCliente;
import integrador1.entities.Cliente;

public class DaoClienteImplDerby implements DaoCliente{
	private Connection conex;
	
	public DaoClienteImplDerby(Connection conex) {
		this.conex = conex; 
	}

	@Override
	public void insert(Cliente cliente) {
		String query = "INSERT INTO cliente (idCliente,nombre,email) VALUES (?,?,?)";
		try {
			PreparedStatement ps = conex.prepareStatement(query);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNombre());
			ps.setString(3,cliente.getEmail());
			ps.executeUpdate();
			ps.close();
			conex.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cliente> getAll() {
		List<Cliente> clientes = new ArrayList<>();
		String query = "SELECT * FROM cliente";
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				clientes.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public void deleteTable() {
		String query = "DROP TABLE IF EXISTS cliente";
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
		String query = "CREATE TABLE cliente(idCliente INT, "
				+ "nombre VARCHAR(500),"
				+ "email VARCHAR(500),"
				+ " PRIMARY KEY(idCliente))";
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
