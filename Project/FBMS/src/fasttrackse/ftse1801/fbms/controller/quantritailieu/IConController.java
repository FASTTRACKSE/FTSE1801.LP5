package fasttrackse.ftse1801.fbms.controller.quantritailieu;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.IconTaiLieu;
import fasttrackse.ftse1801.fbms.service.quantritailieu.IConService;

@Controller
@RequestMapping(value = "QuanTriTaiLieu/i_con")
public class IConController {
	@Autowired
	private IConService iConService;
	private static final String UPLOAD_DIRECTORY = "/upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getListIcon(Model model) {
		List<IconTaiLieu> list = iConService.getAllIcon();
		return new ModelAndView("QuanTriTaiLieu/icon/list", "listIC", list);
	}

	@RequestMapping(value = "/addIcon")
	public ModelAndView addIcon(Model model) {
		return new ModelAndView("QuanTriTaiLieu/icon/add_ic", "icon", new IconTaiLieu());
	}

	@RequestMapping(value="/addIcon",method=RequestMethod.POST)
  public ModelAndView doAddIcon(@ModelAttribute("icon") IconTaiLieu ic,@RequestParam MultipartFile file,HttpSession session, final RedirectAttributes redirectAttributes) {
		try {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);
			String filename = file.getOriginalFilename();
			File quanTriTaiLieu = new File(path);
			
			//String MaIcon = folderIcon + "/" + ic.getMaIcon();
			if(quanTriTaiLieu.exists()) {
				quanTriTaiLieu.mkdirs();
			}
			File folderIcon = new File(path+"/quanTriTaiLieu");
			if(folderIcon.exists()) {
				folderIcon.mkdirs();
			}
			File fileIcon = new File(path+"/quanTriTaiLieu/fileIcon");
			if(fileIcon.exists()) {
				fileIcon.mkdirs();
			}
			File Icon = new File(path+"/quanTriTaiLieu/fileIcon/"+ic.getMaIcon());
			if(Icon .exists()) {
				Icon .mkdirs();
				
			}
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(Icon));
			stream.write(bytes);
			stream.flush();
			stream.close();
			ic.setTenIcon(filename);
			ic.setLinkIcon(path+"/quanTriTaiLieu/fileIcon/"+ic.getMaIcon()+filename);
			iConService.insertIcon(ic);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		
		return new ModelAndView("redirect:/QuanTriTaiLieu/i_con/");
  }
}
