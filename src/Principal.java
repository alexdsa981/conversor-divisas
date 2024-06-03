import service.Conversor;
import service.Historial;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner abc = new Scanner(System.in);
        Historial historial = new Historial();
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
                7) Otros
                8) Historial
                9) Salir
                Elija una opción valida:
                *********************************************
                """;

        while (flag != 9) {
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
                        divisaSalida = "BRL";
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
                        System.out.println("Ingrese el codigo de divisa que desea convertir: (ej: ARS)");
                        abc.nextLine(); //limpiar la entrada de texto
                        divisaEntrada = abc.nextLine().toUpperCase();
                        System.out.println("¿A qué divisa desea convertir los "+divisaEntrada+"? (ej: USD)");
                        divisaSalida = abc.nextLine().toUpperCase();
                        break;
                    case 8:
                        historial.mostrarHistorial();
                        break;
                    case 9:
                        flag = 9;
                        break;
                    default:
                        System.out.println("ERROR: Elija una opción valida!!");
                        break;
                }
                if (flag >= 1 && flag <= 7) {
                    Conversor conversor = new Conversor();
                    System.out.println("Ingrese la cantidad de [" + divisaEntrada + "] que desea convertir a [" + divisaSalida + "]: ");
                    cantidad = abc.nextDouble();
                    conversor.ConvertirDivisa(divisaEntrada, divisaSalida, cantidad);
                    System.out.println("*********************************************");
                    System.out.println(conversor.toString());
                    System.out.println("*********************************************");
                    historial.agregarAlHistorial(conversor);

                }
            } catch (Exception e) {
                System.out.println("ERROR: Ingreso de datos invalido!! ");
                abc.nextLine(); // Limpiar el flujo de entrada
            }
        }

        System.out.println("FIN: Gracias por su preferencia!!");
    }
}
