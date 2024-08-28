package daos;

import java.util.List;


import entities.FacturaProducto;

public interface DaoFacturaProducto {
	public void insert(FacturaProducto FacturaProducto);
	public List<FacturaProducto> getAll();
	public void deleteTable();
	public void createTable();
}
