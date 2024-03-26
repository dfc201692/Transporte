package envios.transporte.Controladores;

import envios.transporte.Modelo.EnvioMaritimo;
import envios.transporte.Servicios.EnvioMaritimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/envios-maritimos")
public class EnvioMaritimoController {

    @Autowired
    private EnvioMaritimoService envioMaritimoService;

    // Método para obtener todos los envíos marítimos
    @GetMapping
    public ResponseEntity<List<EnvioMaritimo>> getAllEnviosMaritimos() {
        List<EnvioMaritimo> enviosMaritimos = envioMaritimoService.getAllEnviosMaritimos();
        return new ResponseEntity<>(enviosMaritimos, HttpStatus.OK);
    }

    // Método para obtener un envío marítimo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<EnvioMaritimo> getEnvioMaritimoById(@PathVariable Long id) {
        EnvioMaritimo envioMaritimo = envioMaritimoService.getEnvioMaritimoById(id);
        if (envioMaritimo != null) {
            return new ResponseEntity<>(envioMaritimo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para crear un nuevo envío marítimo
    @PostMapping
    public ResponseEntity<EnvioMaritimo> createEnvioMaritimo(@RequestBody EnvioMaritimo envioMaritimo) {
        EnvioMaritimo createdEnvioMaritimo = envioMaritimoService.saveEnvioMaritimo(envioMaritimo);
        return new ResponseEntity<>(createdEnvioMaritimo, HttpStatus.CREATED);
    }

    // Método para actualizar un envío marítimo existente
    @PutMapping("/{id}")
    public ResponseEntity<EnvioMaritimo> updateEnvioMaritimo(@PathVariable Long id, @RequestBody EnvioMaritimo envioMaritimo) {
        EnvioMaritimo updatedEnvioMaritimo = envioMaritimoService.updateEnvioMaritimo(id, envioMaritimo);
        if (updatedEnvioMaritimo != null) {
            return new ResponseEntity<>(updatedEnvioMaritimo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para eliminar un envío marítimo existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvioMaritimo(@PathVariable Long id) {
        envioMaritimoService.deleteEnvioMaritimo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


