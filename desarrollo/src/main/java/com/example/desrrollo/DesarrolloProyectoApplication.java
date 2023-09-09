package com.example.desrrollo;

import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import com.example.desrrollo.Repository.RepositoryRegistroTransaccionDineroInventario;
import com.example.desrrollo.Repository.RepositoryRegistroTransacion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		//List<LineaRegistroTransaccionProductoDTO> listaLinea = repositoryLineaRegistroProducto.findAllLineaRegistroTransaccion();
		//listaLinea.forEach(System.out::println);

	}
}
