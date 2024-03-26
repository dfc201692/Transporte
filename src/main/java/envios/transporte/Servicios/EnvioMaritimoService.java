package envios.transporte.Servicios;

import envios.transporte.Modelo.EnvioMaritimo;
import envios.transporte.Repositorio.EnvioMaritimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnvioMaritimoService {

    @Autowired
    private EnvioMaritimoRepository envioMaritimoRepository;

    // Método para guardar un envío marítimo
    public EnvioMaritimo saveEnvioMaritimo(EnvioMaritimo envioMaritimo) {
        return envioMaritimoRepository.save(envioMaritimo);
    }

    // Método para obtener todos los envíos marítimos
    public List<EnvioMaritimo> getAllEnviosMaritimos() {
        return envioMaritimoRepository.findAll();
    }

    // Método para obtener un envío marítimo por su ID
    public EnvioMaritimo getEnvioMaritimoById(Long id) {
        return envioMaritimoRepository.findById(id).orElse(null);
    }

    // Método para actualizar un envío marítimo
    public EnvioMaritimo updateEnvioMaritimo(Long id, EnvioMaritimo envioMaritimoDetails) {
        EnvioMaritimo envioMaritimo = envioMaritimoRepository.findById(id).orElse(null);
        if (envioMaritimo != null) {
            // Actualizar los detalles del envío marítimo
            envioMaritimo.setCliente(envioMaritimoDetails.getCliente());
            envioMaritimo.setTipoProducto(envioMaritimoDetails.getTipoProducto());
            envioMaritimo.setCantidadProducto(envioMaritimoDetails.getCantidadProducto());
            envioMaritimo.setFechaRegistro(envioMaritimoDetails.getFechaRegistro());
            envioMaritimo.setFechaEntrega(envioMaritimoDetails.getFechaEntrega());
            envioMaritimo.setPuertoEntrega(envioMaritimoDetails.getPuertoEntrega());
            envioMaritimo.setPrecioEnvio(envioMaritimoDetails.getPrecioEnvio());
            envioMaritimo.setNumeroFlota(envioMaritimoDetails.getNumeroFlota());
            envioMaritimo.setNumeroGuia(envioMaritimoDetails.getNumeroGuia());

            return envioMaritimoRepository.save(envioMaritimo);
        }
        return null;
    }

    // Método para eliminar un envío marítimo
    public void deleteEnvioMaritimo(Long id) {
        envioMaritimoRepository.deleteById(id);
    }
}
