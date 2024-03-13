package in.vishal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import in.vishal.entity.Counsellor;
import in.vishal.formBindidngs.DashboardResponse;
import in.vishal.service.CounsellorServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {

	
	@Autowired
	private CounsellorServiceImpl cservice;
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, Model model){
		HttpSession session=req.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("counsellor",new Counsellor());
		return "login";
	}
	
	@PostMapping("/login")
	public String handleLogin(Counsellor c,HttpServletRequest req, Model model) {
	    Counsellor loginCheck = cservice.loginCheck(c.getEmail(), c.getPwd());
	    if (loginCheck == null) {
	    	model.addAttribute("error", "Invalid email or password");
	        return "login"; 
	    } else {
	    	
	        model.addAttribute("message", "Login successful!");
	        HttpSession session = req.getSession(true);
	        session.setAttribute("CID", loginCheck.getCid());
	        return "redirect:/dashboard";
	    }
	}
	
	@GetMapping("/forgot")
	public String showForgotPasswordForm(Model model) {
	    model.addAttribute("c", new Counsellor());
	    return "recover";
	}
	
	@GetMapping("/recover")
	public String recoverPwd(@RequestParam String email, Model model) {
	   
		boolean status = cservice.recoverPwd(email);
	    if (status) {
	        model.addAttribute("msg", "Password sent to your email. Please check.");
	      
	    } else {
	        model.addAttribute("emsg", "Invalid Email");
	    }
	    return "recover";
	}

	
	
	@GetMapping("/dashboard")
	public String buildDashboard(HttpServletRequest req,Model model)
	{
		HttpSession session = req.getSession(false);
		
		Object attribute = session.getAttribute("CID"); 
		
		Integer cid=(Integer) attribute;
		
		DashboardResponse dashboardInfo = cservice.getDashboardInfo(cid);
		model.addAttribute("dashboard",dashboardInfo);
		
		return "dashboard";
	}

	
	@GetMapping("/register")
	private String regPage(Model model) {
		model.addAttribute("counsellor" ,new Counsellor());
		return "register";
	}
	
	@PostMapping("/register")
	private String handleRegistration(Counsellor c,Model model){
		String msg = cservice.saveCounsellor(c);
		model.addAttribute("msg",msg);
		
		return "register";
	}
	
	
}
