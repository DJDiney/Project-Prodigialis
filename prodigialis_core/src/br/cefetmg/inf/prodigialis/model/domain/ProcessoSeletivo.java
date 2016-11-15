/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cliente
 */
public class ProcessoSeletivo {
    private ArrayList<Participante> participantes =  new ArrayList();
    private Date dataInicio;
    private Date dataFinal;
    private String nome;
    private String descricao;
    private int codProcesso;
    private Prova prova;
    private int nroVagas;
    private Cargo cargoOferecido;
    
}
