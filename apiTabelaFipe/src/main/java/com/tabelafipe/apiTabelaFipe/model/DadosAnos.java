package com.tabelafipe.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAnos(@JsonAlias("codigo")String codigoAnoModelo,
                        @JsonAlias("nome") String nomeAnoModelo) {
}
