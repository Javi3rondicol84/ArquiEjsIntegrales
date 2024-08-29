package integrador1.factories;

import java.sql.DriverManager;
import java.sql.SQLException;

import integrador1.daos.DaoCliente;
import integrador1.daos.DaoFactura;
import integrador1.daos.DaoFacturaProducto;
import integrador1.daos.DaoProducto;
import integrador1.daosImplementationMySQL.*;


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
		return new DaoClienteImplMySQL(conex);
	}

	@Override
	public DaoProducto getDaoProducto() {
		return new DaoProductoImplMySQL(conex);
	}

	@Override
	public DaoFactura getDaoFactura() {
		return new DaoFacturaImplMySQL(conex);
	}

	@Override
	public DaoFacturaProducto getDaoFacturaProducto() {
		return new DaoFacturaProductoImplMySQL(conex);
	}
	
	public static synchronized FactoryMySQL getInstance() {
		if(instance == null) {
			instance = new FactoryMySQL();
		}
		return instance;
	}
	
	
}
