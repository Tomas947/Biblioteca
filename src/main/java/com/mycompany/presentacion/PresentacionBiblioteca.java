package com.mycompany.presentacion;

import com.mycompany.servicios.Interface_Servicios;
import com.mycompany.servicios.LibroImplementacion;
import com.mycompany.domain.Estudiante;

import java.util.Scanner;

public class PresentacionBiblioteca {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int opcion = -1, cont = 0;
        int tiempo = 0;
        String titulo, autor, categoria, nombre = "", usuarioActual = "Juan", legajo = "181245", correoElectronico = "juan@gmail.com";
        boolean bandera = true;

        Interface_Servicios biblioteca = new LibroImplementacion();
        biblioteca.añadirEstudiante(usuarioActual, legajo, correoElectronico);

        do {
            if ((biblioteca.existeUsuario(usuarioActual, legajo, correoElectronico)) == true) {
                if (cont == 0) {
                    System.out.println("Se inicio sesion correctamente\n");
                    cont = 1;
                }
            } else {
                break;
            }

            System.out.println("Elije una opcion: \n"
                    + "1. Añadir libro.\n"
                    + "2. Sacar prestado un libro.\n"
                    + "3. Listar libros en biblioteca\n"
                    + "4. Listar libros en biblioteca que han sido prestados.\n"
                    + "5. Buscar libros.\n"
                    + "6. Añadir un nuevo estudiante.\n"
                    + "7. Listar lista de estudiantes registrados.\n"
                    + "8. Iniciar sesion con otra cuenta.\n"
                    + "0. Salir.");

            System.out.println("Elija una opcion: ");
            opcion = Integer.parseInt(in.nextLine());// lo hicimos asi si por que se bugea si lo hago de la
            int opcion2 = (int) opcion;                // manera clasica osea solo con "opcion = in.nextInt();"

            switch (opcion2) {

                case 1:
                    do {
                        System.out.print("\nIngrese el titulo del libro: ");
                        titulo = in.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        autor = in.nextLine();
                        System.out.print("Ingrese la categoria del libro: ");
                        categoria = in.nextLine();

                    } while (titulo.equals(" ") || autor.equals(" ") || categoria.equals(" "));

                    biblioteca.añadirLibro(titulo, autor, categoria);
                    break;

                case 2:
                    biblioteca.sacarPrestamo();
                    break;

                case 3:
                    biblioteca.listarLibros();
                    break;
                case 4:
                    biblioteca.listarLibrosPrestadosA_Usuarios();
                    break;
                case 5:
                    System.out.print("\nIngrese el titulo a buscar: ");
                    titulo = in.nextLine();
                    biblioteca.buscarLibro(titulo);
                    break;
                case 6:

                    System.out.print("\nIngrese su nombre: ");
                    String nom = in.nextLine();
                    System.out.print("Ingrese su legajo.");
                    String legaj = in.nextLine();
                    System.out.println("Ingrese su correo electronico.");
                    String correo = in.nextLine();

                    biblioteca.añadirEstudiante(nom, legaj, correo);
                    break;
                case 7:
                    biblioteca.listarEstudiantes();
                    break;
                case 8:
                    biblioteca.iniciarSesion();
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
