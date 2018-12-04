package demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import demo.bean.Student;
import demo.dao.IStudentDao;
import demo.dao.StudentDao;

/**
 * 
 * @author CongMT
 *
 */
@Controller
public class StudentController {

	@Autowired
	private IStudentDao studentDao;

	@RequestMapping("/addstudent")
	public ModelAndView showform() {
		return new ModelAndView("addstudent", "addstudent", new Student());
	}

//	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
//	public ModelAndView addStudent(@ModelAttribute("student") Student student) {
//		studentDao.addStudent(student);
//		return new ModelAndView("redirect:/index");
//	}

	// @RequestMapping(value = "/index", method = RequestMethod.GET)
	// public ModelAndView displayAllStudent() {
	// List<Student> list = studentDao.getStudent();
	// return new ModelAndView("index", "list", list);
	//
	// }

	@RequestMapping(value = "/editstudent/{id}")
	public ModelAndView editStudent(@PathVariable int id) {
		Student student = studentDao.getAllByStudent(id);
		return new ModelAndView("editstudent", "command", student);

	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("command") Student student) {
		studentDao.editStudent(student);
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		studentDao.deletelStudent(id);
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = "/index/{page}")
	public ModelAndView showAllUser(@PathVariable int page, Model model) {
		int size = 3;
		int total = studentDao.getStudent().size() / size + (studentDao.getStudent().size() % size == 0 ? 0 : 1);
		model.addAttribute("page", page);
		model.addAttribute("total", total);
		List<Student> list = studentDao.getAllStudent((page - 1) * size, size);
		return new ModelAndView("index", "list", list);
	}

	@RequestMapping(value = "/index")
	public ModelAndView showAllUser1(Model model) {
		int size = 3;
		int total = studentDao.getStudent().size() / size + (studentDao.getStudent().size() % size == 0 ? 0 : 1);
		model.addAttribute("page", 1);
		model.addAttribute("total", total);
		List<Student> list = studentDao.getAllStudent(0, size);
		return new ModelAndView("index", "list", list);
	}

	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("student", studentDao.getStudent());
		return "index";
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String message;
		if (userName != null && !userName.equals("") && userName.equals("cong") && password != null
				&& !password.equals("") && password.equals("123")) {
			message = "Welcome " + userName + ".";
			return new ModelAndView("index", "message", message);

		} else {
			message = "Wrong username or password.";
			return new ModelAndView("login", "message", message);
		}
	}
	
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("addstudent") Student student, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		int id =student.getId();
		String path = "E://anh";
		String filename = file.getOriginalFilename();
		File dir = new File(path);
		File img = new File(path + "/" + id);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (!img.exists()) {
			if (img.mkdirs()) {
				try {
					byte barr[] = file.getBytes();

					BufferedOutputStream bout = new BufferedOutputStream(
							new FileOutputStream(path + "/" + id + "/" + filename));
					student.setImg(filename);
					bout.write(barr);
					bout.flush();
					bout.close();
					studentDao.addStudent(student);

				} catch (Exception e) {
					System.out.println(e);
				}
				// sinhvienDao.addSinhVien(sinhvien.getTen(), sinhvien.getTuoi(),
				// sinhvien.getDiachi(), sinhvien.getLop());
			}
		}
		return new ModelAndView("redirect:/index");
	}
}
