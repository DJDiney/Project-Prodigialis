
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;


public class Participante {
    
    private Candidato candidato;
    private Prova prova;
    private Integer nro_ins;
    private Integer nota;
    private Integer colocao;
    private boolean est_aprov;
    
    public Participante () {}

    public Participante(Candidato candidato, Prova prova, Integer nro_ins, Integer nota, Integer colocao, boolean est_aprov) {
        this.candidato = candidato;
        this.prova = prova;
        this.nro_ins = nro_ins;
        this.nota = nota;
        this.colocao = colocao;
        this.est_aprov = est_aprov;
    }
    
    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public char getCpf () {
        return candidato.getCpf();
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public Integer getNro_ins() {
        return nro_ins;
    }

    public void setNro_ins(Integer nro_ins) {
        this.nro_ins = nro_ins;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getColocao() {
        return colocao;
    }

    public void setColocao(Integer colocao) {
        this.colocao = colocao;
    }

    public boolean isEst_aprov() {
        return est_aprov;
    }

    public void setEst_aprov(boolean est_aprov) {
        this.est_aprov = est_aprov;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.candidato);
        hash = 79 * hash + Objects.hashCode(this.prova);
        hash = 79 * hash + Objects.hashCode(this.nro_ins);
        hash = 79 * hash + (this.est_aprov ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participante other = (Participante) obj;
        if (!Objects.equals(this.candidato, other.candidato)) {
            return false;
        }
        if (!Objects.equals(this.prova, other.prova)) {
            return false;
        }
        if (!Objects.equals(this.nro_ins, other.nro_ins)) {
            return false;
        }
        if (this.est_aprov != other.est_aprov) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participante{" + "candidato=" + candidato + ", prova=" + prova + ", nro_ins=" + nro_ins +  ", est_aprov=" + est_aprov + '}';
    }
    
}