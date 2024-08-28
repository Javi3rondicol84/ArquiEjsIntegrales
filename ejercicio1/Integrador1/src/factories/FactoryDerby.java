package factories;

import java.sql.DriverManager;
import java.sql.SQLException;

import daos.DaoCliente;
import daos.DaoFactura;
import daos.DaoFacturaProducto;
import daos.DaoProducto;
import daosImplementation.*;

public class FactoryDerby extends Factory{
	private static FactoryDerby instance;
	
	public FactoryDerby() {
		driver =  "org.apache.derby.jdbc.EmbeddedDriver";
		uri =  "jdbc:derby:MyDerbyDb;create=true";
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
			conex = DriverManager.getConnection(uri);
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
		return new DaoFacturaImplDerby(conex);
	}

	@Override
	public DaoFacturaProducto getDaoFacturaProducto() {
		return new DaoFacturaProductImplMySQL(conex);
	}
	
	public static FactoryDerby getInstance() {
		if(instance == null) {
			instance = new FactoryDerby();
		}
		return instance;
	}
	
}
