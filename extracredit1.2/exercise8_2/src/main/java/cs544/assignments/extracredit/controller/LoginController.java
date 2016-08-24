package cs544.assignments.extracredit.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cs544.assignments.extracredit.model.User;
import cs544.assignments.extracredit.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {	
	@Autowired
	UserService userService;
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {	
		model.addAttribute("headerTitle", "Welecome to Voluntary Services");
		model.addAttribute("pageToRender", "../jsp/home.jsp");
		return "/templates/masterTemplate";
	}
	
	@RequestMapping(value="/postLogin", method = RequestMethod.GET)
	public String PostLogin(HttpServletRequest request, Model model) {		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){    
        	model.addAttribute("user", getPrincipal());
        	String nextPage = (String)request.getAttribute("nextPage");
        	if(nextPage != null){
        		return "redirect:/"+nextPage;
        	}else{
        		return "redirect:/home";        	
        	}        	
        }
 		return "redirect:/login";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		model.addAttribute("headerTitle", "Welecome to Voluntary Services");
		model.addAttribute("pageToRender", "../jsp/home.jsp");
		return "/templates/masterTemplate"; 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response, SessionStatus status)	{
	    status.setComplete();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
       
 		return "redirect:/home";
 	}
	
	private User getPrincipal(){
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userService.findUserByUsername(username);
    }
}
