package io.github.dcassianodias.domain.repository;

import io.github.dcassianodias.domain.model.Cliente;
import io.github.dcassianodias.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
