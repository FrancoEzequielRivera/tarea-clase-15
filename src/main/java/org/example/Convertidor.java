package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Convertidor {

    public void convertirArchivo(String rutaDeArchivo, String tipoDeSalida) throws IOException {
        Path archivo = Path.of(rutaDeArchivo);
        List<String> lista = Files.readAllLines(Paths.get(rutaDeArchivo));

        boolean bandera = true;
        List<Oferta> listaDeOfertas = new ArrayList<>();
        String nombre;
        double peso;
        double precio;
        String tipoDescuento;
        double cantidad;
        double descuento;
        String fechaDesde;
        String fechaHasta;
        double tope;


        for (String fila : lista){
            if (bandera){
                bandera = false;
            }else{
                System.out.println("Analizando ofertas...");
                List<String> dentro = List.of(fila.split(";"));
                String[] posiciones = fila.split(";");
                nombre = posiciones[0];
                peso = Double.parseDouble((posiciones[1]));
                precio = Double.parseDouble((posiciones[2]));
                tipoDescuento = (posiciones[3]);
                cantidad = Double.parseDouble((posiciones[4]));
                descuento = Double.parseDouble((posiciones[5]));
                fechaDesde = posiciones[6];
                fechaHasta = posiciones[7];
                tope = Double.parseDouble(posiciones[8]);

                Producto unProd = new Producto(nombre, peso, precio, cantidad);
                if (Objects.equals(tipoDescuento, "%")){
                    Descuento descuentoTopePorcentaje = new DescuentoTopePorcentaje(cantidad, tope);

                    Oferta oferta = new Oferta(unProd, descuentoTopePorcentaje, fechaDesde, fechaHasta);
                    listaDeOfertas.add(oferta);
                }else if (Objects.equals(tipoDescuento, "fijo")){
                    Descuento descuentoFijo = new DescuentoFijo(tope);

                    Oferta oferta = new Oferta(unProd, descuentoFijo, fechaDesde, fechaHasta);
                    listaDeOfertas.add(oferta);
                }
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        String serializacion;

        ObjectMapper xmlMapper = new XmlMapper();
        ((XmlMapper) xmlMapper).configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        if (Objects.equals(tipoDeSalida, "JSON")){
            System.out.println();
            System.out.println();
            System.out.println("Resultado de ofertas serializadas a JSON: ");
            System.out.println();
            for (Oferta oferta : listaDeOfertas){
                serializacion = mapper.writeValueAsString(oferta);
                System.out.println(serializacion);
            }
        }else if (Objects.equals(tipoDeSalida, "XML")){
            System.out.println();
            System.out.println();
            System.out.println("Resultado de ofertas serializadas a XML: ");
            System.out.println();

            for (Oferta oferta : listaDeOfertas){
                String xmlString = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(oferta);
                System.out.println(xmlString);
            }
        }
    }
}
