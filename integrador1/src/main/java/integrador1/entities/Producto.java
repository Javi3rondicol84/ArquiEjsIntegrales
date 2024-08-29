package integrador1.entities;

public class Producto {
	private int idProducto;
	private String nombre;
	private Float valor;
	
	public Producto(int idProducto, String nombre, Float valor) {
		super();
		this.idProducto = idProducto;
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

	public int getIdProducto() {
		return idProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", valor=" + valor + "]";
	}
	
	
}
