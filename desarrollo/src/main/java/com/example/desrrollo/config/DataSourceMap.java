package com.example.desrrollo.config;

import com.example.desrrollo.util.CargarPropiedades;
import com.example.desrrollo.util.ConstantesBD;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
@Component
@Scope(value = "singleton")
public class DataSourceMap {
        private Map<Object, Object> dataSourceMap;
        private Properties properties = null;
        public DataSourceMap() {
            System.out.println("INICIO Constuctor DataSourceMap() ---------------");

            properties = CargarPropiedades.cargarPropiedades(ConstantesBD.PROPERTIES_FILE, true);
            if (properties == null) {
                System.out.println("Problema al cargar las propiedades: " + ConstantesBD.PROPERTIES_FILE);
            }
            this.dataSourceMap = new HashMap<Object,Object>();
            addDataSource(ConstantesBD.session, dataSource());

            System.out.println("FIN Constuctor DataSourceMap() ---------------");
        }
        public void addDataSource(String token, DataSource dataSource) {
            System.out.println("Entro a addDataSource: (" + token + ", " + dataSource+")");
            this.dataSourceMap.put(token, dataSource);
            System.out.println("DataSourceMap: " + this.dataSourceMap);
        }
        public Map<Object, Object> getDataSourceMap(){
            return dataSourceMap;
        }

        public boolean removeDataSource(String token) {
            System.out.println("--- INICIO cierre de conexion de BD. ---");
            System.out.println("dataSourceMap INICIAL = " + dataSourceMap);
            System.out.println("Session a eliminar: " + token);
            Boolean conexion = false;
            try {
                HikariDataSource hikariDataSource = (HikariDataSource) dataSourceMap.get(token);
                hikariDataSource.close();
                conexion = hikariDataSource.isClosed();
                System.out.println("Conexion cerrada? = " + conexion);

                dataSourceMap.remove(token);
                System.out.println("dataSourceMap FINAL = " + dataSourceMap);
                System.out.println("--- FIN cierre de conexion de BD. ---");

            } catch (Exception e) {
                System.err.println("No se pudo cerrar la conexion a base de datos con la sesión: " + token);
                System.err.println("Error técnico. " + e);
                e.printStackTrace();
            }
            return conexion;
        }
        public DataSource dataSource() {
            System.out.println("Entro a crear dataSource()");

            String USER = properties.getProperty(ConstantesBD.USER);
            String PASSWORD = properties.getProperty(ConstantesBD.PASSWORD);
            String PORT = properties.getProperty(ConstantesBD.PORT);
            String HOST = properties.getProperty(ConstantesBD.HOST);
            String DRIVER = properties.getProperty(ConstantesBD.DRIVER);
            String CONFIG = properties.getProperty(ConstantesBD.CONFIG);
            String URL = properties.getProperty(ConstantesBD.URL);

            String URL_FINAL = URL + HOST + ":" + PORT + "/" + ConstantesBD.bd + CONFIG;
            System.out.println("URL_FINAL= " + URL_FINAL + " - SESION= " + ConstantesBD.session);

            DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName(DRIVER);
            dataSourceBuilder.url(URL_FINAL);
            dataSourceBuilder.username(USER);
            dataSourceBuilder.password(PASSWORD);

            return dataSourceBuilder.build();
        }
}
