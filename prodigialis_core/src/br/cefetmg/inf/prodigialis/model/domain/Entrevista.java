
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Date;
import java.util.Objects;


public class Entrevista {
    
    private Candidato candidato;
    private Funcionario funcionario;
    private long cod_cargoPretendido;
    private Long codigoEntrevista;
    private Date data;
    private boolean aprovacao;
    private String descricaoEntrevista;
    
    public Entrevista () {}

    public Entrevista(Candidato candidato, Funcionario funcionario, long cod_cargoPretendido, Long codigoEntrevista, Date data, boolean aprovacao, String descricaoEntrevista) {
        this.candidato = candidato;
        this.funcionario = funcionario;
        this.cod_cargoPretendido = cod_cargoPretendido;
        this.codigoEntrevista = codigoEntrevista;
        this.data = data;
        this.aprovacao = aprovacao;
        this.descricaoEntrevista = descricaoEntrevista;
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
        return codigoEntrevista;
    }

    public void setCod_ent(Long codigoEntrevista) {
        this.codigoEntrevista = codigoEntrevista;
    }

    public Date getDat_ent() {
        return data;
    }

    public void setDat_ent(Date data) {
        this.data = data;
    }

    public boolean isEst_aprov() {
        return aprovacao;
    }

    public void setEst_aprov(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public String getDesc_ent() {
        return descricaoEntrevista;
    }

    public void setDesc_ent(String descricaoEntrevista) {
        this.descricaoEntrevista = descricaoEntrevista;
    }

    public long getCod_cargoPretendido() {
        return cod_cargoPretendido;
    }

    public void setCod_cargoPretendido(long cod_cargoPretendido) {
        this.cod_cargoPretendido = cod_cargoPretendido;
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
        if (!Objects.equals(this.cod_cargoPretendido, other.cod_cargoPretendido)) {
            return false;
        }
        if (!Objects.equals(this.codigoEntrevista, other.codigoEntrevista)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (this.aprovacao != other.aprovacao) {
            return false;
        }
        if (!Objects.equals(this.descricaoEntrevista, other.descricaoEntrevista)) {
            return false;
        }
        return true;
    }

}