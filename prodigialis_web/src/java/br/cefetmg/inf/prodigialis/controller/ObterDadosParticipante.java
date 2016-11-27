/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;

import br.cefetmg.inf.prodigialis.model.dao.impl.CurriculoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
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
public class ObterDadosParticipante {
    public static void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String jsp ="";
            int  id = Integer.parseInt(request.getParameter("id"));
            if(id != 0){
                CurriculoDAO cur = new CurriculoDAO();
                ParticipanteDAO par = new ParticipanteDAO();
                try {
                    Participante part = par.consultarPorId(id);
                    ArrayList<String> lista = new ArrayList<String>();
                    lista.add(part.getCandidato().getNom_cand());
                    lista.add(part.getCandidato().getEmail());
                    lista.add(part.getCandidato().getTel_movel());
                    lista.add(part.getCandidato().getCurriculo().getCod_cur().toString());
                    String json = new Gson().toJson(lista);
                    
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                    
                    
                } catch (PersistenciaException ex) {
                    ex.printStackTrace();
                }
            }
    }
}
