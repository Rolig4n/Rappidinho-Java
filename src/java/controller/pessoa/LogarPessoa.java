/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pessoa;

import DAO.ContratadoDAO;
import DAO.ContratanteDAO;
import DAO.GenericDAO;
import DAO.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Contratado;
import model.Contratante;
import model.Pessoa;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "LogarPessoa", urlPatterns = {"/LogarPessoa"})
public class LogarPessoa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if (request.getParameter("acao").equalsIgnoreCase("logar")) {

            if (!request.getParameter("emailpessoa").equals("") && !request.getParameter("senhapessoa").equals("")) {

                Pessoa oPessoa = null;
     
                
                try {
                    PessoaDAO dao = new PessoaDAO();
                    oPessoa = dao.logarPessoa(request.getParameter("emailpessoa"), request.getParameter("senhapessoa"));
                    
                    GenericDAO daocontratado = new ContratadoDAO();
                    
                    

                    if (oPessoa != null) {
                        int idPessoa = oPessoa.getIdPessoa();
                        
                        HttpSession session = request.getSession(true);
                        session.setMaxInactiveInterval(300);                        
                        session.setAttribute("pessoa", oPessoa);
                        session.setAttribute("saudacao", "Seja bem-vindo, " + oPessoa.getNomePessoa());
                        
                        if (oPessoa.getTipoPessoa().equalsIgnoreCase("A")){
                            request.setAttribute("tipo", oPessoa.getTipoPessoa());
                            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                        } else if (oPessoa.getTipoPessoa().equalsIgnoreCase("C")){
                            Contratante oContratante = null;
                            try{
                                GenericDAO daoContratante = new ContratanteDAO();
                                oContratante = (Contratante) daoContratante.carregar(oPessoa.getIdPessoa());
                                session.setAttribute("contratante", oContratante);
                            } catch (Exception ex){
                                System.out.println("Problemas ao carregar Contratante! Erro: " + ex.getMessage());
                                ex.printStackTrace();
                            }
                            
                            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                        } else if (oPessoa.getTipoPessoa().equalsIgnoreCase("M")){
                             Contratado oContratado = null;
                            try{
                                GenericDAO daoContratado = new ContratadoDAO();
                                oContratado = (Contratado) daoContratado.carregar(oPessoa.getIdPessoa());
                                session.setAttribute("contratado", oContratado);
                           
                            } catch (Exception ex){
                                System.out.println("Problemas ao carregar Contratado! Erro: " + ex.getMessage());
                                ex.printStackTrace();
                            }
                            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                        } else {
                            mensagemErro(request, response);
                        }
                        
                    } else {
                        mensagemErro(request, response);
                    }

                } catch (Exception ex) {
                    System.out.println("Problemas ao logar Pessoa! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }

            } else {
                mensagemErro(request, response);
            }

        } else if (request.getParameter("acao").equalsIgnoreCase("logout")) {
            
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("index.jsp");

        } else {
            response.sendRedirect("index.jsp");
        }

    }

    private void mensagemErro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("erro", "Email e/ou Senha inválidos!");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
