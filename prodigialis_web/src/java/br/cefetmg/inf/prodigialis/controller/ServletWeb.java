/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;

import br.cefetmg.inf.prodigialis.model.dao.impl.CandidatoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class ServletWeb extends HttpServlet {

   private String jsp = "";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        
        if(acao.equals("Logar")){
            jsp = Login.execute(request);
        }else if (acao.equals("Deslogar"))
            jsp = Login.terminaSessao(request,response);
        else if(acao.equals("dadosProcesso")){
            int  id = Integer.parseInt(request.getParameter("id"));
            if(id != 0){
                ProcessoSeletivoDAO dao = new ProcessoSeletivoDAO();
                try {
                    ProcessoSeletivo proc = dao.consultarPorId(id);
                    request.getSession().setAttribute("nome", proc.getNome());
                    request.getSession().setAttribute("vaga", proc.getCargoOferecido().getNom_cargo());
                    request.getSession().setAttribute("nvaga", proc.getNroVagas());
                    request.getSession().setAttribute("datin", proc.getDataInicio());
                    request.getSession().setAttribute("datfim", proc.getDataFinal());
                    response.getWriter().write("sucesso");
                    
                } catch (PersistenciaException ex) {
                    ex.printStackTrace();
                }
            }
        }else if (acao.equals("enviaCur")){
            ParticipanteDAO dao = new ParticipanteDAO();
            CandidatoDAO  cand= new CandidatoDAO();
            try {
                if(dao.consultarPorProc(cand.consultarPorEmail((String)request.getParameter("email")).getCpf(),Integer.parseInt(request.getParameter("cod"))) == null){
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
        }
            

        //Redirecionando pagina
        //RequestDispatcher rd = getServletContext().getRequestDispatcher(jsp);
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

}
