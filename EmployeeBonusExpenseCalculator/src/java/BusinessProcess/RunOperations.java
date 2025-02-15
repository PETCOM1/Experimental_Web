/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessProcess;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Student
 */
@WebServlet(name = "RunOperations", urlPatterns = {"/RunOperations"})
public class RunOperations extends HttpServlet {

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
        
        
        
        double salary = Double.parseDouble(request.getParameter("input"));
        String option = request.getParameter("options");
        String action = request.getParameter("submit");
        
        String choosenOption = "";
        
        if(option.equalsIgnoreCase("Manager")){
            
            choosenOption = "Manager";
        }
        else if(option.equalsIgnoreCase("Developer")){
            
            choosenOption = "Developer";
        }
        else if(option.equalsIgnoreCase("Intern")){
            
            choosenOption = "Intern";
        }
        
        BusinessProcessObjects bpo = new BusinessProcessObjects(salary, choosenOption);
        bpo.calculateTotalExpense();
        
        ArrayList<BusinessProcessObjects> entries = new ArrayList<>();
        entries.add(bpo);
        
        double totalCompanyExpenses = 0.0;
        if("Submit Entry".equalsIgnoreCase(action)){
            
            //Redirect to the same form to allow new entries
            response.sendRedirect("index.html");
        }else if("Conclude Submission".equalsIgnoreCase(action)){
            
            //Calculate total Expenses
            for (int i=0 ; i<entries.size();i++){
                
                totalCompanyExpenses += entries.get(i).calculateTotalExpense();
            }
        }
        
        
        
        //Calculate the total expenses for each entry and compute overall total
        
        
       
        //request.setAttribute("total", entries);
        request.setAttribute("total", totalCompanyExpenses);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("display_jsp.jsp");
        rd.forward(request, response);
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
