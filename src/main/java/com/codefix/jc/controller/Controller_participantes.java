
package com.codefix.jc.controller;

import com.codefix.jc.dao.Participantes_dao;
import com.codefix.jc.dao.Participantes_dao_implements;
import com.codefix.jc.dao.Seminarios_dao;
import com.codefix.jc.dao.Seminarios_dao_implements;
import com.codefix.jc.model.Participantes;
import com.codefix.jc.model.Seminarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet(name = "Controller_participantes", urlPatterns = {"/Controller_participantes"})
public class Controller_participantes extends HttpServlet {

 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try {
            int id;
            Participantes_dao dao = new Participantes_dao_implements();
                  Seminarios_dao  dao_sem= new Seminarios_dao_implements();
            Participantes c = new Participantes();
           
               List<Seminarios> list=null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    
                     list = dao_sem.select();
                    request.setAttribute("action", "nuevo");
                    request.setAttribute("list_seminario", list);
                    request.setAttribute("par", c);
                    request.getRequestDispatcher("participantes-form.jsp").forward(request, response);
                    break;
                case "edit":
                 
                   list = dao_sem.select();
                    id=Integer.parseInt(request.getParameter("id"));
                    c=dao.getById(id);
                
                    request.setAttribute("action","modificar");
                      request.setAttribute("list_seminario", list);
                    request.setAttribute("par",c);
                    request.getRequestDispatcher("participantes-form.jsp").forward(request, response);
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                      dao.delete(id);
                    response.sendRedirect("Controller_participantes");
                    break;
                case "view":
                    //obtener la lista de registros de clientes
                    List<Participantes> lista = dao.select();
                    request.setAttribute("cli", lista);
                    request.getRequestDispatcher("participantes-view.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     int id =Integer.parseInt(request.getParameter("id"));
      String nombres=request.getParameter("nombres");
      String apellidos=request.getParameter("apellidos");
      int id_seminario=Integer.parseInt(request.getParameter("id_seminario"));
      String confirmado=request.getParameter("confirmado");
      if(confirmado==null)
      {
       confirmado="0";          
      }
      Participantes_dao  dao=new Participantes_dao_implements();
      Participantes cli=  new Participantes ();;
        cli.setId(id);
        cli.setNombres(nombres);
        cli.setApellidos(apellidos);
        cli.setId_seminario(id_seminario);
        cli.setConfirmado(Integer.parseInt(confirmado));
       if(id==0){
          try {
             dao.insert(cli);
          } catch (Exception ex) {
              Logger.getLogger(Controller_participantes.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
       else {
       
          try {
              //modificar registro
              dao.update(cli);
          } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null,"ERROR :"+ex.getMessage());
              
          }
       }       
       response.sendRedirect("Controller_participantes"); 
        
    }
    }

   
    

