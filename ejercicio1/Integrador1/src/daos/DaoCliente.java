package daos;

import java.util.List;
import entities.Cliente;

public interface DaoCliente {
	public void insert(Cliente cliente);
	public List<Cliente> getAll();
	public void deleteTable();
	public void createTable();
}
