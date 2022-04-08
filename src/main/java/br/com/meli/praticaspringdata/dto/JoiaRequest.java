package br.com.meli.praticaspringdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JoiaRequest {
    private String material;
    private float peso;
    private float quilates;
}
