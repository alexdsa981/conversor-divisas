public class datosRecord {
    private String codigoEntrante;
    private String codigoSaliente;
    private Double valorConvertido;

    public datosRecord(recordConversor record) {
        this.codigoEntrante = record.base_code();
        this.codigoSaliente = record.target_code();
        this.valorConvertido = record.conversion_rate();
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }

    public String getCodigoEntrante() {
        return codigoEntrante;
    }

    public String getCodigoSaliente() {
        return codigoSaliente;
    }

}
