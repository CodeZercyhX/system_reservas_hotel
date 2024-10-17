package unipacifico.edu.hotel.presentacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import unipacifico.edu.hotel.logica.Cliente;
import unipacifico.edu.hotel.logica.Habitacion;
import unipacifico.edu.hotel.logica.InventarioHotel;
import unipacifico.edu.hotel.logica.Reserva;

public final class Menu {
    InventarioHotel inventario;
    ArrayList<Reserva> listaReservas;

    public Menu() {
        inventario = new InventarioHotel();
        listaReservas = new ArrayList<>();
        int opcion = 0;
        String opcionesMenu = "*** M E N U  H O T E L ***\n\n"
                + "1- Consultar Habitaciones\n"
                + "2- Realizar Reserva\n"
                + "3- Consultar Reserva por Cliente\n"
                + "4- Eliminar Reserva\n"
                + "5- Consultar Todas las Reservas\n"
                + "6- Salir\n"
                + "Ingrese opcion de preferencia:";

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(opcionesMenu));
            switch (opcion) {
                case 1: opcionConsultarHabitaciones();break;
                case 2: opcionRealizarReserva();break;
                case 3: opcionConsultarReservaPorCliente();break;
                case 4: opcionEliminarReserva();break;
                case 5: opcionConsultarTodasReservas();break;
            }
                if (opcion == 6) {
                     int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres salir?", 
                     "Confirmar salida", 
                     JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                     opcion = 7;
                    }
}

        } while (opcion != 7);
    }
    //listo
           public void opcionRealizarReserva() {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        String id = JOptionPane.showInputDialog("Identificación del cliente:");
        String email = JOptionPane.showInputDialog("Email del cliente:");
        String telefono = JOptionPane.showInputDialog("Teléfono del cliente:");
        Cliente cliente = new Cliente(nombre, id, email, telefono);

        String fecha = JOptionPane.showInputDialog("Fecha de la reserva:");
        Reserva reserva = new Reserva();
        reserva.agregarCliente(cliente);
        reserva.setFechaReserva(fecha);

        ArrayList<Habitacion> disponibles = inventario.getListaHabitaciones();
        String habDisponibles = "";
        int cont = 1;
        String est = "Habitacion";
        for (Habitacion hab : disponibles) {
            habDisponibles += cont + "- "+ est + hab + "\n";
            cont++;
        }
         if (disponibles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles.");
            return;
        }
        int seleccion = Integer.parseInt(JOptionPane.showInputDialog(
            "Seleccione una habitación:\n" + habDisponibles)) - 1;
        Habitacion habitacionSeleccionada = disponibles.get(seleccion);
        reserva.agregarHabitacion(habitacionSeleccionada);
        listaReservas.add(reserva);
        habitacionSeleccionada.setEstado("Ocupado");
        
        JOptionPane.showMessageDialog(null, "Reserva realizada con éxito.");
    }
           
    //Listo
    public void opcionConsultarHabitaciones() {
        ArrayList<Habitacion> listaHabs = inventario.getListaHabitaciones();
        String salida = "";
        String habi = "Habitacion";
        int contador = 1;
        for (Habitacion hab : listaHabs) {
            salida += String.valueOf(contador) + "- "+ habi + hab + "\n";
            contador++;
        }
        JOptionPane.showMessageDialog(null,salida );
    }

    //Listo
    public void opcionConsultarReservaPorCliente() {
        String idCliente = JOptionPane.showInputDialog("Introduzca su identificación:");
        Reserva reservaEncontrada = null;
        for (Reserva reserva : listaReservas) {
            if (reserva.consultarCliente().getIdentificacion().equals(idCliente)) {
                reservaEncontrada = reserva;
                break;
            }
        }
        //Listo
        if (reservaEncontrada != null) {
            String infoReserva = "Cliente: " 
                                 + reservaEncontrada.consultarCliente().getNombreCompleto()
                                 + "\nFecha de Reserva: " 
                                 + reservaEncontrada.getFechaReserva() 
                                 + "\nHabitaciones Reservadas: " 
                                 + reservaEncontrada.consultarHabitaciones()
                                 + "\nNúmero de telefono"
                                 + reservaEncontrada.consultarCliente().getTelContacto()
                                 + "\nCorreo electrónico: "
                                 + reservaEncontrada.consultarCliente().getEmail()
                                 + "\nIdentificación del cliente: "
                                 + reservaEncontrada.consultarCliente().getIdentificacion();
                                 
            JOptionPane.showMessageDialog(null, infoReserva);
        } else {
            JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
        }
    }
    //Realizar unas cuantas mejoras
    public void opcionEliminarReserva() {
        String idCliente = JOptionPane.showInputDialog("Ingrese identificación:");
        Reserva reservaAEliminar = null;
        for (Reserva reserva : listaReservas) {
            if (reserva.consultarCliente().getIdentificacion().equals(idCliente)) {
                reservaAEliminar = reserva;
                break;
            }
        }

        if (reservaAEliminar != null) {
            listaReservas.remove(reservaAEliminar);
            for (Habitacion hab : reservaAEliminar.consultarHabitaciones()) {
                hab.setEstado("Disponible");
            }
            JOptionPane.showMessageDialog(null, "Reserva eliminada.");
        } else {
            JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
        }
    }

    public void opcionConsultarTodasReservas() {
        if(listaReservas.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se han realizado reservas");
         
        }
        if(listaReservas.isEmpty() == false){
            String salida = "Todas las Reservas:\n";
        salida = listaReservas.stream()
                .filter(reserva -> !reserva.consultarHabitaciones().isEmpty())
                .map((reserva) -> "Cliente: " 
                        + reserva.consultarCliente().getNombreCompleto() 
                        + "\nFecha: " + reserva.getFechaReserva()
                        + "\nIdentificación del cliente: " + reserva.consultarCliente().getIdentificacion()
                        + "\nHabitaciones: " + reserva.consultarHabitaciones() + "\n\n").reduce(salida, String::concat);
                        JOptionPane.showMessageDialog(null, salida);
        }

}
}