/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.contratante;

import DAO.ContratanteDAO;
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
import model.Cidade;
import model.Contratante;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "CadastrarContratante", urlPatterns = {"/CadastrarContratante"})
public class CadastrarContratante extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        Contratante oContratante = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {

            oContratante = new Contratante();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setSizeMax(50 * 1024 * 1024);

            List items = upload.parseRequest(request);
            Iterator it = items.iterator();

            while (it.hasNext()) {
                FileItem fileItem = (FileItem) it.next();
                if (!fileItem.isFormField()) {
                    oContratante.setFotoContratante(fileItem.getInputStream());
                    oContratante.setFileInt((int) fileItem.getSize());
                } else {
                    String dados = fileItem.getFieldName();
                    if (dados.equals("nomepessoa")) {
                        oContratante.setNomePessoa(fileItem.getString());
                    } else if (dados.equals("emailpessoa")) {
                        oContratante.setEmailPessoa(fileItem.getString());
                    } else if (dados.equals("senhapessoa")) {
                        oContratante.setSenhaPessoa(fileItem.getString());
                    } else if (dados.equals("cpfpessoa")) {
                        oContratante.setCpfPessoa(fileItem.getString());
                    } else if (dados.equals("telefonepessoa")) {
                        oContratante.setTelefonePessoa(fileItem.getString());
                    } else if (dados.equals("enderecopessoa")) {
                        oContratante.setEnderecoPessoa(fileItem.getString());
                    } else if (dados.equals("idcidade")) {
                        oContratante.setCidade(new Cidade(Integer.parseInt(fileItem.getString())));
                    } else if (dados.equals("idpessoa")) {
                        if (!fileItem.getString().equals("")) {
                            oContratante.setIdPessoa(Integer.parseInt(fileItem.getString()));
                        } else {
                            oContratante.setIdPessoa(null);
                        }
                    }
                }
            }
        }

        String mensagem = null;
        oContratante.setTipoPessoa("C");
        try {
            GenericDAO dao = new ContratanteDAO();

            if (oContratante.getIdPessoa() == null) {
                if (dao.cadastrar(oContratante)) {
                    mensagem = "Contratante " + oContratante.getNomePessoa() + ", cadastrado com sucesso!";
                } else {
                    mensagem = "Problema ao cadastrar Contratante!" + " Verifique os dados e tente novamente !" ;
                }
            } else {
                if (dao.alterar(oContratante)) {
                    mensagem = "Contratante " + oContratante.getNomePessoa() + ", alterado com sucesso!";
                } else {
                    mensagem = "Problema ao alterar Contratante!" + " Verifique os dados e tente novamente !";
                }
            }

            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao Salvar Contratante! Erro: " + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(CadastrarContratante.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarContratante.class.getName()).log(Level.SEVERE, null, ex);
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
