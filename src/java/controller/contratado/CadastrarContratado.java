/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.contratado;

import DAO.ContratadoDAO;
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
import model.Contratado;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "CadastrarContratado", urlPatterns = {"/CadastrarContratado"})
public class CadastrarContratado extends HttpServlet {

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

        Contratado oContratado = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {

            oContratado = new Contratado();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setSizeMax(50 * 1024 * 1024);

            List items = upload.parseRequest(request);
            Iterator it = items.iterator();

            while (it.hasNext()) {
                FileItem fileItem = (FileItem) it.next();
                if (!fileItem.isFormField()) {
                    oContratado.setFotoContratado(fileItem.getInputStream());
                    oContratado.setFileInt((int) fileItem.getSize());
                } else {
                    String dados = fileItem.getFieldName();
                    if (dados.equals("nomepessoa")) {
                        oContratado.setNomePessoa(fileItem.getString());
                    } else if (dados.equals("emailpessoa")) {
                        oContratado.setEmailPessoa(fileItem.getString());
                    } else if (dados.equals("senhapessoa")) {
                        oContratado.setSenhaPessoa(fileItem.getString());
                    } else if (dados.equals("cpfpessoa")) {
                        oContratado.setCpfPessoa(fileItem.getString());
                    } else if (dados.equals("cnhcontratado")) {
                        oContratado.setCnhContratado(fileItem.getString());
                    } else if (dados.equals("telefonepessoa")) {
                        oContratado.setTelefonePessoa(fileItem.getString());
                    } else if (dados.equals("enderecopessoa")) {
                        oContratado.setEnderecoPessoa(fileItem.getString());
                    } else if (dados.equals("idcidade")) {
                        oContratado.setCidade(new Cidade(Integer.parseInt(fileItem.getString())));
                    } else if (dados.equals("idpessoa")) {
                        if (!fileItem.getString().equals("")) {
                            oContratado.setIdPessoa(Integer.parseInt(fileItem.getString()));
                        } else {
                            oContratado.setIdPessoa(null);
                        }
                    }
                }
            }
        }

        String mensagem = null;
        oContratado.setTipoPessoa("M");
        try {
            GenericDAO dao = new ContratadoDAO();

            if (oContratado.getIdPessoa() == null) {
                if (dao.cadastrar(oContratado)) {
                    mensagem = "Contratado " + oContratado.getNomePessoa() + ", cadastrado com sucesso!";
                } else {
                    mensagem = "Problema ao cadastrar Contratado!" + " Verifique os dados e tente novamente !";
                }
            } else {
                if (dao.alterar(oContratado)) {
                    mensagem = "Contratado " + oContratado.getNomePessoa() + ", alterado com sucesso!";
              
                } else {
                    mensagem = "Problema ao alterar Contratado!" + " Verifique os dados e tente novamente !";
                }
            }

            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("DadosContratado").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao Salvar Contratado! Erro: " + ex.getMessage());
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
            Logger.getLogger(CadastrarContratado.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarContratado.class.getName()).log(Level.SEVERE, null, ex);
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
