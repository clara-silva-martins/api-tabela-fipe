package com.tabelafipe.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(@JsonAlias("codigo")Integer codigoModelo,
                           @JsonAlias("nome")String nomeModelo) {
}
