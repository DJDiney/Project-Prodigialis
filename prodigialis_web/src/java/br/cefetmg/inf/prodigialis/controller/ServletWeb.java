/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;

import br.cefetmg.inf.prodigialis.model.dao.impl.CandidatoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.CargoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Candidato;
import br.cefetmg.inf.prodigialis.model.domain.Cargo;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
        else if (acao.equals("enviaCur")){
            jsp = ManterParticipante.execute(request);
        }else if (acao.equals("criaProcesso")){
            ProcessoSeletivoDAO proc = new ProcessoSeletivoDAO();
            ArrayList<String> specs = new ArrayList<String>();       
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date data = new Date();   
            ProcessoSeletivo processo;
            CargoDAO cargoDAO = new CargoDAO();
            Cargo cargo;
            String codUsuario = "";
            codUsuario += (char)request.getSession().getAttribute("codUsuario");
            try {
                Date data_ini = df.parse(request.getParameter("data_ini")); 
                if(Integer.parseInt(codUsuario) == 1){
                    int aux=0;
                    if(data_ini.after(data) || data_ini.equals(data)){ 
                        if(cargoDAO.consultarPorNome(request.getParameter("tipo_vaga"))== null){
                            cargo = new Cargo(request.getParameter("tipo_vaga"),request.getParameter("desc_cargo"));
                            long cod = cargoDAO.inserirComRetorno(cargo);
                        }
                        cargo =cargoDAO.consultarPorNome(request.getParameter("tipo_vaga"));   
                        processo = new ProcessoSeletivo(df.parse(request.getParameter("data_ini")),df.parse(request.getParameter("data_fim")),request.getParameter("nome_proc"),request.getParameter("desc"),null,Integer.parseInt(request.getParameter("n_vagas")),true,cargo);
                    }else{ 
                        if(cargoDAO.consultarPorNome(request.getParameter("tipo_vaga"))== null){
                            cargo = new Cargo(request.getParameter("tipo_vaga"),request.getParameter("desc_cargo"));
                            long cod = cargoDAO.inserirComRetorno(cargo);
                        }
                        cargo =cargoDAO.consultarPorNome(request.getParameter("tipo_vaga"));   
                        processo = new ProcessoSeletivo(df.parse(request.getParameter("data_ini")),df.parse(request.getParameter("data_fim")),request.getParameter("nome_proc"),request.getParameter("desc"),null,Integer.parseInt(request.getParameter("n_vagas")),false,cargo);
                    }
                    jsp = "/MenuFunc.jsp";
                }else if(Integer.parseInt(codUsuario) == 0){
                    int aux=0;
                    if(data_ini.after(data) || data_ini.equals(data)){ 
                        if(cargoDAO.consultarPorNome(request.getParameter("tipo_vaga"))== null){
                            cargo = new Cargo(request.getParameter("tipo_vaga"),request.getParameter("desc_cargo"));
                            long cod = cargoDAO.inserirComRetorno(cargo);
                        }
                        cargo =cargoDAO.consultarPorNome(request.getParameter("tipo_vaga"));   
                        processo = new ProcessoSeletivo(df.parse(request.getParameter("data_ini")),df.parse(request.getParameter("data_fim")),request.getParameter("nome_proc"),request.getParameter("desc"),null,Integer.parseInt(request.getParameter("n_vagas")),true,cargo);
                    }else{ 
                        if(cargoDAO.consultarPorNome(request.getParameter("tipo_vaga"))== null){
                            cargo = new Cargo(request.getParameter("tipo_vaga"),request.getParameter("desc_cargo"));
                            long cod = cargoDAO.inserirComRetorno(cargo);
                        }
                        cargo =cargoDAO.consultarPorNome(request.getParameter("tipo_vaga"));   
                        processo = new ProcessoSeletivo(df.parse(request.getParameter("data_ini")),df.parse(request.getParameter("data_fim")),request.getParameter("nome_proc"),request.getParameter("desc"),null,Integer.parseInt(request.getParameter("n_vagas")),false,cargo);
                        proc.inserir(processo);
                    }
                    jsp = "/MenuFuncAdm.jsp";
                }
        } catch (PersistenciaException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
            

        //Redirecionando pagina
        //RequestDispatcher rd = getServletContext().getRequestDispatcher(jsp);
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

}
