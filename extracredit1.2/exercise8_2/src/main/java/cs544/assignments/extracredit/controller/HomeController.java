package cs544.assignments.extracredit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping({"/", "home"})
	public String getHomePage(Model model, HttpServletRequest request){
		model.addAttribute("headerTitle", "Welecome to Voluntary Services");
		model.addAttribute("subTitle", "Please login to access services");
		model.addAttribute("pageToRender", "../jsp/home.jsp");
		return "/templates/masterTemplate";
	}

}
