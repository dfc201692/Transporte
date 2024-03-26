package envios.transporte.Repositorio;


import envios.transporte.Modelo.EnvioMaritimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioMaritimoRepository extends JpaRepository<EnvioMaritimo, Long> {
}