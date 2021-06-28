/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.produto;

import DAO.ProdutoDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "MostrarFotoProduto", urlPatterns = {"/MostrarFotoProduto"})
public class MostrarFotoProduto extends HttpServlet {

    private static final int BYTES_DOWNLOAD = 1024;
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
        int idProduto = Integer.parseInt(request.getParameter("idproduto"));

        try {
            ProdutoDAO dao = new ProdutoDAO();
            Produto oProduto = dao.mostrarFoto(idProduto);

            InputStream inputStream = oProduto.getFotoProduto();
            OutputStream outputStream = response.getOutputStream();

            response.setHeader("Content-Disposition", "attachment; filename = " + oProduto.getIdProduto() + ".jpg");

            int read = 0;
            final byte[] bytes = new byte[BYTES_DOWNLOAD];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
                outputStream.flush();
            }
        } catch (Exception ex) {
            System.out.println("Problema ao carregar foto do produto! Erro: " + ex.getMessage());
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
