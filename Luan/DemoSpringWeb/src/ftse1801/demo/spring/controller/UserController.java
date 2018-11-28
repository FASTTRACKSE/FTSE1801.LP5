package ftse1801.demo.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

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

import ftse1801.demo.spring.di.IUserDao;
import ftse1801.demo.spring.modal.bean.User;

@Controller
public class UserController {
	@Autowired
	private IUserDao userDao;

	@RequestMapping(value = "/show/{page}")
	public ModelAndView showAllUser(@PathVariable int page, Model model) {
		int size = 3;
		int total = userDao.showAllUser().size() / size + (userDao.showAllUser().size() % size == 0 ? 0 : 1);
		model.addAttribute("page", page);
		model.addAttribute("total", total);
		List<User> list = userDao.showAllUserInPage((page - 1) * size, size);
		return new ModelAndView("index", "listSV", list);
	}

	@RequestMapping(value = "/show")
	public ModelAndView showAllUser1(Model model) {
		int size = 3;
		int total = userDao.showAllUser().size() / size + (userDao.showAllUser().size() % size == 0 ? 0 : 1);
		model.addAttribute("page", 1);
		model.addAttribute("total", total);
		List<User> list = userDao.showAllUserInPage(0, size);
		return new ModelAndView("index", "listSV", list);
	}

	@RequestMapping(value = "/add")
	public ModelAndView addUser() {
		return new ModelAndView("addUser", "command", new User());
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView saveAdd(@ModelAttribute("command") User user, @RequestParam CommonsMultipartFile file,
			HttpSession session) {

		// String path = session.getServletContext().getRealPath("/image");
		String path = "D:\\image";
		String filename = file.getOriginalFilename();
		userDao.addUser(user.getId(), user.getName(), user.getPass(), user.getAge(), user.getAdd(), filename);
		File dir = new File(path);
		String folder = path + "/" + user.getId();

		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file1 = new File(folder);
		if (file1.mkdirs()) {
			try {
				byte barr[] = file.getBytes();
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(folder + "/" + filename));
				bout.write(barr);
				bout.flush();
				bout.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return new ModelAndView("redirect:/show");
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView editUser(@PathVariable String id) {
		User user = userDao.getUser(id);
		return new ModelAndView("editUser", "saveEdit", user);
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public ModelAndView saveEdit(@ModelAttribute("saveEdit") User user) {
		userDao.updateUser(user.getName(), user.getPass(), user.getAge(), user.getAdd(), user.getId(), user.getImg());
		return new ModelAndView("redirect:/show");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String id) {
		userDao.delUser(id);
		return new ModelAndView("redirect:/show");
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam CommonsMultipartFile file, HttpSession session) {
		String path = session.getServletContext().getRealPath("/image");
		String filename = file.getOriginalFilename();
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("redirect:/show", "filename", path + "/" + filename);
	}
}
