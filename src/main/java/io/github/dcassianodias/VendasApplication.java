package io.github.dcassianodias;

import io.github.dcassianodias.domain.model.Cliente;
import io.github.dcassianodias.domain.model.Pedido;
import io.github.dcassianodias.domain.repositories.ClienteRepository;
import io.github.dcassianodias.domain.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository repository,
								  @Autowired PedidoRepository pedidoRepository
	){
		return args -> {

			System.out.println("Salvando clientes");
			Cliente cliente = new Cliente("Danilo");
			repository.save(cliente);

			Pedido p = new Pedido();
			p.setCliente(cliente);
			p.setDataPedido(LocalDate.now());
			p.setTotal((BigDecimal.valueOf(100)));

			pedidoRepository.save(p);

//			Cliente c = repository.findClienteFetchPedidos(cliente.getId());
//			System.out.println(c);
//			System.out.println(c.getPedidos());

			pedidoRepository.findByCliente(cliente).forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
