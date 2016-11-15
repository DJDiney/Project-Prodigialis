
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


public class Prova {
    
    private Integer cod_prova;
    private Date dat_prova;
    private byte[] arq_prova;
    private byte[] arq_edital;
    private String path_prova;
    private String path_edital;
    private String desc_prova;
    private String path_gabarito;
    private byte[] arq_gabarito;
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public Prova () {}

    public Prova(Integer cod_prova, Date dat_prova, byte[] arq_prova, byte[] arq_edital, String path_prova, String path_edital, String desc_prova) {
        this.cod_prova = cod_prova;
        this.dat_prova = dat_prova;
        this.arq_prova = arq_prova;
        this.arq_edital = arq_edital;
        this.path_prova = path_prova;
        this.path_edital = path_edital;
        this.desc_prova = desc_prova;
    }
    
    public Integer getCod_prova() {
        return cod_prova;
    }

    public void setCod_prova(Integer cod_prova) {
        this.cod_prova = cod_prova;
    }

    public Date getDat_prova() {
        return dat_prova;
    }

    public void setDat_prova(Date dat_prova) {
        this.dat_prova = dat_prova;
    }

    public byte[] getArq_prova() {
        return arq_prova;
    }

    public void setArq_prova(byte[] arq_prova) {
        this.arq_prova = arq_prova;
    }

    public byte[] getArq_edital() {
        return arq_edital;
    }

    public void setArq_edital(byte[] arq_edital) {
        this.arq_edital = arq_edital;
    }

    public String getDesc_prova() {
        return desc_prova;
    }

    public void setDesc_prova(String desc_prova) {
        this.desc_prova = desc_prova;
    }

    public String getPath_prova() {
        return path_prova;
    }

    public void setPath_prova(String path_prova) {
        this.path_prova = path_prova;
    }

    public String getPath_edital() {
        return path_edital;
    }

    public void setPath_edital(String path_edital) {
        this.path_edital = path_edital;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prova other = (Prova) obj;
        if (!Objects.equals(this.cod_prova, other.cod_prova)) {
            return false;
        }
        if (!Objects.equals(this.dat_prova, other.dat_prova)) {
            return false;
        }
        if (!Arrays.equals(this.arq_prova, other.arq_prova)) {
            return false;
        }
        if (!Arrays.equals(this.arq_edital, other.arq_edital)) {
            return false;
        }
        if (!Objects.equals(this.path_prova, other.path_prova)) {
            return false;
        }
        if (!Objects.equals(this.path_edital, other.path_edital)) {
            return false;
        }
        if (!Objects.equals(this.desc_prova, other.desc_prova)) {
            return false;
        }
        return true;
    }
    
}