package integrador1.daos;

import java.util.List;

import integrador1.entities.Factura;

public interface DaoFactura {
	public void insert(Factura factura);
	public List<Factura> getAll();
	public void deleteTable();
	public void createTable();
}
