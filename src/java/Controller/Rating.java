/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package Controller;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
/**
 *
 * @author LENOVO
 */
public class Rating extends SimpleTagSupport {

    private int min;
    private int max;
    private int num;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
   @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
 
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");  
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"); 
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\">"); 
            out.println("</head>");
            out.println("<body>");

            for(int i= min; i<num;i++){
            
            out.print("<span><i style=\"color: yellow\" class=\"fa-solid fa-star\"></i></span>");
            }
            for(int i= min; i<max-num;i++){
            out.print("<span><i style=\"color: yellow\"  class=\"fa-regular fa-star\"></i></span>");
            }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            out.println("</body>");
            out.println("</html>");
            
           
        } catch (java.io.IOException ex) {
            throw new JspException("Error in NumberListTagHandler tag", ex);
        }
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
}
