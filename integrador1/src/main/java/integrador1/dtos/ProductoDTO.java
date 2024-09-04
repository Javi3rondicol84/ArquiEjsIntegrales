package integrador1.dtos;

public class ProductoDTO {
    private String nombre;
    private Float valor;

    public ProductoDTO(String nombre, Float valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}
