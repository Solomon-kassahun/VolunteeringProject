package cs544.assignments.extracredit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping({"/", "/VoluntaryService"})
	public String getProjectsList(){
		return "VoluntaryService";
	}

}
