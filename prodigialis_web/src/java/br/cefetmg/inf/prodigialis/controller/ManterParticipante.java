/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;

import br.cefetmg.inf.prodigialis.model.dao.impl.CandidatoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Cliente
 */
public class ManterParticipante {
    public static String execute(HttpServletRequest request){
        ParticipanteDAO dao = new ParticipanteDAO();
        CandidatoDAO  cand= new CandidatoDAO();
        String jsp = "";
        try {
            if(dao.consultarPorProc(cand.consultarPorEmail((String)request.getParameter("email")).getCpf(),Integer.parseInt((String)request.getParameter("cod"))) == null){
                Participante par = new Participante();
                par.setCodProcesso(Integer.parseInt(request.getParameter("cod")));
                par.setCandidato(cand.consultarPorEmail((String)request.getParameter("email")));
                par.setEst_aprov(false);
                if(dao.inserir(par)){

                }
                jsp = "/MenuUser.jsp";
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsp;
    }
}
