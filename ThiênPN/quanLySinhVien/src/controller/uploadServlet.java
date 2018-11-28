package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
/**
 * Servlet implementation class uploadServlet
 */
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final int MEMORY_THRESHOLD = 0;
//	private static final long MAX_FILE_SIZE = 0;
//	private static final long MAX_REQUEST_SIZE = 0;
//	private static final String UPLOAD_DIRECTORY = null;
	 private static final String UPLOAD_DIRECTORY = "upload";
	    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
	    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	 
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if (!ServletFileUpload.isMultipartContent(request)) {
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: Form must has enctype=multipart/form-data.");
	            writer.flush();
	            return;
	        }
	 
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	        ServletFileUpload upload = new ServletFileUpload(factory);
	 
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	 
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	 
	        String uploadPath = getServletContext().getRealPath("")
	                + File.separator + UPLOAD_DIRECTORY;
	 
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	 
	        try {
 	            List<FileItem> formItems = upload.parseRequest(request);
	 
	            if (formItems != null && formItems.size() > 0) {
	                for (FileItem item : formItems) {
	                    if (!item.isFormField()) {
	                        String fileName = new File(item.getName()).getName();
	                        String filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	 
	                        item.write(storeFile);
	                        request.setAttribute("lang", UPLOAD_DIRECTORY + "/" + fileName);
	                        request.setAttribute("message",
	                                "Upload has been done successfully >>" + UPLOAD_DIRECTORY + "/" + fileName);
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            request.setAttribute("message",
	                    "There was an error: " + ex.getMessage());
	        }
		request.getRequestDispatcher("upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
