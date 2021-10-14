package icai.dtc.isw.domain;

import java.io.Serializable;

public class Movil implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String marca;
    private String modelo;
    private String precio;
    private String almacenamiento;
    private String memoria;





    public Movil(String marca, String precio, String modelo, String almacenamiento, String memoria) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPrecio(precio);
        this.setAlmacenamiento(almacenamiento);
        this.setMemoria(memoria);
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    public String getAlmacenamiento()
    {
        return almacenamiento;
    }

    public String getMemoria()
    {
        return memoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAlmacenamiento(String almacenamiento)
    {
        this.almacenamiento = almacenamiento;
    }

    public void setMemoria(String memoria)
    {
        this.memoria = memoria;
    }

    public String getDatos()
    {
        return "Marca: "+this.marca+" , Precio: "+ this.precio+ ", Modelo: "+ this.modelo + "Almacenamiento: "+ this.almacenamiento+ ",  Memoria: "+ this.memoria;
    }

}