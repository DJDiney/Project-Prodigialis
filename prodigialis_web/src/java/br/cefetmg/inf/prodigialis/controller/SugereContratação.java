/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;

import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class SugereContratação {
    public static void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nro = (request.getParameter("id"));
        ParticipanteDAO par = new ParticipanteDAO();
        try {
            System.out.println(nro);
            Participante part = par.consultarPorId(Integer.parseInt(nro));
            if(part!= null){
                par.aprovar(part.getNroInscricao());
                response.getWriter().write("Sucesso");
            }else response.getWriter().write("ERRO");


        } catch (PersistenciaException ex) {
            ex.printStackTrace();
        }
    }
}
