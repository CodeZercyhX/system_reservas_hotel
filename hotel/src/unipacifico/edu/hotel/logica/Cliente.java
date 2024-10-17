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
public class Cliente {
  private String nombreCompleto;
  private String identificacion;
  private String email;
  private String telContacto;
  
  
  public Cliente(String nombre, String identificacion, String email,
          String telefono){
      this.nombreCompleto= nombre;
      this.identificacion = identificacion;
      this.email = email;
      this.telContacto = telefono;
  }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelContacto() {
        return telContacto;
    }

    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }
  
  
}
