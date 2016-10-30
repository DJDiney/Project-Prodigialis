
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


public class Prova {
    
    private Integer cod_prova;
    private EmpresaProva empresa;
    private Date dat_prova;
    private byte[] arq_prova;
    private byte[] arq_edital;
    private String path_prova;
    private String path_edital;
    private String desc_prova;
    
    public Prova () {}

    public Prova(Integer cod_prova, EmpresaProva empresa, Date dat_prova, byte[] arq_prova, byte[] arq_edital, String path_prova, String path_edital, String desc_prova) {
        this.cod_prova = cod_prova;
        this.empresa = empresa;
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

    public EmpresaProva getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaProva empresa) {
        this.empresa = empresa;
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
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cod_prova);
        hash = 97 * hash + Objects.hashCode(this.empresa);
        hash = 97 * hash + Objects.hashCode(this.dat_prova);
        hash = 97 * hash + Arrays.hashCode(this.arq_prova);
        hash = 97 * hash + Arrays.hashCode(this.arq_edital);
        hash = 97 * hash + Objects.hashCode(this.path_prova);
        hash = 97 * hash + Objects.hashCode(this.path_edital);
        hash = 97 * hash + Objects.hashCode(this.desc_prova);
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
        final Prova other = (Prova) obj;
        if (!Objects.equals(this.cod_prova, other.cod_prova)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
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

    @Override
    public String toString() {
        return "Prova{" + "cod_prova=" + cod_prova + ", empresa=" + empresa + ", dat_prova=" + dat_prova + ", arq_prova=" + arq_prova + ", arq_edital=" + arq_edital + ", path_prova=" + path_prova + ", path_edital=" + path_edital + ", desc_prova=" + desc_prova + '}';
    }
    
}