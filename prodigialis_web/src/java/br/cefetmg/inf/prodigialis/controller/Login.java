/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.cefetmg.inf.prodigialis.model.service.impl.ManterFuncionario;
import br.cefetmg.inf.prodigialis.model.domain.Funcionario;

/**
 *
 * @author Cliente
 */
public class Login {
    public static String execute(HttpServletRequest request) {

        String jsp = "";

        try {
            String nome = request.getParameter("email");
            String senha = request.getParameter("password");
            
            System.out.println(nome);
            System.out.println(senha);

            ManterFuncionario manterFuncionario = new ManterFuncionario();
            Funcionario usr = manterFuncionario.getFuncLogin(nome, senha);

            if (usr == null) {
                System.out.println("Usuario nao encontrado");
                String erro = "Usuario nao encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            } else {
                request.getSession().setAttribute("codUsuario", usr.getIdt_perfil());
                request.getSession().setAttribute("email", request.getParameter("email"));
                if(usr.getIdt_perfil() == '1')jsp = "/MenuFunc.jsp";
                else if(usr.getIdt_perfil() == '0')jsp = "/MenuUser.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static void validarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Character codUsuario = (Character) request.getSession().getAttribute("codUsuario");
        String jsp = "";
        if (codUsuario == null) {
            jsp = "/index.jsp";
            //Redirecionando pagina
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }
    
    public static String terminaSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("codUsuario", null);
        String jsp = "/index.jsp";
        return jsp;
    }
}
