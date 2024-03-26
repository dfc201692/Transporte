package envios.transporte.Repositorio;

import envios.transporte.Modelo.EnvioTerrestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioTerrestreRepository extends JpaRepository<EnvioTerrestre, Long> {
}