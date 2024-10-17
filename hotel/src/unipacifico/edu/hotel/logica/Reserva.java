/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unipacifico.edu.hotel.logica;

import java.util.ArrayList;

/**
 *
 * @author ALUMNOS #
 */
public class Reserva {
    
    ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
    Cliente cliente;
    
    private String fechaReserva;

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    
    public boolean agregarHabitacion(Habitacion cuarto){
        return listaHabitaciones.add(cuarto);
    }
    
    public boolean eliminarHabitacion(Habitacion cuarto){
        return listaHabitaciones.remove(cuarto);
    }
    
    public ArrayList<Habitacion> consultarHabitaciones(){
        return listaHabitaciones;
    }
    public void agregarCliente(Cliente usuario){
      this.cliente = usuario;
    }
    
    public Cliente consultarCliente(){
     return this.cliente;
    }
    
    
}
