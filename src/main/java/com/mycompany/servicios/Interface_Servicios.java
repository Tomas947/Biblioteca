package com.mycompany.servicios;

import com.mycompany.domain.Estudiante;
import com.mycompany.domain.Libro;
import java.util.ArrayList;
import java.util.List;

public interface Interface_Servicios {
    
    List<Libro> libros = new ArrayList<>();
    List<Estudiante> ListaDeEstudiantes = new ArrayList<>();
    
    void añadirLibro(String titulo, String autor, String categoria);
    
    void añadirEstudiante(String nombre, String legajo, String correoElectronico);
      
    void sacarPrestamo(String titulo, int duracion);
    
    List<Libro> listarLibrosPrestadosA_Usuarios();
    
    List<Libro> listarLibros();
    
    void buscarLibro(String titulo);
    
    boolean existe(Libro libro,String titulo);
    
    void prestar(String titulo,int tiempo,boolean prestamo);
    
}
