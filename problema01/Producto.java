import java.util.Scanner;

public class Producto {
    private double precio;
    private int cantidad;

    public Producto(double precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularPrecioFinal() {
        double descuento;

        if (precio >= 1000 && cantidad >= 10) {
            descuento = 0.1;
        } else {
            descuento = 0.05;
        }

        return precio * cantidad * (1 - descuento);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}

