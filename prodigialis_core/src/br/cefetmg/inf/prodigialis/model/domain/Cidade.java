
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;

public class Cidade {
    
    private char ibge;
    private Estado estado;
    private String nom_cid;
    
    
    public Cidade () {}

    public Cidade(char ibge, Estado estado, String nom_cid) {
        this.ibge = ibge;
        this.estado = estado;
        this.nom_cid = nom_cid;
    }

    public char getIbge() {
        return ibge;
    }

    public void setIbge(char ibge) {
        this.ibge = ibge;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNom_cid() {
        return nom_cid;
    }

    public void setNom_cid(String nom_cid) {
        this.nom_cid = nom_cid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.ibge;
        hash = 79 * hash + Objects.hashCode(this.estado);
        hash = 79 * hash + Objects.hashCode(this.nom_cid);
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
        final Cidade other = (Cidade) obj;
        if (this.ibge != other.ibge) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return Objects.equals(this.nom_cid, other.nom_cid);
    }

    @Override
    public String toString() {
        return "Cidade{" + "ibge=" + ibge + ", estado=" + estado + ", nom_cid=" + nom_cid + '}';
    }
      
}