package com.tabelafipe.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DadosMarca(@JsonAlias("modelos") List<DadosModelos> modelos,
                         @JsonAlias("anos")List<DadosAnos> anos) {
}
