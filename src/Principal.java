import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner abc = new Scanner(System.in);
        Conversor conversor = new Conversor();
        int flag = 1;
        double cantidad;
        double resultado = 0;
        String divisaEntrada = "";
        String divisaSalida = "";
        String menu = """
                *********************************************
                Sea bienvenido al conversor de moneda!! :)
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real brasileño
                4) Real brasileño ==> Dólar
                5) Dólar ==> Peso colombiano 
                6) Peso colombiano ==> Dólar
                7) Salir
                Elija una opción valida:
                *********************************************
                """;

        while (flag != 7) {
            try {
                System.out.println(menu);
                flag = abc.nextInt();
                switch (flag) {
                    case 1:
                        divisaEntrada = "USD";
                        divisaSalida = "ARS";
                        break;
                    case 2:
                        divisaEntrada = "ARS";
                        divisaSalida = "USD";
                        break;
                    case 3:
                        divisaEntrada = "USD";
                        divisaSalida = " BRL";
                        break;
                    case 4:
                        divisaEntrada = "BRL";
                        divisaSalida = "USD";
                        break;
                    case 5:
                        divisaEntrada = "USD";
                        divisaSalida = "COP";
                        break;
                    case 6:
                        divisaEntrada = "COP";
                        divisaSalida = "USD";
                        break;
                    case 7:
                        flag = 7;
                        break;
                    default:
                        System.out.println("ERROR: Elija una opción valida!!");
                        break;
                }
                if (flag >= 1 && flag <= 6) {
                    System.out.println("Ingrese la cantidad de [" + divisaEntrada + "] que desea convertir a [" + divisaSalida + "]: ");
                    cantidad = abc.nextDouble();
                    resultado = conversor.ConvertirDivisa(divisaEntrada, divisaSalida, cantidad);
                    System.out.println("*********************************************");
                    System.out.println(conversor.getCantidad() + " [" + conversor.getDivisaEntrada() + "] en [" + conversor.getDivisaSalida() + "] ==> " + resultado + " [" + conversor.getDivisaSalida() + "]");
                    System.out.println("*********************************************");
                }
            } catch (Exception e) {
                System.out.println("ERROR: Ingrese un número!! ");
                abc.nextLine(); // Limpiar el flujo de entrada
            }
        }

        System.out.println("FIN: Gracias por su preferencia!!");
    }
}
