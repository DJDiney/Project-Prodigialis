/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;

import br.cefetmg.inf.prodigialis.model.dao.impl.CandidatoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.CurriculoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Candidato;
import br.cefetmg.inf.prodigialis.model.domain.Curriculo;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
public class AjaxServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        System.out.println(acao);
        
        if(acao.equals("dadosProcesso")){
            int  id = Integer.parseInt(request.getParameter("id"));
            if(id != 0){
                ProcessoSeletivoDAO dao = new ProcessoSeletivoDAO();
                try {
                    ProcessoSeletivo proc = dao.consultarPorId(id);
                    ArrayList<String> lista = new ArrayList<String>();
                    lista.add(proc.getCodProcesso().toString());
                    lista.add(proc.getCargoOferecido().getNom_cargo());
                    lista.add(proc.getNroVagas().toString());
                    lista.add(proc.getDataInicio().toString());
                    lista.add(proc.getDataFinal().toString());
                    String json = new Gson().toJson(lista);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                    
                    
                } catch (PersistenciaException ex) {
                    ex.printStackTrace();
                }
            }
        }else if(acao.equals("dadosCurriculo")){
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
        }else if(acao.equals("dadosCurriculoEmail")){
            String  mail = (request.getParameter("id"));
                CandidatoDAO par = new CandidatoDAO();
                try {
                    System.out.println(mail);
                    Candidato part = par.consultarPorEmail(mail);
                    if(part!= null){
                        ArrayList<String> lista = new ArrayList<String>();
                        lista.add(part.getNom_cand());
                        lista.add(part.getEmail());
                        lista.add(part.getTel_movel());
                        if(part.getCurriculo()!=null)lista.add(part.getCurriculo().getCod_cur().toString());
                        else{
                            System.out.println("Deu ruim no curiculo email");
                            lista.add("");
                        }
                        String json = new Gson().toJson(lista);

                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(json);
                    }else System.out.println("Deu Ruim");
                    
                    
                } catch (PersistenciaException ex) {
                    ex.printStackTrace();
                }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code."

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}