/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto01.web;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nilo
 */
@WebServlet(name = "Juros_simples", urlPatterns = {"/juros_simples.php"})
public class Juros_simples extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Juros_simples</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Juros Simples</h1>");
            out.println("<h3>A Formula a ser utilizada é <abbr title='JUROS'>J</abbr> = <abbr title='CAPITAL INICIAL'>C</abbr>"
                    + ".<abbr title='TAXA DE JUROS AO MES'>i</abbr>"+".<abbr title='TEMPO'>t</abbr></h3>");
            
            out.println("<div style='border: 2px solid; width: 230px; padding: 10px;'>");
            out.println("<h3>J = Juros a ser descoberto<br/>C = Capital Inicial <br/>i = taxa de juros ao mes<br/>t = tempo da aplicação");
            out.println("</div></br></br>");
            
            out.println("<form>");
            out.println("<fieldset style='width:500px'>");
            out.println("<legend style='font-size:22px;'><b>Informe os seguintes dados:</legend>");
            out.println("</br><b>Capital Inicial (C):</b>");
            out.println("<input type='number' name='capital' step='any' min='0' ></br></br>");
            out.println("<b>Taxa de juros ao mes % (i):</b>");
            out.println("<input type='number' name='taxa' step='any' min='0' ></br></br>");
            out.println("<b>Tempo da aplicacao em meses (t):</b>");
            out.println("<input type='number' name='t' step='any'  min='0' ></br></br>");
            out.println("<input type='submit' value='Calcular'></br></br>");
            
             double C,i,j,t;
             t = parseDouble(request.getParameter("tempo"));
             i = parseDouble(request.getParameter("taxa"));
             C = parseDouble(request.getParameter("capital"));
            
             j = C*i*t;
             
            
             out.println("</table></br></br>");   
             
             
             out.println("<table style='border: 1px solid black; border-collapse: collapse'>");
             out.println("<tr style='border: 1px solid black; border-collapse: collapse'>");
             out.println("<th>Total de Juros da aplicacao</th>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td>"+j+"</td>");
             out.println("</tr>");
             out.println("</table></br></br>");
            
            
            out.println("<h4><a href='home.php'>Voltar</a></h4>");
            out.println("</body>");
            out.println("</html>");
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
