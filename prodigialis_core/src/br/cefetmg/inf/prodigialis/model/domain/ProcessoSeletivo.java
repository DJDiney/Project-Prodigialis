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
    private Integer codProcesso;
    private Prova prova;
    private Integer nroVagas;
    private boolean em_andamento;
    private Cargo cargoOferecido;

    public ProcessoSeletivo(Date dataInicio, Date dataFinal, String nome, String descricao, int codProcesso, Prova prova, int nroVagas, boolean em_andamento, Cargo cargoOferecido) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.nome = nome;
        this.descricao = descricao;
        this.codProcesso = codProcesso;
        this.prova = prova;
        this.nroVagas = nroVagas;
        this.em_andamento = em_andamento;
        this.cargoOferecido = cargoOferecido;
    }

    public ProcessoSeletivo() {}

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodProcesso() {
        return codProcesso;
    }

    public void setCodProcesso(int codProcesso) {
        this.codProcesso = codProcesso;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public Integer getNroVagas() {
        return nroVagas;
    }

    public void setNroVagas(int nroVagas) {
        this.nroVagas = nroVagas;
    }

    public boolean isEm_andamento() {
        return em_andamento;
    }

    public void setEm_andamento(boolean em_andamento) {
        this.em_andamento = em_andamento;
    }

    public Cargo getCargoOferecido() {
        return cargoOferecido;
    }

    public void setCargoOferecido(Cargo cargoOferecido) {
        this.cargoOferecido = cargoOferecido;
    }
    
    

}   
