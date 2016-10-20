
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Date;
import java.util.Objects;

public class ProcessoSeletivo {
    
    private Long cod_proc;
    private Vaga vaga;
    private Prova prova;
    private Participante participante;
    private Date dat_ini;
    private Date dat_fim;
    private String nom_proc;
    private String desc_proc;
    private Long nro_vagas;
    
    public ProcessoSeletivo () {}

    public ProcessoSeletivo(Long cod_proc, Vaga vaga, Prova prova, Participante participante, Date dat_ini, Date dat_fim, String nom_proc, String desc_proc, Long nro_vagas) {
        this.cod_proc = cod_proc;
        this.vaga = vaga;
        this.prova = prova;
        this.participante = participante;
        this.dat_ini = dat_ini;
        this.dat_fim = dat_fim;
        this.nom_proc = nom_proc;
        this.desc_proc = desc_proc;
        this.nro_vagas = nro_vagas;
    }

    public Long getCod_proc() {
        return cod_proc;
    }

    public void setCod_proc(Long cod_proc) {
        this.cod_proc = cod_proc;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Date getDat_ini() {
        return dat_ini;
    }

    public void setDat_ini(Date dat_ini) {
        this.dat_ini = dat_ini;
    }

    public Date getDat_fim() {
        return dat_fim;
    }

    public void setDat_fim(Date dat_fim) {
        this.dat_fim = dat_fim;
    }

    public String getNom_proc() {
        return nom_proc;
    }

    public void setNom_proc(String nom_proc) {
        this.nom_proc = nom_proc;
    }

    public String getDesc_proc() {
        return desc_proc;
    }

    public void setDesc_proc(String desc_proc) {
        this.desc_proc = desc_proc;
    }

    public Long getNro_vagas() {
        return nro_vagas;
    }

    public void setNro_vagas(Long nro_vagas) {
        this.nro_vagas = nro_vagas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cod_proc);
        hash = 37 * hash + Objects.hashCode(this.vaga);
        hash = 37 * hash + Objects.hashCode(this.prova);
        hash = 37 * hash + Objects.hashCode(this.participante);
        hash = 37 * hash + Objects.hashCode(this.dat_ini);
        hash = 37 * hash + Objects.hashCode(this.dat_fim);
        hash = 37 * hash + Objects.hashCode(this.nom_proc);
        hash = 37 * hash + Objects.hashCode(this.desc_proc);
        hash = 37 * hash + Objects.hashCode(this.nro_vagas);
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
        final ProcessoSeletivo other = (ProcessoSeletivo) obj;
        if (!Objects.equals(this.cod_proc, other.cod_proc)) {
            return false;
        }
        if (!Objects.equals(this.vaga, other.vaga)) {
            return false;
        }
        if (!Objects.equals(this.prova, other.prova)) {
            return false;
        }
        if (!Objects.equals(this.participante, other.participante)) {
            return false;
        }
        if (!Objects.equals(this.dat_ini, other.dat_ini)) {
            return false;
        }
        if (!Objects.equals(this.dat_fim, other.dat_fim)) {
            return false;
        }
        if (!Objects.equals(this.nom_proc, other.nom_proc)) {
            return false;
        }
        if (!Objects.equals(this.desc_proc, other.desc_proc)) {
            return false;
        }
        if (!Objects.equals(this.nro_vagas, other.nro_vagas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProcessoSeletivo{" + "cod_proc=" + cod_proc + ", vaga=" + vaga + ", prova=" + prova + ", participante=" + participante + ", dat_ini=" + dat_ini + ", dat_fim=" + dat_fim + ", nom_proc=" + nom_proc + ", desc_proc=" + desc_proc + ", nro_vagas=" + nro_vagas + '}';
    }
    
}