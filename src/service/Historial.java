package service;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    public static List<Conversor> historial = new ArrayList<>();


    public void agregarAlHistorial(Conversor conversor) {
        historial.add(conversor);
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Aún no se realizaron conversiones");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i) +" "+historial.get(i).getHoraConsulta()

//                    (i + 1) + ". " + historial.get(i).getCantidad() + " [" +
//                    historial.get(i).getDivisaEntrada() + "] a [" + historial.get(i).getDivisaSalida() + "] ==>" +
//                    historial.get(i).getResultado() + " [" + historial.get(i).getDivisaSalida() + "]"

                );
            }
        }
    }

    public static List<Conversor> getHistorial() {
        return historial;
    }
}
