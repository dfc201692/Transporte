package envios.transporte.Repositorio;

import envios.transporte.Modelo.Cliente;
import envios.transporte.Modelo.EnvioTerrestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioTerrestreRepository extends JpaRepository<EnvioTerrestre, Long> {

    List<EnvioTerrestre> findByCliente(Cliente cliente);

    EnvioTerrestre findByNumeroGuia(String numeroGuia);

}