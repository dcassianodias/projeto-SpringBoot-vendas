package io.github.dcassianodias.domain.repositories;

import io.github.dcassianodias.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "select c from Cliente c where c.nome ilike %:nome%")
    List<Cliente> findByNomeLike(String nome);

    @Query(value = "delete from Cliente c where c.nome =:nome")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query(value = "select c from Cliente c left join fetch c.pedidos where c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);


}
