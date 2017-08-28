/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto01.web;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nilo
 */
@WebServlet(name = "Juros_composto", urlPatterns = {"/juros_composto.php"})
public class Juros_composto extends HttpServlet {

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
            out.println("<title>Servlet Juros_composto</title>");         
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Juros Composto</h1>");
            
            out.println("<h3>A Formula a ser utilizada é <abbr title='JUROS'>J</abbr> = <abbr title='CAPITAL INICIAL'>C</abbr>"
                    + "((1+<abbr title='TAXA DE JUROS AO MES'>i</abbr>)<sup><abbr title='QUANTIDADE DE MESES'>n</abbr></sup>-1)</h3>");
            
            out.println("<div style='border: 2px solid; width: 230px; padding: 10px;'>");
            out.println("<h3>J = Juros a ser descoberto<br/>C = Capital Inicial <br/>i = taxa de juros ao mes<br/>n = quantidade de meses");
            out.println("</div></br></br>");
            
            out.println("<form>");
            out.println("<fieldset style='width:500px'>");
            out.println("<legend style='font-size:22px;'><b>Informe os seguintes dados:</legend>");
            out.println("</br><b>Capital Inicial (C):</b>");
            out.println("<input type='number' name='capital' step='any' min='0' ></br></br>");
            out.println("<b>Taxa de juros ao mes % (i):</b>");
            out.println("<input type='number' name='taxa' step='any' min='0' ></br></br>");
            out.println("<b>Quantidade de meses da aplicação (n):</b>");
            out.println("<input type='number' name='n' step='any'  min='0' ></br></br>");
            out.println("<input type='submit' value='Calcular'></br></br>");
            out.println("</fieldset>");
            out.println("</form></br></br>");
            
            
            double montante,capital,taxa,juros,n,aux;
            n = parseDouble(request.getParameter("n"));
            taxa = parseDouble(request.getParameter("taxa"));
            capital = parseDouble(request.getParameter("capital"));
            aux = Math.pow((1+(taxa/100)), n);
            juros = capital*(aux-1);
            montante = capital;  
            //Jeito que eu achei para colocar somente 2 casas depois da virgula.
            DecimalFormat formato = new DecimalFormat("#.00");
            //capital = Double.valueOf(formato.format(capital));
            //juros = Double.valueOf(formato.format(juros));
            //taxa = Double.valueOf(formato.format(taxa));
            //n = Double.valueOf(formato.format(n));
            //aux = Double.valueOf(formato.format(aux));
                    
                
            out.println("<table style='border: 1px solid black; border-collapse: collapse'>");
            out.println("<tr>");
            out.println("<th style='border: 1px solid black; border-collapse: collapse'>Quantidade de Meses</th>");
            out.println("<th>Montante Acumulado</th>");
            out.println("</tr>");
            for(int h=0; h<=n;h++){
                out.println("<tr style='border: 1px solid black; border-collapse: collapse'>");
                out.println("<td style='border: 1px solid black; border-collapse: collapse'>"+h+"</td>");
                montante = Double.valueOf(formato.format(montante).replace(',','.'));
                out.println("<td style='border: 1px solid black; border-collapse: collapse'>R$"+formato.format(montante)+"</td>");
                out.println("</tr>");
                montante = (montante*(taxa/100))+montante;
            }
            out.println("</table></br></br>");   
            
            
            out.println("<table style='border: 1px solid black; border-collapse: collapse'>");
            out.println("<tr style='border: 1px solid black; border-collapse: collapse'>");
            out.println("<th>Total de Juros da Aplicação</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td> R$"+formato.format(juros)+"</td>");
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
