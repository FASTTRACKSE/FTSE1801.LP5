package fasttrackse.ftse1801.fbms.controller.quanlyduan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fasttrackse.ftse1801.fbms.service.quanlyduan.DuAnService;

@Controller
@RequestMapping("/QuanLyDuAn/DuAn")

public class DuAnController {
@Autowired
private DuAnService duAnService;

}
	