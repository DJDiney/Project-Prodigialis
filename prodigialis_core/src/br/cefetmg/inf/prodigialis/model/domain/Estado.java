package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;

public class Estado {
    
    private char uf;
    private String nom_est;

    public Estado () {}

    public Estado (char uf, String nom_est) {
        this.uf = uf;
        this.nom_est = nom_est;
    }
    
    public char getUf() {
        return uf;
    }

    public void setUf(char uf) {
        this.uf = uf;
    }

    public String getNom_est() {
        return nom_est;
    }

    public void setNom_est(String nom_est) {
        this.nom_est = nom_est;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (this.uf != other.uf) {
            return false;
        }
        return Objects.equals(this.nom_est, other.nom_est);
    }    
}