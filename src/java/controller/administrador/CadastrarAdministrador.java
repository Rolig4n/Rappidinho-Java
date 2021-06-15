/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.administrador;

import DAO.AdministradorDAO;
import DAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Cidade;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "CadastrarAdministrador", urlPatterns = {"/CadastrarAdministrador"})
public class CadastrarAdministrador extends HttpServlet {

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

        String mensagem = null;
        Administrador oAdmin = null;
        oAdmin = new Administrador();
        oAdmin.setNomePessoa(request.getParameter("nomepessoa"));
        oAdmin.setEmailPessoa(request.getParameter("emailpessoa"));
        oAdmin.setSenhaPessoa(request.getParameter("senhapessoa"));
        oAdmin.setCpfPessoa(request.getParameter("cpfpessoa"));
        oAdmin.setRgAdministrador(request.getParameter("rgadministrador"));
        oAdmin.setEnderecoPessoa(request.getParameter("enderecopessoa"));
        oAdmin.setTelefonePessoa(request.getParameter("telefonepessoa"));
        oAdmin.setCidade(new Cidade(Integer.parseInt(request.getParameter("idcidade"))));
        oAdmin.setTipoPessoa("A");

        try {
            GenericDAO dao = new AdministradorDAO();
  
            if(request.getParameter("idpessoa").equals("")) {
                oAdmin.setIdPessoa(null);
                if (dao.cadastrar(oAdmin)) {
                    mensagem = "Admin " + oAdmin.getNomePessoa() + ", cadastrado com Sucesso!";
                } else {
                    mensagem = "Erro ao Cadastrar seus dados, tente novamente!";
                }
            } else {
                oAdmin.setIdPessoa(Integer.parseInt(request.getParameter("idpessoa")));
                if (dao.alterar(oAdmin)) {
                    mensagem = "Admin " + oAdmin.getNomePessoa() + ", alterado os dados com Sucesso!";
                } else {
                    mensagem = "Erro ao alterar seus dados, tente novamente!";
                }
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarAdministrador").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas na servlet ao Cadastrar Administrador "+ex.getMessage());
            ex.printStackTrace();
        }

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
