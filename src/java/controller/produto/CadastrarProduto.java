/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.produto;

import DAO.ProdutoDAO;
import DAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.Produto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "CadastrarProduto", urlPatterns = {"/CadastrarProduto"})
public class CadastrarProduto extends HttpServlet {

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
            throws ServletException, IOException, FileUploadException {
        response.setContentType("text/html;charset=iso-8859-1");
        
        Produto oProduto = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {

            oProduto = new Produto();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setSizeMax(50 * 1024 * 1024);

            List items = upload.parseRequest(request);
            Iterator it = items.iterator();

                    
         while (it.hasNext()) {
                FileItem fileItem = (FileItem) it.next();
                if (!fileItem.isFormField()) {
                    oProduto.setFotoProduto(fileItem.getInputStream());
                    oProduto.setFileInt((int) fileItem.getSize());
                } else {
                    String dados = fileItem.getFieldName();
                    if (dados.equals("nomeproduto")) {
                        oProduto.setNomeProduto(fileItem.getString());
                    } else if (dados.equals("descricaoproduto")) {
                        oProduto.setDescricaoProduto(fileItem.getString());
                    } else if (dados.equals("idpessoa")) {
                        oProduto.setPessoa(new Pessoa(Integer.parseInt(fileItem.getString())));
                    } else if (dados.equals("idproduto")) {
                        if (!fileItem.getString().equals("")) {
                            oProduto.setIdProduto(Integer.parseInt(fileItem.getString()));
                        } else {
                            oProduto.setIdProduto(null);
                        }
                    }
                }
            }
        }
        String mensagem = null;
        try {
            GenericDAO dao = new ProdutoDAO();
           
            if (oProduto.getIdProduto() == null) {
                if (dao.cadastrar(oProduto)) {
                    mensagem = "Contratado " + oProduto.getNomeProduto()+ ", cadastrado com sucesso!";
                } else {
                    mensagem = "Problema ao cadastrar Contratado!" + " Verifique os dados e tente novamente !";
                }
            } else {
                if (dao.alterar(oProduto)) {
                    mensagem = "Contratado " + oProduto.getNomeProduto()+ ", alterado com sucesso!";
                } else {
                    mensagem = "Problema ao alterar Contratado!" + " Verifique os dados e tente novamente !";
                }
            }
            
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarProduto").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Veiculo! Erro: " + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
