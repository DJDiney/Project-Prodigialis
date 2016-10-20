
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;


public class Funcionario {
    
    private String inss;
    private String ibge;
    private String nom_fun;
    private String email;
    private String password;
    private char idt_perfil;
    private String tel_fixo;
    private String tel_movel;
    
    public Funcionario () {}
    
    public Funcionario(String inss, String ibge, String nom_fun, String email, String password, char idt_perfil, String tel_fixo, String tel_movel, char nro_end) {
        this.inss = inss;
        this.ibge = ibge;
        this.nom_fun = nom_fun;
        this.email = email;
        this.password = password;
        this.idt_perfil = idt_perfil;
        this.tel_fixo = tel_fixo;
        this.tel_movel = tel_movel;
    }

    public String getInss() {
        return inss;
    }

    public void setInss(String inss) {
        this.inss = inss;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String cep) {
        this.ibge = cep;
    }

    public String getNom_fun() {
        return nom_fun;
    }

    public void setNom_fun(String nom_fun) {
        this.nom_fun = nom_fun;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getIdt_perfil() {
        return idt_perfil;
    }

    public void setIdt_perfil(char idt_perfil) {
        this.idt_perfil = idt_perfil;
    }

    public String getTel_fixo() {
        return tel_fixo;
    }

    public void setTel_fixo(String tel_fixo) {
        this.tel_fixo = tel_fixo;
    }

    public String getTel_movel() {
        return tel_movel;
    }

    public void setTel_movel(String tel_movel) {
        this.tel_movel = tel_movel;
    }

    
}