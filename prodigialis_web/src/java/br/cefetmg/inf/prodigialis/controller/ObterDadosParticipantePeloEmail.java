/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;

import br.cefetmg.inf.prodigialis.model.dao.impl.CandidatoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Candidato;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class ObterDadosParticipantePeloEmail {
    public static void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String jsp = "";
            String  mail = (request.getParameter("id"));
                CandidatoDAO par = new CandidatoDAO();
                try {
                    Candidato part = par.consultarPorEmail(mail);
                    if(part!= null){
                        ArrayList<String> lista = new ArrayList<String>();
                        lista.add(part.getNom_cand());
                        lista.add(part.getEmail());
                        lista.add(part.getTel_movel());
                        if(part.getCurriculo()!=null)lista.add(part.getCurriculo().getCod_cur().toString());
                        else{
                            lista.add("");
                        }
                        String json = new Gson().toJson(lista);

                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(json);
                    }
                    
                    
                } catch (PersistenciaException ex) {
                    ex.printStackTrace();
                }
    }
}
