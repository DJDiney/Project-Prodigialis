
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;

public class EmpresaProva {
    
    private char cnpj;
    private String nom_fant;
    
    public EmpresaProva () {}

    public EmpresaProva(char cnpj, String nom_fant) {
        this.cnpj = cnpj;
        this.nom_fant = nom_fant;
    }

    public char getCnpj() {
        return cnpj;
    }

    public void setCnpj(char cnpj) {
        this.cnpj = cnpj;
    }

    public String getNom_fant() {
        return nom_fant;
    }

    public void setNom_fant(String nom_fant) {
        this.nom_fant = nom_fant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.cnpj;
        hash = 37 * hash + Objects.hashCode(this.nom_fant);
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
        final EmpresaProva other = (EmpresaProva) obj;
        if (this.cnpj != other.cnpj) {
            return false;
        }
        if (!Objects.equals(this.nom_fant, other.nom_fant)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpresaProva{" + "cnpj=" + cnpj + ", nom_fant=" + nom_fant + '}';
    }
    
}