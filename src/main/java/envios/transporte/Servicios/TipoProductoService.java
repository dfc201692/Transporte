package envios.transporte.Servicios;

import envios.transporte.Modelo.TipoProducto;
import envios.transporte.Repositorio.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoProductoService {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    // Método para guardar un tipo de producto
    public TipoProducto saveTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    // Método para obtener todos los tipos de producto
    public List<TipoProducto> getAllTiposProducto() {
        return tipoProductoRepository.findAll();
    }

    // Método para obtener un tipo de producto por su ID
    public TipoProducto getTipoProductoById(Long id) {
        return tipoProductoRepository.findById(id).orElse(null);
    }

    // Método para actualizar un tipo de producto
    public TipoProducto updateTipoProducto(Long id, TipoProducto tipoProductoDetails) {
        TipoProducto tipoProducto = tipoProductoRepository.findById(id).orElse(null);
        if (tipoProducto != null) {
            tipoProducto.setNombre(tipoProductoDetails.getNombre());
            return tipoProductoRepository.save(tipoProducto);
        }
        return null;
    }

    // Método para eliminar un tipo de producto
    public void deleteTipoProducto(Long id) {
        tipoProductoRepository.deleteById(id);
    }
}
