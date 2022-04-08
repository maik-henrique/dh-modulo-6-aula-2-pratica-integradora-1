package br.com.meli.praticaspringdata.service;

import br.com.meli.praticaspringdata.entity.Joia;
import br.com.meli.praticaspringdata.repository.JoiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JoalheiriaService {
    private final JoiaRepository joiaRepository;

    public Joia save(Joia joia) {
        return joiaRepository.save(joia);
    }

    public List<Joia> findAll() {
        return joiaRepository.findAll();
    }

    public void deleteById(Long nmeroIdentificacao) {
        joiaRepository.deleteById(nmeroIdentificacao);
    }

    public Joia updateJoia(Joia updatedJoia) {
        Joia oldJoia = joiaRepository.findById(updatedJoia.getNumeroIdentificacao())
                .orElseThrow(() -> new RuntimeException("Jóia nào encontrada"));
        oldJoia.setMaterial(updatedJoia.getMaterial());
        oldJoia.setPeso(updatedJoia.getPeso());
        oldJoia.setQuilates(updatedJoia.getQuilates());
        Joia newJoia = joiaRepository.save(oldJoia);
        return newJoia;
    }
}
