package com.tabelafipe.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosModeloVeiculo(@JsonAlias("codigo")String codigoAno,
                                 @JsonAlias("nome") String nomeAno) {
}
