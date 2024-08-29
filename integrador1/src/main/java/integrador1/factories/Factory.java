package integrador1.factories;
import integrador1.daos.DaoCliente;
import integrador1.daos.DaoFactura;
import integrador1.daos.DaoFacturaProducto;
import integrador1.daos.DaoProducto;

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
