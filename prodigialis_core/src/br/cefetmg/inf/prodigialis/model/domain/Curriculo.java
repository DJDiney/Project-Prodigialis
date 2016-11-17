
package br.cefetmg.inf.prodigialis.model.domain;

import java.util.Arrays;
import java.util.Objects;

public class Curriculo {
    
    private Long cod_cur;
    private byte[] arq_cur;
    private String path_cur;
    
    public Curriculo () {}

    public Curriculo(byte[] arq_cur, String path_cur) {
        this.cod_cur = cod_cur;
        this.arq_cur = arq_cur;
        this.path_cur = path_cur;
    }

    public Long getCod_cur() {
        return cod_cur;
    }

    public void setCod_cur(Long cod_cur) {
        this.cod_cur = cod_cur;
    }

    public byte[] getArq_cur() {
        return arq_cur;
    }

    public void setArq_cur(byte[] arq_cur) {
        this.arq_cur = arq_cur;
    }

    public String getPath_cur() {
        return path_cur;
    }

    public void setPath_cur(String path_cur) {
        this.path_cur = path_cur;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cod_cur);
        hash = 37 * hash + Arrays.hashCode(this.arq_cur);
        hash = 37 * hash + Objects.hashCode(this.path_cur);
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
        final Curriculo other = (Curriculo) obj;
        if (!Objects.equals(this.cod_cur, other.cod_cur)) {
            return false;
        }
        if (!Arrays.equals(this.arq_cur, other.arq_cur)) {
            return false;
        }
        if (!Objects.equals(this.path_cur, other.path_cur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curriculo{" + "cod_cur=" + cod_cur + ", arq_cur=" + arq_cur + ", path_cur=" + path_cur + '}';
    }
    
}