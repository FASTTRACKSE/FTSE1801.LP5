package demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "file";

    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
        	
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk 
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        
        //Duong dan tam thoi
        System.out.println(System.getProperty("java.io.tmpdir"));
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory4
        String uploadPath = getServletContext().getRealPath("")
                 + UPLOAD_DIRECTORY;
        System.out.println(uploadPath);
        System.out.println("----------------------");
        System.out.println(getServletContext());
        System.out.println("----------------------");
        System.out.println(getServletContext().getRealPath(""));
        System.out.println("----------------------");
        System.out.println(File.separator);
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();	
        }

        try {
            // parses the request's content to extract file data
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
            	ArrayList<String> myList = new ArrayList<>();
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        System.out.println("--------------ten file---------");
                        System.out.println(item.getName());
                        System.out.println("--------------");
                        System.out.println(fileName);
                        System.out.println("--------------");
                        System.out.println(filePath);
                        // saves the file on disk
                        myList.add(UPLOAD_DIRECTORY + "/" + fileName);
                        item.write(storeFile);
                    }
                }
                request.setAttribute("img", myList);
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        // redirects client to message page
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);
	}

}
