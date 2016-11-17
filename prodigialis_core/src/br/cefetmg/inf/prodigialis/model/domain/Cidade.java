
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;

public class Cidade {
    
    private String ibge;
    private String uf;
    private String nom_cid;
    
    
    public Cidade () {}

    public Cidade(String ibge, String uf, String nom_cid) {
        this.ibge = ibge;
        this.uf = uf;
        this.nom_cid = nom_cid;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNom_cid() {
        return nom_cid;
    }

    public void setNom_cid(String nom_cid) {
        this.nom_cid = nom_cid;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.ibge != other.ibge) {
            return false;
        }
        if (this.uf != other.uf) {
            return false;
        }
        return Objects.equals(this.nom_cid, other.nom_cid);
    }
      
}