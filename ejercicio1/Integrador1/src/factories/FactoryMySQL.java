package factories;

import java.sql.DriverManager;
import java.sql.SQLException;

import daos.DaoCliente;
import daos.DaoFactura;
import daos.DaoFacturaProducto;
import daos.DaoProducto;
import daosImplementation.*;


public class FactoryMySQL extends Factory{
	private static FactoryMySQL instance;
	private String user;
	private String password;
	
	public FactoryMySQL() {
		user = "root";
		password = "";
		driver = "com.mysql.cj.jdbc.Driver";
		uri = "jdbc:mysql://localhost:3306/integrador1";
	}
	@Override
	public void beginConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conex = DriverManager.getConnection(uri, user, password);
			conex.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		try {
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public DaoCliente getDaoCliente() {
		return new DaoClienteImplDerby(conex);
	}

	@Override
	public DaoProducto getDaoProducto() {
		return new DaoProductoImplDerby(conex);
	}

	@Override
	public DaoFactura getDaoFactura() {
		return new DaoFacturaImplDerby(conex);
	}

	@Override
	public DaoFacturaProducto getDaoFacturaProducto() {
		return new DaoFacturaProductImplDerby(conex);
	}
	
	public static synchronized FactoryMySQL getInstance() {
		if(instance == null) {
			instance = new FactoryMySQL();
		}
		return instance;
	}
	
	
}
