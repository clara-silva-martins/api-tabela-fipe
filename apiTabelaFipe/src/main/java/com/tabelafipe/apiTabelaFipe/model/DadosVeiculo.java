package com.tabelafipe.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(@JsonAlias("codigo") Integer codigoMarca,
                           @JsonAlias("nome") String nomeMarca) {
}
