package com.example.desrrollo;

import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import com.example.desrrollo.Repository.RepositoryRegistroTransacion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesarrolloProyectoApplication implements CommandLineRunner {
	private final RepositoryRegistroTransacion repositoryRegistroTransacion;

	private final RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;



	public DesarrolloProyectoApplication(RepositoryRegistroTransacion repositoryRegistroTransacion, RepositoryLineaRegistroProducto repositoryLineaRegistroProducto) {
		this.repositoryRegistroTransacion = repositoryRegistroTransacion;
		this.repositoryLineaRegistroProducto = repositoryLineaRegistroProducto;
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
