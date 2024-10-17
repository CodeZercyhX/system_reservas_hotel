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
public class InventarioHotel {
    ArrayList<Habitacion> listaHabitaciones;

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }
    
    public InventarioHotel(){
     listaHabitaciones = new ArrayList<Habitacion>();
        
     listaHabitaciones.add(new Habitacion("sencilla", 1,"101", 120000
             , "disponible"));
     listaHabitaciones.add(new Habitacion("sencilla", 1,"102", 120000
             , "disponible"));
     listaHabitaciones.add(new Habitacion("sencilla", 1,"201", 120000
             , "disponible"));
     listaHabitaciones.add(new Habitacion("doble", 1,"103", 210000
             , "disponible"));
     listaHabitaciones.add(new Habitacion("doble", 2,"202", 210000
             , "disponible"));
     listaHabitaciones.add(new Habitacion("doble", 2,"203", 210000
             , "disponible"));
     listaHabitaciones.add(new Habitacion("king", 2,"301", 380000
             , "disponible"));
     listaHabitaciones.add(new Habitacion("king", 2,"302", 380000
             , "disponible"));
     
    }
}
