package service;

import api.apiConversor;
import api.recordConversor;
import model.datosRecord;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Conversor {
    private apiConversor api = new apiConversor();
    private String divisaEntrada, divisaSalida;
    private double cantidad;
    private double resultado;
    private String horaConsulta;


    public void ConvertirDivisa(String divisaEntrada, String divisaSalida, double cantidad){
        recordConversor record = api.conversionDivisa(divisaEntrada,divisaSalida);
        datosRecord datos = new datosRecord(record);
        this.divisaEntrada=datos.getCodigoEntrante();
        this.divisaSalida=datos.getCodigoSaliente();
        this.cantidad=cantidad;
        this.resultado = datos.getValorConvertido() * cantidad;
        ObtenerHora();
    }

    public void ObtenerHora(){
        // Obtener la hora actual
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        this.horaConsulta  = horaActual.format(formato);
    }
    @Override
    public String toString(){
        return cantidad+ " ["+ divisaEntrada+ "] en [" + divisaSalida + "] ==> " + resultado + " [" + divisaSalida + "]";
    }

    public String getDivisaEntrada() {
        return divisaEntrada;
    }


    public String getDivisaSalida() {
        return divisaSalida;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getResultado() {
        return resultado;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }
}
