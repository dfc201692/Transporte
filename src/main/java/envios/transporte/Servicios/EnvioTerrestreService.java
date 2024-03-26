package envios.transporte.Servicios;

import envios.transporte.Modelo.EnvioTerrestre;
import envios.transporte.Repositorio.EnvioTerrestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnvioTerrestreService {

    @Autowired
    private EnvioTerrestreRepository envioTerrestreRepository;

    // Método para guardar un envío terrestre
    public EnvioTerrestre saveEnvioTerrestre(EnvioTerrestre envioTerrestre) {
        return envioTerrestreRepository.save(envioTerrestre);
    }

    // Método para obtener todos los envíos terrestres
    public List<EnvioTerrestre> getAllEnviosTerrestres() {
        return envioTerrestreRepository.findAll();
    }

    // Método para obtener un envío terrestre por su ID
    public EnvioTerrestre getEnvioTerrestreById(Long id) {
        return envioTerrestreRepository.findById(id).orElse(null);
    }

    // Método para actualizar un envío terrestre
    public EnvioTerrestre updateEnvioTerrestre(Long id, EnvioTerrestre envioTerrestreDetails) {
        EnvioTerrestre envioTerrestre = envioTerrestreRepository.findById(id).orElse(null);
        if (envioTerrestre != null) {
            // Actualizar los detalles del envío terrestre
            envioTerrestre.setCliente(envioTerrestreDetails.getCliente());
            envioTerrestre.setTipoProducto(envioTerrestreDetails.getTipoProducto());
            envioTerrestre.setCantidadProducto(envioTerrestreDetails.getCantidadProducto());
            envioTerrestre.setFechaRegistro(envioTerrestreDetails.getFechaRegistro());
            envioTerrestre.setFechaEntrega(envioTerrestreDetails.getFechaEntrega());
            envioTerrestre.setBodegaEntrega(envioTerrestreDetails.getBodegaEntrega());
            envioTerrestre.setPrecioEnvio(envioTerrestreDetails.getPrecioEnvio());
            envioTerrestre.setPlacaVehiculo(envioTerrestreDetails.getPlacaVehiculo());
            envioTerrestre.setNumeroGuia(envioTerrestreDetails.getNumeroGuia());

            return envioTerrestreRepository.save(envioTerrestre);
        }
        return null;
    }

    // Método para eliminar un envío terrestre
    public void deleteEnvioTerrestre(Long id) {
        envioTerrestreRepository.deleteById(id);
    }
}
