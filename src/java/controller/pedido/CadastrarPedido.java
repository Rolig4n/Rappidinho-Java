/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pedido;


import DAO.PedidoDAO;
import DAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contratado;
import model.Pedido;
import model.Pessoa;
import model.Produto;
import model.Rota;
import utils.Conversoes;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "CadastrarPedido", urlPatterns = {"/CadastrarPedido"})
public class CadastrarPedido extends HttpServlet {

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
        response.setContentType("text/html;charset=iso-8859-1");
        
        String mensagem = null;
        Pedido oPedido = new Pedido();
        oPedido.setDataPedido(oPedido.getDataPedido());
        oPedido.setLatDestinoPedido(Double.parseDouble(request.getParameter("latdestinopedido")));
        oPedido.setLngDestinoPedido(Double.parseDouble(request.getParameter("lngdestinopedido")));
        oPedido.setStatusPedido("A");
        oPedido.setProduto(new Produto(Integer.parseInt(request.getParameter("idproduto"))));
        oPedido.setPessoa(new Pessoa(Integer.parseInt(request.getParameter("idpessoa"))));
        oPedido.setContratado(new Contratado(Integer.parseInt(request.getParameter("idcontratado"))));
        oPedido.setRota(new Rota(Integer.parseInt(request.getParameter("idrota"))));
        
        try {
            GenericDAO dao = (GenericDAO) new PedidoDAO();
            if(request.getParameter("idpedido").equals("")){
            if (dao.cadastrar(oPedido)) {
                mensagem = "Pedido cadastrado com sucesso!";
            } else {
                mensagem = "Problema ao cadastrar Pedido. Verifique os dados informados e tente novamente";
            }
            }else{
              oPedido.setIdPedido(Integer.parseInt(request.getParameter("idpedido")));
              if(dao.alterar(oPedido)){
                  mensagem = "Pedido "+ oPedido.getStatusPedido() + "Alterado com sucesso !";
              }else {
                  mensagem = "Problemas ao alterar Pedido";
              }
            }

            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarPedido").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Usuario! Erro: " + ex.getMessage());
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
