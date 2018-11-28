package fasttrackse.ffse1703.fbms.controller.qttl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qttl.*;
import fasttrackse.ffse1703.fbms.service.qttl.*;

@Controller
@RequestMapping("/QuanTriTaiLieu/TaiLieu")
public class DocumentController {

	private static final String UPLOAD_DIRECTORY = "/upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;

	@Autowired
	DocumentService documentService;

	@Autowired
	@Qualifier(value = "documentServiceImpl")
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	@RequestMapping({ "/list", "" })
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = documentService.getAll().size();
		int recordsPerPage = 3;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", documentService.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanTriTaiLieu/TaiLieu/listTaiLieu";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		List<Category> listcategory = documentService.listCategory();
		model.addAttribute("listCategory", listcategory);
		List<Status> liststatus = documentService.listStatus();
		model.addAttribute("listStatus", liststatus);
		List<Room> listroom = documentService.listRoom();
		model.addAttribute("listRoom", listroom);
		model.addAttribute("document", new Document());
		return "QuanTriTaiLieu/TaiLieu/addTaiLieu";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("document") @Valid Document document, BindingResult result,
			@RequestParam("file") MultipartFile file, HttpSession session, RedirectAttributes redirectAttributes)
			throws Exception {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		ServletContext context = session.getServletContext();

		String uploadPath = context.getRealPath(UPLOAD_DIRECTORY);
		System.out.println(uploadPath);

		String fileName = file.getOriginalFilename();
		document.setFileName(fileName);

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(uploadPath + File.separator + file.getOriginalFilename())));
		stream.write(bytes);
		stream.flush();
		stream.close();

		if (result.hasErrors()) {
			return "QuanTriTaiLieu/TaiLieu/add";
		}

		if (documentService.getById(document.getId()) != null) {
			Document db = documentService.getById(document.getId());
			if (db.getId() == 1) {
				documentService.update(document);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã đã tồn tại.');</script>");
				return "redirect:/QuanTriTaiLieu/TaiLieu/add";
			}
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		documentService.addNew(document);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	public void download(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
		try {
			
	Document document = documentService.getById(id);
	File file = new File(request.getServletContext().getRealPath(UPLOAD_DIRECTORY+File.separator+document.getFileName()));
	byte[] data = FileUtils.readFileToByteArray(file);
	
	// Thiết lập thông tin trả về
	response.setContentType("application/octet-stream");
	response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
	response.setContentLength(data.length);
	
	InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
	FileCopyUtils.copy(inputStream, response.getOutputStream());
	} catch (Exception ex) {
	ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		List<Category> listcategory = documentService.listCategory();
		model.addAttribute("listCategory", listcategory);
		List<Status> liststatus = documentService.listStatus();
		model.addAttribute("listStatus", liststatus);
		List<Room> listroom = documentService.listRoom();
		model.addAttribute("listRoom", listroom);
		model.addAttribute("document", documentService.getById(id));
		return "QuanTriTaiLieu/TaiLieu/editTaiLieu";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("document") @Valid Document document, BindingResult result,
			RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file, HttpSession session)
			throws IOException {
		document.setFileName(UPLOAD_DIRECTORY);

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletContext context = session.getServletContext();

		String uploadPath = context.getRealPath(UPLOAD_DIRECTORY);
		System.out.println(uploadPath);

		String fileName = file.getOriginalFilename();
		document.setFileName(fileName);

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(uploadPath + File.separator + file.getOriginalFilename())));
		stream.write(bytes);
		stream.flush();
		stream.close();

		if (result.hasErrors()) {
			return "QuanTriTaiLieu/TaiLieu/editTaiLieu";
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		documentService.update(document);
		return "redirect:list";

	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") int id) {
		documentService.delete(id);
		return "redirect:/QuanTriTaiLieu/TaiLieu";

	}

}