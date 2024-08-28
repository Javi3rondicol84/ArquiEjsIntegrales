package daos;

import java.util.List;


import entities.Producto;

public interface DaoProducto {
	public void insert(Producto producto);
	public List<Producto> getAll();
	public void deleteTable();
	public void createTable();
}
