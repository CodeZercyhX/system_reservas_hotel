/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unipacifico.edu.hotel.logica;

/**
 *
 * @author ALUMNOS #
 */
public class Habitacion {
    
    private String tipoHabitacion;
    private int numeroPersonas;
    private String  ubicacion;
    private int precio;
    private String estado;
    
    public Habitacion(String tipo, int cantidadPersonas,String ubicacion,
            int precio, String estado){
      this.tipoHabitacion = tipo;
      this.numeroPersonas = cantidadPersonas;
      this.ubicacion = ubicacion;
      this.precio = precio;
      this.estado = estado;        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "(" +this.tipoHabitacion +", " +this.ubicacion+
                ", " +this.numeroPersonas + ", " +this.precio +
                "," +this.estado +")";
    }
    
    
}
