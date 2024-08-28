package factories;
import daos.DaoCliente;
import daos.DaoFactura;
import daos.DaoFacturaProducto;
import daos.DaoProducto;

import java.sql.Connection;

public abstract class Factory {
	protected String driver;
	protected String uri;
	protected Connection conex;
	
	public abstract void beginConnection();
	public abstract void closeConnection();
	public abstract DaoCliente getDaoCliente();
	public abstract DaoProducto getDaoProducto();
	public abstract DaoFactura getDaoFactura();
	public abstract DaoFacturaProducto getDaoFacturaProducto();
	public static Factory getFactory(String base) {
		switch(base) {
		case("MySQL") : {
			return FactoryMySQL.getInstance();
		}
		case("Derby") : {
			return FactoryDerby.getInstance();
		}
		default : {
			return null;
		}
		}
	};
	
	
}
