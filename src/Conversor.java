public class Conversor {
    private apiConversor api = new apiConversor();
    private String divisaEntrada, divisaSalida;
    private double cantidad;
 

    public Double ConvertirDivisa(String divisaEntrada, String divisaSalida, double cantidad){
        recordConversor record = api.conversionDivisa(divisaEntrada,divisaSalida);
        datosRecord datos = new datosRecord(record);
        this.divisaEntrada=datos.getCodigoEntrante();
        this.divisaSalida=datos.getCodigoSaliente();
        this.cantidad=cantidad;
        return datos.getValorConvertido() * cantidad;
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
}
