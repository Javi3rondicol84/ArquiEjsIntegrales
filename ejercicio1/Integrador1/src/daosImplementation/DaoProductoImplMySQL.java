package daosImplementation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.DaoProducto;
import entities.Producto;

public class DaoProductoImplMySQL implements DaoProducto {
    private Connection conex;

    public DaoProductoImplDerby(Connection conex) {
        this.conex = conex;
    }

    public void insert(FacturaProducto facturaProducto) {
        String query = "INSERT INTO producto (idProducto,nombre,valor) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, producto.getIdProducto());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3,producto.getValor());
            ps.executeUpdate();
            ps.close();
            conex.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<DaoProducto> getAll() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto";
        PreparedStatement ps;
        try {
            ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                productos.add(new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public void deleteTable() {
        String query = "DROP TABLE IF EXISTS producto";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.executeQuery();
            ps.close();
            conex.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS producto(idProducto INT,"
                + "nombre VARCHAR(45),"
                + "valor FLOAT,"
                + "PRIMARY KEY(idProducto))";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.executeQuery();
            ps.close();
            conex.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
