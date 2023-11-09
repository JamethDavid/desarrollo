package com.example.desrrollo.util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CargarPropiedades {
    private static Map<String, Properties> propiedades = new HashMap<String,Properties>();
    private static String pathPropiedades = System.getenv("CATALINA_HOME") + "\\conf\\Propiedades\\";

    public static Properties cargarPropiedades(String nombre, boolean enCache) {
        try {
            if (enCache) {
                Properties archivoPropiedades = new Properties();
                archivoPropiedades.load(new FileInputStream(pathPropiedades + nombre));
                //System.out.println("1. Propiedades: "+archivoPropiedades);
                return archivoPropiedades;
            } else if (propiedades.containsKey(nombre))
                return propiedades.get(nombre);
            else {
                Properties archivoPropiedades = new Properties();
                archivoPropiedades.load(new FileInputStream(pathPropiedades + nombre));
                //System.out.println("2. Propiedades: "+archivoPropiedades);
                propiedades.put(nombre, archivoPropiedades);
                return archivoPropiedades;
            }
        } catch (Exception e) {
            System.err.println("Error en la carga del archivo " + nombre +" : "+ e);
            return null;
        }
    }
}
