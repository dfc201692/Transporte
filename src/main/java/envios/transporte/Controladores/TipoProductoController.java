package envios.transporte.Controladores;

import envios.transporte.Modelo.TipoProducto;
import envios.transporte.Servicios.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-producto")
public class TipoProductoController {

    @Autowired
    private TipoProductoService tipoProductoService;

    // Controladores para API RESTful de tipos de producto

    @GetMapping
    public ResponseEntity<List<TipoProducto>> getAllTiposProducto() {
        List<TipoProducto> tiposProducto = tipoProductoService.getAllTiposProducto();
        return new ResponseEntity<>(tiposProducto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> getTipoProductoById(@PathVariable Long id) {
        TipoProducto tipoProducto = tipoProductoService.getTipoProductoById(id);
        if (tipoProducto != null) {
            return new ResponseEntity<>(tipoProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TipoProducto> createTipoProducto(@RequestBody TipoProducto tipoProducto) {
        TipoProducto createdTipoProducto = tipoProductoService.saveTipoProducto(tipoProducto);
        return new ResponseEntity<>(createdTipoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProducto> updateTipoProducto(@PathVariable Long id, @RequestBody TipoProducto tipoProducto) {
        TipoProducto updatedTipoProducto = tipoProductoService.updateTipoProducto(id, tipoProducto);
        if (updatedTipoProducto != null) {
            return new ResponseEntity<>(updatedTipoProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoProducto(@PathVariable Long id) {
        tipoProductoService.deleteTipoProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
