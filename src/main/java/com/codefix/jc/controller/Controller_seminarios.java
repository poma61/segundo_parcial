
package com.codefix.jc.controller;

import com.codefix.jc.dao.Participantes_dao;
import com.codefix.jc.dao.Participantes_dao_implements;
import com.codefix.jc.dao.Seminarios_dao;
import com.codefix.jc.dao.Seminarios_dao_implements;
import com.codefix.jc.model.Participantes;
import com.codefix.jc.model.Seminarios;
import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet(name = "Controller_seminarios", urlPatterns = {"/Controller_seminarios"})
public class Controller_seminarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
            int id;
            Seminarios_dao dao = new Seminarios_dao_implements();
                  Seminarios_dao  dao_sem= new Seminarios_dao_implements();
            Seminarios c = new Seminarios();
       
        
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":   
                    request.setAttribute("action", "nuevo");               
                    request.setAttribute("semi", c);
                    request.getRequestDispatcher("seminarios-form.jsp").forward(request, response);
                    break;
                case "edit": 
                   id=Integer.parseInt(request.getParameter("id"));
                    c=dao.getById(id);             
                    request.setAttribute("action","modificar"); 
                    request.setAttribute("semi",c);
                    request.getRequestDispatcher("seminarios-form.jsp").forward(request, response);
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                      dao.delete(id);
                    response.sendRedirect("Controller_seminarios");
                    break;
                case "view":
                    //obtener la lista de registros de clientes
                    List<Seminarios> lista = dao.select();
                    request.setAttribute("list_seminario", lista);
                    request.getRequestDispatcher("seminarios-view.jsp").forward(request, response);
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
      String titulo=request.getParameter("titulo");
      String fecha=request.getParameter("fecha");
      int cupo=Integer.parseInt(request.getParameter("cupo"));
    
      Seminarios_dao  dao=new Seminarios_dao_implements();
      Seminarios cli=  new Seminarios ();;
        cli.setId(id);
        cli.setTitulo(titulo);
        cli.setFecha(fecha);
        cli.setCupo(cupo);
      
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
       response.sendRedirect("Controller_seminarios"); 
        
    }
    }

   
    


