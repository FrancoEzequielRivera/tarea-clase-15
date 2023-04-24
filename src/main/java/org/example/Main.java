package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Convertidor conver = new Convertidor();
        conver.convertirArchivo("C:\\Users\\Franco\\Desktop\\Desarrollador Java\\Clase 15\\tarea-clase-15\\src\\main\\java\\org\\example\\archivo.csv", "XML");
    }
}