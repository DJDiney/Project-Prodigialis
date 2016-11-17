package br.cefetmg.inf.prodigialis.model.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Estado {
    
    private String uf;
    private String nom_est;
    private ArrayList<Cidade> cidades;

    public Estado () {}

    public Estado (String uf, String nom_est, ArrayList<Cidade> cidades) {
        this.uf = uf;
        this.nom_est = nom_est;
        this.cidades = cidades;
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
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