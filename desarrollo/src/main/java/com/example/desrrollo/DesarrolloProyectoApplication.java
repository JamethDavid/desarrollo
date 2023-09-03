package com.example.desrrollo;

import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import com.example.desrrollo.Repository.RepositoryRegistroTransaccionDineroInventario;
import com.example.desrrollo.Repository.RepositoryRegistroTransacion;
import org.aspectj.bridge.ICommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DesarrolloProyectoApplication implements CommandLineRunner {
	private final RepositoryRegistroTransacion repositoryRegistroTransacion;

	private final RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;
	private final RepositoryRegistroTransaccionDineroInventario repositoryRegistroTransaccionDineroInventario;


	public DesarrolloProyectoApplication(RepositoryRegistroTransacion repositoryRegistroTransacion, RepositoryLineaRegistroProducto repositoryLineaRegistroProducto, RepositoryRegistroTransaccionDineroInventario repositoryRegistroTransaccionDineroInventario) {
		this.repositoryRegistroTransacion = repositoryRegistroTransacion;
		this.repositoryLineaRegistroProducto = repositoryLineaRegistroProducto;
		this.repositoryRegistroTransaccionDineroInventario = repositoryRegistroTransaccionDineroInventario;
	}

	public static void main (String[]args){
			SpringApplication.run(DesarrolloProyectoApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		List<Object[]> listaLinea = repositoryLineaRegistroProducto.findAllLineaRegistroTransaccion();
		listaLinea.forEach(resultado -> {
			Date fecha = (Date) resultado[0];

			Byte idTransacion = (Byte) resultado[1];
			String descripcion = (String) resultado[2];
			String consecutivoGravado = (String) resultado[3];
			String nombre = (String) resultado[4];
			BigDecimal cantidad = (BigDecimal) resultado[5];
			BigDecimal valorBruto = (BigDecimal) resultado[6];

			System.out.println("fecha = " + fecha + "transaccion = " + idTransacion + "descripcion = "
					+ descripcion + "consecutivoGravado" + consecutivoGravado + "terceros = " + nombre + "cantidad = " + cantidad + "valorBruto = " + valorBruto
			);
		});
	}
}
