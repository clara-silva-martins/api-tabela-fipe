package com.tabelafipe.apiTabelaFipe.principal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tabelafipe.apiTabelaFipe.model.*;
import com.tabelafipe.apiTabelaFipe.service.ConsumoApi;
import com.tabelafipe.apiTabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private ConsumoApi consumo = new ConsumoApi();
    private Scanner leitura = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu(){
        //VEICULOS

        System.out.println("Digite o veículo que você deseja consultar: \n " + "carros \n motos \n caminhões");
        var nomeVeiculo = leitura.nextLine();
        var json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo + "/marcas/");

        List<DadosVeiculo> dadosVeiculos = conversor.obterDados(json, new TypeReference<List<DadosVeiculo>>() {});
        dadosVeiculos.forEach(d -> System.out.println("Cód: " + d.codigoMarca() + " Descrição: " + d.nomeMarca()));

        //CODIGO DA MARCA PARA CONSULTA


        System.out.println("Digite o código da marca para a consulta: ");
        var codigoVeiculo = leitura.nextInt();
        leitura.nextLine();
        json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo + "/marcas/"
                        + codigoVeiculo + "/modelos" );
        DadosMarca dadosMarcas = conversor.obterDados(json, new TypeReference<DadosMarca>() {});

        dadosMarcas.modelos().forEach(m -> System.out.println("Cód: " + m.codigoModelo() + " Descrição " + m.nomeModelo()));


        //LISTAGEM DOS MODELOS COM BASE NO QUE O USUÁRIO DIGITOU


        System.out.println("Digite um trecho do modelo do carro que você procura: ");
        var trechoCarro = leitura.nextLine();

        List<DadosModelos> modeloEncontrado = dadosMarcas.modelos()
                .stream()
                .filter(item -> item.nomeModelo().toUpperCase().contains(trechoCarro.toUpperCase()))
                .collect(Collectors.toList());

        modeloEncontrado.forEach(a -> System.out.println("Cód: " + a.codigoModelo() + " Descrição: " + a.nomeModelo()));

        //CODIGO DO MODELO

        System.out.println("Digite o código da modelo do veículo desejado: ");
        var codigoModelo = leitura.nextInt();
        leitura.nextLine();

        json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo + "/marcas/"
                + codigoVeiculo + "/modelos/" + codigoModelo + "/anos" );
        List<DadosModeloVeiculo> anos = conversor.obterDados(json, new TypeReference<List<DadosModeloVeiculo>>() {});

        //ITERAR NA LISTA DE ANOS PARA MOSTRAR AS INFORMAÇÕES POR ANOS

        List<Valor> valores = new ArrayList<>();
        for (int i = 0; i < anos.size(); i++) {
            json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo + "/marcas/"
                    + codigoVeiculo + "/modelos/" + codigoModelo + "/anos/" + anos.get(i).codigoAno());
            Valor valoresPorAno = conversor.obterDados(json, new TypeReference<Valor>() {});
            valores.addAll(Collections.singleton(valoresPorAno));
        }
        valores.forEach(System.out::println);



//        dadosMarcas.modelos().forEach(m -> System.out.println("Cód: " + m.codigoModelo() + " Descrição " + m.nomeModelo()));

//        List<DadosModeloVeiculo> dadosModeloGeral = new ArrayList<>();
//
//        System.out.println("Inicio ");
//        modeloEncontrado.forEach(item -> {
//            String jsonResponse = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo + "/marcas/"
//                    + codigoVeiculo + "/modelos/" + item.codigoModelo() + "/anos");
//            List<DadosModeloVeiculo> dadosModelo = conversor.obterDados(jsonResponse,
//                    new TypeReference<List<DadosModeloVeiculo>>() {});
//            dadosModeloGeral.addAll(dadosModelo);
//        });
//        System.out.println("Fim ");
//            dadosModeloGeral.forEach(mg -> System.out.println("Cód: " + mg.codigoAno() + " Descrição: " + mg.nomeAno()));



//        //CODIGO DO ANO

//        System.out.println("Digite o código ano do veículo para acessar as informações: ");
//        var codigoInfos = leitura.nextLine();
//        json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/" + nomeVeiculo + "/marcas/"
//                + codigoVeiculo + "/modelos/" + item.codigoModelo() + "/anos/" + codigoInfos);
//        System.out.println(json);
//        DadosValor dadosValor = conversor.obterDados(json, DadosValor.class);
//        System.out.println(dadosValor);




    }}


