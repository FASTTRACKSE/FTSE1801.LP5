package model;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

@ManagedBean
@RequestScoped
public class UploadBean {

    private Part file;
    private String fileName;
    private long fileSize;
    
    /**
     * Creates a new instance of Upload_File
     */
    public UploadBean() {
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String upload()
    {
        try {
            fileName = file.getSubmittedFileName();
            fileSize = file.getSize();
            String dirPath= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
            file.write(dirPath + "/" + fileName);
            
        } catch (IOException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "view";
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}