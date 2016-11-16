
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;


public class Participante {
    
    private Candidato candidato;
    private boolean est_aprov;
    private byte[] arq_respostas={' '};
    private String path_respostas="";
    private double nota;
    private int nroInscricao = -1;
    private int codProcesso;
    
    public Participante () {}

    public Participante(int codProcesso,Candidato candidato, byte[] arq_respostas, int nroInscricao, Integer nota, Integer colocao, boolean est_aprov) {
        this.candidato = candidato;
        this.arq_respostas = arq_respostas;
        this.nroInscricao = nroInscricao;
        this.nota = nota;
        this.est_aprov = est_aprov;
        this.codProcesso = codProcesso;
    }
    
    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public String getCpf () {
        return candidato.getCpf();
    }

    public byte[] getArqRespostas() {
        return arq_respostas;
    }

    public void setProva(byte[] getArqRespostas) {
        this.arq_respostas = arq_respostas;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public boolean isEst_aprov() {
        return est_aprov;
    }

    public void setEst_aprov(boolean est_aprov) {
        this.est_aprov = est_aprov;
    }

    public int getNroInscricao() {
        return nroInscricao;
    }

    public void setNroInscricao(int nroInscricao) {
        this.nroInscricao = nroInscricao;
    }

    public int getCodProcesso() {
        return codProcesso;
    }

    public void setCodProcesso(int codProcesso) {
        this.codProcesso = codProcesso;
    }

    public byte[] getArq_respostas() {
        return arq_respostas;
    }

    public void setArq_respostas(byte[] arq_respostas) {
        this.arq_respostas = arq_respostas;
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
        if (!Objects.equals(this.nroInscricao, other.nroInscricao)) {
            return false;
        }
        if (this.est_aprov != other.est_aprov) {
            return false;
        }
        return true;
    }

}