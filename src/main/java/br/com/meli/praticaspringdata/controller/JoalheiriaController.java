package br.com.meli.praticaspringdata.controller;

import br.com.meli.praticaspringdata.dto.JoiaRequest;
import br.com.meli.praticaspringdata.dto.JoiaResponse;
import br.com.meli.praticaspringdata.dto.JoiaUpdateRequest;
import br.com.meli.praticaspringdata.entity.Joia;
import br.com.meli.praticaspringdata.service.JoalheiriaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/joias")
@AllArgsConstructor
public class JoalheiriaController {

    private final JoalheiriaService joalheiriaService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(joalheiriaService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody JoiaRequest joiaRequest) {
        Joia joia = modelMapper.map(joiaRequest, Joia.class);
        Joia savedJoia = joalheiriaService.save(joia);
        JoiaResponse mappedJoia = modelMapper.map(savedJoia, JoiaResponse.class);
        return ResponseEntity.created(URI.create("/" + mappedJoia.getNumeroIdentificacao())).body(mappedJoia);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@RequestParam Long identificacao) {
        joalheiriaService.deleteById(identificacao);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody JoiaUpdateRequest newJoia) {
        Joia mappedJoia = modelMapper.map(newJoia, Joia.class);
        Joia updatedJoia = joalheiriaService.updateJoia(mappedJoia);
        return ResponseEntity.ok(updatedJoia);
    }
}
