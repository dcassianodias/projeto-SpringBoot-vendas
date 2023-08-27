package io.github.dcassianodias.domain.repositories;

import io.github.dcassianodias.domain.model.Cliente;
import io.github.dcassianodias.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
