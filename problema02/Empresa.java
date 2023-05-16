import java.util.ArrayList;
import java.util.Scanner;
class Empleado {
    private String nombre;
    private double salario;
    private int edad;
    public Empleado() {}
    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void aumentarSalario(double porcentajeAumento) {
        double montoAumento = this.salario * porcentajeAumento / 100;
        this.salario += montoAumento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", edad=" + edad +
                '}';
    }
}
public class Empresa {
    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n    MENU DE OPCIONES:");
            System.out.println("1. AGREGAR EMPLEADO");
            System.out.println("2. MOSTRAR INFORMACION DE EMPLEADOS");
            System.out.println("3. CALCULAR EL AUMENTO PORCENTUAL EN EL SALARIO");
            System.out.println("4. SALIR");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el salario del empleado: ");
                    double salario = scanner.nextDouble();

                    System.out.print("Ingrese la edad del empleado: ");
                    int edad = scanner.nextInt();

                    Empleado empleadoNuevo = new Empleado(nombre, salario, edad);
                    listaEmpleados.add(empleadoNuevo);
                    break;
                case 2:
                    System.out.println("\nINFORMACIÓN DE LOS EMPLEADOS:");
                    for (int i = 0; i < listaEmpleados.size(); i++) {
                        Empleado empleadoActual = listaEmpleados.get(i);
                        System.out.println(empleadoActual.toString());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el porcentaje de aumento salarial: ");
                    double porcentajeAumento = scanner.nextDouble();
                    double sumaSalarios = 0;
                    for (int i = 0; i < listaEmpleados.size(); i++) {
                        Empleado empleadoActual = listaEmpleados.get(i);
                        sumaSalarios += empleadoActual.getSalario();
                    }
                    double salarioPromedio = sumaSalarios / listaEmpleados.size();
                    System.out.println("\nNUEVOS SALARIOS:");
                    for (int i = 0; i < listaEmpleados.size(); i++) {
                        Empleado empleadoActual = listaEmpleados.get(i);
                        if (empleadoActual.getSalario() < salarioPromedio) {
                            empleadoActual.aumentarSalario(porcentajeAumento);
                            System.out.println(empleadoActual.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Fin");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}