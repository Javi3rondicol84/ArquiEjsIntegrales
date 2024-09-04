package integrador1.dtos;

public class ClienteDTO {
    private String nombre;
    private int facturacion;

    public ClienteDTO(int facturacion, String nombre) {
        this.nombre = nombre;
        this.facturacion = facturacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(int facturacion) {
        this.facturacion = facturacion;
    }

    @Override
    public String toString() {
        return "Cliente" +
                ", facturacion=" + facturacion +
                " nombre='" + nombre + '\'' +
                '\n';
    }
}
