package integrador1.daosImplementationMySQL;

import integrador1.daos.DaoCliente;
import integrador1.dtos.ClienteDTO;
import integrador1.entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoClienteImplMySQL implements DaoCliente {
    private Connection conex;

    public DaoClienteImplMySQL(Connection conex) {
        this.conex = conex;
    }

    @Override
    public void insert(Cliente cliente) {
        String query = "INSERT INTO cliente (idCliente,nombre,email) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3,cliente.getEmail());
            ps.executeUpdate();
            ps.close();
            conex.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                clientes.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void deleteTable() {
        String query = "DROP TABLE IF EXISTS cliente";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
            conex.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS cliente(idCliente INT, "
                + "nombre VARCHAR(500),"
                + "email VARCHAR(500),"
                + " PRIMARY KEY(idCliente))";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
            conex.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public List<ClienteDTO> getListOfClients(){
        String query = "SELECT SUM(fp.cantidad * p.valor) AS facturacion, " +
                "c.idCliente, c.nombre " +
                "FROM cliente c " +
                "JOIN factura f ON c.idCliente = f.idCliente " +
                "JOIN facturaproducto fp ON f.idFactura = fp.idFactura " +
                "JOIN producto p ON p.idProducto = fp.idProducto " +
                "GROUP BY c.idCliente, c.nombre " +
                "ORDER BY facturacion DESC";
        PreparedStatement ps = null;
        try {
            ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<ClienteDTO> clientes = new ArrayList<>();
            while(rs.next()) {
                clientes.add(new ClienteDTO(rs.getInt(1),rs.getString(3)));
            }
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
