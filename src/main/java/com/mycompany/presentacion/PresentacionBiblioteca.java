
package com.mycompany.presentacion;

import com.mycompany.servicios.Interface_Servicios;
import com.mycompany.servicios.LibroImplementacion;
import java.util.Scanner;

public class PresentacionBiblioteca {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        int tiempo = 0;
        String titulo, autor, categoria;
        boolean bandera = true;
        
        
        Interface_Servicios biblioteca = new LibroImplementacion();
        
        do {
            
            System.out.println("Elije una opcion: \n"
                    + "1. Añadir libro.\n"
                    + "2. Sacar prestado un libro.\n"
                    + "3. Listar libros en biblioteca\n"
                    + "4. Listar libros en biblioteca que han sido prestados.\n"
                    + "5. Buscar libros.\n"
                    + "0. Salir.");
            
            System.out.println("Elija una opcion: ");
            opcion = Integer.parseInt(in.nextLine());
            int opcion2 = (int) opcion;

            switch (opcion2) {
                
                case 1:
                    do {                        
                        System.out.println("Ingrese el titulo del libro: ");
                        titulo = in.nextLine();
                        System.out.println("Ingrese el autor del libro: ");
                        autor = in.nextLine();
                        System.out.println("Ingrese la categoria del libro: ");
                        categoria = in.nextLine();
                        
                    } while (titulo.equals(" ") || autor.equals(" ") || categoria.equals(" ")); 
                    
                    biblioteca.añadirLibro(titulo, autor, categoria);                                    
                    break;
                    
                case 2:               
                    biblioteca.sacarPrestamo(" ", tiempo);
                    break;
                    
                case 3:    
                    biblioteca.listarLibros();
                    break;
                case 4:                  
                    biblioteca.listarLibrosPrestadosA_Usuarios();
                    break;
                case 5:    
                    System.out.println("Ingrese el titulo a buscar: ");
                    titulo = in.nextLine();
                    biblioteca.buscarLibro(titulo);
                    break;
                case 0:
                    System.out.println("Gracias por usuar nuestros servicios.");
                    bandera = false;
                    break;
                    
                default:
                    System.out.println("La opcion ingresada no existe.");
                 
            }
            
        } while (bandera == true);
        
        
    }
    
}
