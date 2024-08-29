package integrador1.daos;

import java.util.List;


import integrador1.entities.Producto;

public interface DaoProducto {
	public void insert(Producto producto);
	public List<Producto> getAll();
	public void deleteTable();
	public void createTable();
}
