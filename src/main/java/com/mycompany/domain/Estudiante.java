
package com.mycompany.domain;

public class Estudiante {
    
    private String nombre;
    private String legajo;
    private String correoElectronico;

    public Estudiante(String nombre, String legajo, String correoElectronico) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    @Override
    public String toString() {
        return "Estudiante: " + "nombre = " + nombre + ", legajo = " + legajo + ", correoElectronico = " + correoElectronico + "\n";
    }
    
}