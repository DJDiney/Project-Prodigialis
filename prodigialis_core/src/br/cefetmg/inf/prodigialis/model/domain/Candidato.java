
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Objects;

public class Candidato {
    
    private String cpf;
    private Curriculo curriculo;
    private String cep;
    private long cod_cargoPretendido;
    private String nom_cand;
    private String email;
    private String password;
    private char idt_perfil;
    private String tel_fixo;
    private String tel_movel;
    
    public Candidato () {}

    public Candidato(String cpf, Curriculo curriculo, String cep, long cod_cargoPretendido, String nom_cand, String email, String password, char idt_perfil, String tel_fixo, String tel_movel) {
        this.cpf = cpf;
        this.curriculo = curriculo;
        this.cep = cep;
        this.cod_cargoPretendido = cod_cargoPretendido;
        this.nom_cand = nom_cand;
        this.email = email;
        this.password = password;
        this.idt_perfil = idt_perfil;
        this.tel_fixo = tel_fixo;
        this.tel_movel = tel_movel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNom_cand() {
        return nom_cand;
    }

    public void setNom_cand(String nom_cand) {
        this.nom_cand = nom_cand;
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

    public long getCod_cargoPretendido() {
        return cod_cargoPretendido;
    }

    public void setCod_cargoPretendido(long cod_cod_cargoPretendido) {
        this.cod_cargoPretendido = cod_cargoPretendido;
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