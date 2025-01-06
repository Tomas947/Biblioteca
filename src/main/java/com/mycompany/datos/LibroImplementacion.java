package com.mycompany.datos;

import com.mycompany.domain.Libro;
import com.mycompany.domain.Estudiante;
import java.util.*;

public class LibroImplementacion implements Interface_Servicios {

    Scanner in = new Scanner(System.in);

    @Override
    public void añadirLibro(String titulo, String autor, String categoria) {

        Libro libro = new Libro(titulo, autor, categoria);//Inicializamos los atributos del libro
        libros.add(libro);
        System.out.println("Libro añadido con exito.\n");
    }

    @Override
    public void añadirEstudiante(String nombre, String legajo, String correoElectronico) {

        Estudiante estudiante = new Estudiante(nombre, legajo, correoElectronico);//Inicializamos los atributos del usuario(Estudiante)
        ListaDeEstudiantes.add(estudiante);//añadimos un nuevo estudiante(usuario)
        System.out.println("El estudiante de añadio correctamente.\n");

    }

    public void sacarPrestamo() {
        int tiempo = 0;
        String titulo, autor, categoria;
        int v1 = 0;

        System.out.print("Ingrese el titulo del libro:");
        titulo = in.nextLine();

        do {

            System.out.println("Tiempo maximo 15 dias.");
            System.out.println("Ingrese cuanto tiempo desea retirarlo(en dias): ");
            tiempo = in.nextInt();

            if (tiempo > 15) {
                System.out.println("Pretamo cancelado, tiempo de prestamo exesivo, intentelo de nuevo.");
            } else {
                v1 = 1;
            }
        } while (v1 == 0);// ponemos esto asi ppor que si el usuario ingresa mas de 15 dias se le negara el prestamos y se seguira el bucle

        try {

            for (Libro objeto : libros) {//
                Libro aux = objeto;   //creamos un objeto aux para poder acceder a los datos del objeto que les estamos asignando                             
                if (aux.getTitulo().equalsIgnoreCase(titulo) && aux.isDisponible() == true) {
                    //la codicioen para prestar un libro es que el libro exista y ademas q este disponible
                    //con esto hacemos para que otro usuario no pueda pedir el mismo libro
                    prestar(titulo, tiempo, false);
                    //a su vez decimos que todo livro prestado tiene el atributo disponible == false
                    //esto nos va a facilitar a la hora listar los libros prestados.
                    System.out.println("El libro se le presto con exito.\n");
                    break;
                } else if (aux.isDisponible() == false) {
                    System.out.println("\nEl libro ingresado no se encuentra disponible.");
                } else {
                    System.out.println("El libro solicitado ya se registro prestado, disfrute su leectura.");
                }
            }

        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("ERROR. al solicitar prestamo.");

        }
    }

    @Override
    public List<Libro> listarLibros() {

        for (Libro elemts : libros) {
            System.out.print(elemts);//cout

        }
        System.out.println(" ");
        return null;
    }

    @Override
    public List<Libro> listarLibrosPrestadosA_Usuarios() {

        List<Libro> listaAuxiliar = new ArrayList<>();
        int cantidad = 0;

        for (Libro libro1 : libros) {
            if (libro1.isDisponible() == false) {
                listaAuxiliar.add(libro1);
                cantidad++;
            }
        }
        if (cantidad != 0) {
            System.out.println("Los libros que se prestaron hasta hora fueron: ");
            for (Libro libro1 : listaAuxiliar) {

                System.out.print("Libro: " + "titulo = " + libro1.getTitulo() + ", autor = " + libro1.getAutor() + ", categoria = " + libro1.getCategoria()
                        + ", disponible = " + libro1.isDisponible() + ", tiempo prestado: " + libro1.getTiempo() + "dias.\n");

            }

        } else {
            System.out.println("No hay libros.");
        }

        return null;
    }

    @Override
    public void buscarLibro(String titulo) {

        boolean encontrado = false;

        for (Libro libro1 : libros) {
            if (libro1.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                System.out.println(" Libro encontrado: \n");
                System.out.println(" Titulo: " + libro1.getTitulo());
                System.out.println(" Autor: " + libro1.getAutor());
                System.out.println(" Categoria: " + libro1.getCategoria());

                if (libro1.isDisponible() == true) {
                    System.out.println(" Disponivilidad:  Esta Disponible. \n");
                } else {
                    System.out.println(" Disponivilidad:  No esta Disponible. \n");
                }

            }
        }

        if (encontrado != true) {
            System.out.println("El libro no se encontro.\n");
        }

    }

    @Override
    public boolean existe(Libro libro, String titulo) {

        //el "equalsIgnoreCase" sirve para comparar pero ignoranddo las mayusculas o minusculas
        if (libro.getTitulo().equalsIgnoreCase(titulo)) {//verificamos de que esxista el libro mediante su nombre
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void prestar(String titulo, int tiempo, boolean prestamo) {//esta cosa no sirve borrala 

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {

                libro.setDisponible(prestamo);
                libro.setTiempo(tiempo);
                break;
            }
        }

    }

    @Override
    public void iniciarSesion() {
        String usuarioActual, legajo, correoelectronico;
        boolean existe = false;

        while (existe == false){
            System.out.println("Ingrese el nombre:");
            usuarioActual = in.nextLine();
            System.out.println("Ingrese el legajo:");
            legajo = in.nextLine();
            System.out.println("Ingrese el correo electronico: ");
            correoelectronico = in.nextLine();

            existe = existeUsuario(usuarioActual, legajo, correoelectronico);// de esta manera verificamos que
            // existe el usuario

            if (existe == true) {
                System.out.println("\nLa sesion se inicio correctamentamente.");

            } else {
                System.out.println("\nNo se pudo iniciar sesion correctamente intente de nuevo");
            }
        }
    }

    @Override
    public boolean existeUsuario(String nombre, String legajo, String correoElectronico) {
        boolean existe = false;
        for (Estudiante user : ListaDeEstudiantes) {//el if verifica que el name, legajo y mail sean correctos
            if (user.getNombre().equalsIgnoreCase(nombre) && user.getLegajo().equalsIgnoreCase(legajo) && user.getCorreoElectronico().equalsIgnoreCase(correoElectronico)) {
                existe = true;
                return existe;
            }
        }
        existe = false;
        return existe;
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        for (Estudiante user : ListaDeEstudiantes) {
            System.out.println(user + "");
        }
        return null;
    }
}
