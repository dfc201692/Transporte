package envios.transporte.Modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EnvioTerrestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "tipo_producto_id")
    private TipoProducto tipoProducto;
    private int cantidadProducto;
    private Date fechaRegistro;
    private Date fechaEntrega;
    private String bodegaEntrega;
    private double precioEnvio;
    private String placaVehiculo;
    private String numeroGuia;

    private double descuento; // Nuevo campo para almacenar el descuento aplicado

    public EnvioTerrestre(Long id, Cliente cliente, TipoProducto tipoProducto, int cantidadProducto, Date fechaRegistro, Date fechaEntrega, String bodegaEntrega, double precioEnvio, String placaVehiculo, String numeroGuia) {
        this.id = id;
        this.cliente = cliente;
        this.tipoProducto = tipoProducto;
        this.cantidadProducto = cantidadProducto;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrega = fechaEntrega;
        this.bodegaEntrega = bodegaEntrega;
        this.precioEnvio = precioEnvio;
        this.placaVehiculo = placaVehiculo;
        this.numeroGuia = numeroGuia;
    }

    public EnvioTerrestre() {
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getBodegaEntrega() {
        return bodegaEntrega;
    }

    public void setBodegaEntrega(String bodegaEntrega) {
        this.bodegaEntrega = bodegaEntrega;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }


    // Método para calcular el descuento
    public void calcularDescuento() {
        if (cantidadProducto > 10) {
            double descuentoPorcentaje = 0.05; // Descuento del 5%
            descuento = precioEnvio * descuentoPorcentaje;
            precioEnvio -= descuento;
        }
    }


}
