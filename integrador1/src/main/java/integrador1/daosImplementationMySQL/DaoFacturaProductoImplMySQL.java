package integrador1.daosImplementationMySQL;

import integrador1.daos.DaoFacturaProducto;
import integrador1.entities.FacturaProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoFacturaProductoImplMySQL implements DaoFacturaProducto{
    private Connection conex;

    public DaoFacturaProductoImplMySQL(Connection conex) {
        this.conex = conex;
    }
    @Override
    public void insert(FacturaProducto facturaProducto) {
        String query = "INSERT INTO facturaproducto (idFactura,idProducto,cantidad) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1,facturaProducto.getIdFactura());
            ps.setInt(2,facturaProducto.getIdProducto());
            ps.setInt(3,facturaProducto.getCantidad());
            ps.executeUpdate();
            ps.close();
            conex.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<FacturaProducto> getAll() {
        List<FacturaProducto> facturasProductos = new ArrayList<>();
        String query = "SELECT * FROM facturaProducto";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                facturasProductos.add(new FacturaProducto(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return facturasProductos;
    }

    @Override
    public void deleteTable() {
        String query = "DROP TABLE IF EXISTS facturaproducto";
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
        String query = "CREATE TABLE IF NOT EXISTS facturaproducto(idFactura INT, "
                + " idProducto INT, "
                + " cantidad INT, "
                + "PRIMARY KEY(idFactura, idProducto), "
                + "FOREIGN KEY(idFactura) REFERENCES factura(idFactura), "
                + "FOREIGN KEY(idProducto) REFERENCES producto(idProducto))";
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
}
