package in.vishal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import in.vishal.entity.Student;
import in.vishal.formBindidngs.SearchCriteria;
import in.vishal.service.StudentServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceImpl sservice;

    @GetMapping("/viewenq")
    public String viewEnquiries(HttpServletRequest req,Model model) {
       
    	HttpSession session=req.getSession(false);
    	Integer cid=(Integer) session.getAttribute("CID");
    	
    	if(cid==null)
    	{
    		return "redirect:/logout";
    	}
    	
    	model.addAttribute("S",new SearchCriteria());
    	
    	List<Student> enquiriesList = sservice.getEnquiries(cid, new SearchCriteria());
       model.addAttribute("enquiries",enquiriesList);
        return "viewenq";
    }

    @PostMapping("/viewenq")
    public String filterEnquiries(@ModelAttribute("S") SearchCriteria S,Model model,HttpServletRequest req) {
    	
    	
    	
       	HttpSession session=req.getSession(false);
    	Integer cid=(Integer) session.getAttribute("CID");
    	
    	if(cid==null)
    	{
    		return "redirect:/logout";
    	}
    	List<Student> enquiriesList = sservice.getEnquiries(cid, S);
    	
    	model.addAttribute("enquiries",enquiriesList);
        return "filterEnqView";
    }

    @GetMapping("/addenq")
    public String addEnquiry(Model model) {
        model.addAttribute("s", new Student());
        return "addenq";
    }

    @PostMapping("/addenq")
    public String handleAddEnquiry(@ModelAttribute("s") Student s,HttpServletRequest req ,Model model) {
    
    	HttpSession session=req.getSession(false);
    	Integer cid=(Integer) session.getAttribute("CID");
    	s.setCid(cid);
    	
    	boolean status= sservice.saveStudent(s);

    	if (status) {
	        model.addAttribute("msg", "Enquiry Added.");
	      
	    } else {
	        model.addAttribute("emsg", "Enquiry Failed to add");
	    }
    	return "redirect:/addenq";
    }
}
