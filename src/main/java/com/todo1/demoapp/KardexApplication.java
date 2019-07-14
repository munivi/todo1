package com.todo1.demoapp;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.todo1.demoapp.bo.ProductoBo;
import com.todo1.demoapp.dto.ProductoDTO;

@SpringBootApplication
@ComponentScan
@Configuration
@EnableTransactionManagement
public class KardexApplication {
	private static final Logger logger = LogManager.getLogger(KardexApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KardexApplication.class, args);

	}

	/**
	 * Precarga de la base con productos
	 * 
	 * @author Usuario
	 *
	 */
	@Component
	class precargaProductos implements CommandLineRunner {
		private static final long CODIGO_PROD_CAMISETA = 1;
		private static final long CODIGO_PROD_VASO = 2;
		private static final long CODIGO_PROD_COMIC = 3;
		private static final long CODIGO_PROD_JUGUETE = 4;
		private static final long CODIGO_PROD_ACCESORIO = 5;
		private static final long STOCK = 20;
		private static final String CAMISETA = "Camiseta";
		private static final String VASO = "Vaso";
		private static final String COMIC = "Comic";
		private static final String JUGUETES = "Juguete";
		private static final String ACCESORIOS = "Accesorio";
		private static final String MARCA_DC = "DC Comics";
		private static final String MARCA_MARVEL = "Marvel";
		private static final long CODIGO_PROD_CAMISETA_MARVEL = 6;
		private static final long CODIGO_PROD_ACCESORIO_MARVEL = 7;
		private static final long CODIGO_PROD_COMIC_MARVEL = 8;
		private static final long CODIGO_PROD_JUGUETE_MARVEL = 9;
		private static final long CODIGO_PROD_VASO_MARVEL = 10;

		@Autowired
		private ProductoBo productosBo;

		@Override
		public void run(String... args) throws Exception {
			logger.info("Iniciando la precarga de la base en memoria con 10 productos");
			// Creacion de los productos de DC Comics
			ProductoDTO productoDTO1 = new ProductoDTO(CODIGO_PROD_CAMISETA, CAMISETA, STOCK, new Date(), MARCA_DC);
			ProductoDTO productoDTO2 = new ProductoDTO(CODIGO_PROD_ACCESORIO, ACCESORIOS, STOCK, new Date(), MARCA_DC);
			ProductoDTO productoDTO3 = new ProductoDTO(CODIGO_PROD_COMIC, COMIC, STOCK, new Date(), MARCA_DC);
			ProductoDTO productoDTO4 = new ProductoDTO(CODIGO_PROD_JUGUETE, JUGUETES, STOCK, new Date(), MARCA_DC);
			ProductoDTO productoDTO5 = new ProductoDTO(CODIGO_PROD_VASO, VASO, STOCK, new Date(), MARCA_DC);
			productosBo.guardarProducto(productoDTO1);
			productosBo.guardarProducto(productoDTO2);
			productosBo.guardarProducto(productoDTO3);
			productosBo.guardarProducto(productoDTO4);
			productosBo.guardarProducto(productoDTO5);

			ProductoDTO productoDTO6 = new ProductoDTO(CODIGO_PROD_CAMISETA_MARVEL, CAMISETA, STOCK, new Date(),
					MARCA_MARVEL);
			ProductoDTO productoDTO7 = new ProductoDTO(CODIGO_PROD_ACCESORIO_MARVEL, ACCESORIOS, STOCK, new Date(),
					MARCA_MARVEL);
			ProductoDTO productoDTO8 = new ProductoDTO(CODIGO_PROD_COMIC_MARVEL, COMIC, STOCK, new Date(),
					MARCA_MARVEL);
			ProductoDTO productoDTO9 = new ProductoDTO(CODIGO_PROD_JUGUETE_MARVEL, JUGUETES, STOCK, new Date(),
					MARCA_MARVEL);
			ProductoDTO productoDTO10 = new ProductoDTO(CODIGO_PROD_VASO_MARVEL, VASO, STOCK, new Date(), MARCA_MARVEL);
			productosBo.guardarProducto(productoDTO6);
			productosBo.guardarProducto(productoDTO7);
			productosBo.guardarProducto(productoDTO8);
			productosBo.guardarProducto(productoDTO9);
			productosBo.guardarProducto(productoDTO10);
			logger.info("finalizacion de la precarga de datos");

		}
	}

}
