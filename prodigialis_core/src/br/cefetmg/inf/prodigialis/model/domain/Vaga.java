
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;

public class Vaga {
    
    private Long cod_cargo;
    private String nom_cargo;
    private String desc_cargo;
    
    public Vaga () {}

    public Vaga(Long cod_cargo, String nom_cargo, String desc_cargo) {
        this.cod_cargo = cod_cargo;
        this.nom_cargo = nom_cargo;
        this.desc_cargo = desc_cargo;
    }

    public Long getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(Long cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public String getNom_cargo() {
        return nom_cargo;
    }

    public void setNom_cargo(String nom_cargo) {
        this.nom_cargo = nom_cargo;
    }

    public String getDesc_cargo() {
        return desc_cargo;
    }

    public void setDesc_cargo(String desc_cargo) {
        this.desc_cargo = desc_cargo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.cod_cargo);
        hash = 13 * hash + Objects.hashCode(this.nom_cargo);
        hash = 13 * hash + Objects.hashCode(this.desc_cargo);
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
        final Vaga other = (Vaga) obj;
        if (!Objects.equals(this.cod_cargo, other.cod_cargo)) {
            return false;
        }
        if (!Objects.equals(this.nom_cargo, other.nom_cargo)) {
            return false;
        }
        if (!Objects.equals(this.desc_cargo, other.desc_cargo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vaga{" + "cod_cargo=" + cod_cargo + ", nom_cargo=" + nom_cargo + ", desc_cargo=" + desc_cargo + '}';
    }
    
}