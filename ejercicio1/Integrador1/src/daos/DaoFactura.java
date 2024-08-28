package daos;

import java.util.List;

import entities.Factura;

public interface DaoFactura {
	public void insert(Factura factura);
	public List<Factura> getAll();
	public void deleteTable();
	public void createTable();
}
