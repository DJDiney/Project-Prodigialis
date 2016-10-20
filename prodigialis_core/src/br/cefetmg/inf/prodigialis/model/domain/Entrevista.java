
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Date;
import java.util.Objects;


public class Entrevista {
    
    private Candidato candidato;
    private Funcionario funcionario;
    private Vaga vaga;
    private Long cod_ent;
    private Date dat_ent;
    private boolean est_aprov;
    private String desc_ent;
    
    public Entrevista () {}

    public Entrevista(Candidato candidato, Funcionario funcionario, Vaga vaga, Long cod_ent, Date dat_ent, boolean est_aprov, String desc_ent) {
        this.candidato = candidato;
        this.funcionario = funcionario;
        this.vaga = vaga;
        this.cod_ent = cod_ent;
        this.dat_ent = dat_ent;
        this.est_aprov = est_aprov;
        this.desc_ent = desc_ent;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Long getCod_ent() {
        return cod_ent;
    }

    public void setCod_ent(Long cod_ent) {
        this.cod_ent = cod_ent;
    }

    public Date getDat_ent() {
        return dat_ent;
    }

    public void setDat_ent(Date dat_ent) {
        this.dat_ent = dat_ent;
    }

    public boolean isEst_aprov() {
        return est_aprov;
    }

    public void setEst_aprov(boolean est_aprov) {
        this.est_aprov = est_aprov;
    }

    public String getDesc_ent() {
        return desc_ent;
    }

    public void setDesc_ent(String desc_ent) {
        this.desc_ent = desc_ent;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.candidato);
        hash = 89 * hash + Objects.hashCode(this.funcionario);
        hash = 89 * hash + Objects.hashCode(this.vaga);
        hash = 89 * hash + Objects.hashCode(this.cod_ent);
        hash = 89 * hash + Objects.hashCode(this.dat_ent);
        hash = 89 * hash + (this.est_aprov ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.desc_ent);
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
        final Entrevista other = (Entrevista) obj;
        if (!Objects.equals(this.candidato, other.candidato)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.vaga, other.vaga)) {
            return false;
        }
        if (!Objects.equals(this.cod_ent, other.cod_ent)) {
            return false;
        }
        if (!Objects.equals(this.dat_ent, other.dat_ent)) {
            return false;
        }
        if (this.est_aprov != other.est_aprov) {
            return false;
        }
        if (!Objects.equals(this.desc_ent, other.desc_ent)) {
            return false;
        }
        return true;
    }

}