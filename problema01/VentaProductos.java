import java.util.Scanner;

public class VentaProductos {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precio = input.nextDouble();

        System.out.print("Ingrese la cantidad de productos a comprar: ");
        int cantidad = input.nextInt();

        Producto producto = new Producto(precio, cantidad);
        double precioFinal = producto.calcularPrecioFinal();

        System.out.println("El precio final de la compra es: " + precioFinal);

    }
}
