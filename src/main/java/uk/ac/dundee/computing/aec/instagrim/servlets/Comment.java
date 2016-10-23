package uk.ac.dundee.computing.aec.instagrim.servlets;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import static com.datastax.driver.core.DataType.text;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.lib.Convertors;
import uk.ac.dundee.computing.aec.instagrim.models.PicModel;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;

/**
 * Servlet implementation class Image
 */
@WebServlet(name="Comment", urlPatterns = {"/Comment/*","/Comment"})

public class Comment extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Cluster cluster;
    
    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Allows users to press an image and type into a comment box then submit
            String args[] = Convertors.SplitRequestPath(request);
            System.out.println("add comment to : "+args[2]);
            HttpSession session=request.getSession();
            session.setAttribute("picid",args[2]);
            RequestDispatcher rd=request.getRequestDispatcher("/Comments.jsp");
	    rd.forward(request,response);
    }

    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException { 
         HttpSession session=request.getSession();
       String picid=(String)session.getAttribute("picid");
         System.out.print("your text:");
         String comment=request.getParameter("Comment");
         System.out.print("your text:"+comment);
         setComment(comment,picid);
         System.out.print("your text:"+comment);
     }

    
    private void error(String mess, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = null;
        out = new PrintWriter(response.getOutputStream());
        out.println("<h1>You have a na error in your input</h1>");
        out.println("<h2>" + mess + "</h2>");
        out.close();
        return;
    }   
    
    public void setComment ( String comment, String picid) {
    
        try (Session session = cluster.connect("instagrim")) {
            String tmp="{\'"+comment+"\'}";
            String code = "UPDATE Pics set comment=comment+" + tmp + " where picid=?";
            System.out.print(code);
            PreparedStatement ps = session.prepare(code);
            
            BoundStatement bsInsertPic = new BoundStatement(ps);

            session.execute(bsInsertPic.bind(picid));
        }

    }
}
