/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;

import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class RemoveParticipante {
    public static void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int nro = (Integer.parseInt(request.getParameter("id")));
                ParticipanteDAO par = new ParticipanteDAO();
                try {
                    System.out.println(nro);
                    if(par.excluir(nro)){
                        response.getWriter().write("Sucesso");
                    }else response.getWriter().write("ERRO");
                    
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
}
