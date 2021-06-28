/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.veiculo;

import DAO.GenericDAO;
import DAO.VeiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contratado;
import model.Pessoa;
import model.Veiculo;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "CadastrarVeiculo", urlPatterns = {"/CadastrarVeiculo"})
public class CadastrarVeiculo extends HttpServlet {

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
        Veiculo oVeiculo = new Veiculo();
        oVeiculo.setNomeVeiculo(request.getParameter("nomeveiculo"));
        oVeiculo.setRenavamVeiculo(request.getParameter("renavamveiculo"));
        oVeiculo.setTipoVeiculo(request.getParameter("tipoveiculo"));
        oVeiculo.setContratado(new Contratado(Integer.parseInt(request.getParameter("idpessoa"))));

        try {
            GenericDAO dao = new VeiculoDAO();
            if (request.getParameter("idveiculo").equals("")) {
                if (dao.cadastrar(oVeiculo)) {
                    mensagem = "Veiculo " + oVeiculo.getNomeVeiculo() + " cadastrado com Sucesso !";
                }else
                mensagem = "Problemas ao cadastrar o Veiculo, Tente novamente reveja os dados inseridos";
            } else {
                oVeiculo.setIdVeiculo(Integer.parseInt(request.getParameter("idveiculo")));
                if (dao.alterar(oVeiculo)) {
                    mensagem = "Veículo " + oVeiculo.getNomeVeiculo() + ", alterado com Sucesso !";
                } else 
                    mensagem = "Problemas ao alterar os dados do Veiculo, Tente novamente reveja os dados inseridos";
            }
            
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarVeiculo").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no servlet ao Cadastrar Veiculo erro "+ex.getMessage());
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
