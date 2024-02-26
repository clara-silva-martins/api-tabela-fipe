package com.tabelafipe.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Valor(@JsonAlias("TipoVeiculo") Integer veiculo,
                    @JsonAlias("Valor") String valor,
                    @JsonAlias("Marca") String marca,
                    @JsonAlias("Modelo") String modelo,
                    @JsonAlias("AnoModelo") Integer anoDoModelo,
                    @JsonAlias("Combustivel") String combustivel
                         ) {
}
