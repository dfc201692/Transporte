package envios.transporte.Controladores;

import envios.transporte.Modelo.EnvioTerrestre;
import envios.transporte.Servicios.EnvioTerrestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RestController
@RequestMapping("/api/envios-terrestres")
public class EnvioTerrestreController {

    @Autowired
    private EnvioTerrestreService envioTerrestreService;

    // Método para obtener todos los envíos terrestres
    @GetMapping
    public ResponseEntity<List<EnvioTerrestre>> getAllEnviosTerrestres() {
        List<EnvioTerrestre> enviosTerrestres = envioTerrestreService.getAllEnviosTerrestres();
        return new ResponseEntity<>(enviosTerrestres, HttpStatus.OK);
    }

    // Método para obtener un envío terrestre por su ID
    @GetMapping("/{id}")
    public ResponseEntity<EnvioTerrestre> getEnvioTerrestreById(@PathVariable Long id) {
        EnvioTerrestre envioTerrestre = envioTerrestreService.getEnvioTerrestreById(id);
        if (envioTerrestre != null) {
            return new ResponseEntity<>(envioTerrestre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para crear un nuevo envío terrestre
    @PostMapping
    public ResponseEntity<EnvioTerrestre> createEnvioTerrestre(@RequestBody EnvioTerrestre envioTerrestre) {
        EnvioTerrestre createdEnvioTerrestre = envioTerrestreService.saveEnvioTerrestre(envioTerrestre);
        return new ResponseEntity<>(createdEnvioTerrestre, HttpStatus.CREATED);
    }

    // Método para actualizar un envío terrestre existente
    @PutMapping("/{id}")
    public ResponseEntity<EnvioTerrestre> updateEnvioTerrestre(@PathVariable Long id, @RequestBody EnvioTerrestre envioTerrestre) {
        EnvioTerrestre updatedEnvioTerrestre = envioTerrestreService.updateEnvioTerrestre(id, envioTerrestre);
        if (updatedEnvioTerrestre != null) {
            return new ResponseEntity<>(updatedEnvioTerrestre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para eliminar un envío terrestre existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvioTerrestre(@PathVariable Long id) {
        envioTerrestreService.deleteEnvioTerrestre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
