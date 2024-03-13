package in.vishal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vishal.entity.Counsellor;
import in.vishal.entity.Student;
import in.vishal.formBindidngs.DashboardResponse;
import in.vishal.repo.CounsellorRepo;
import in.vishal.repo.StudentEnqRepo;
import in.vishal.utils.EmailUtils;

@Service
public class CounsellorServiceImpl implements CounsellorService{
	@Autowired
	private StudentEnqRepo sRepo;
	
	@Autowired
	private CounsellorRepo crepo;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String saveCounsellor(Counsellor c) {
		Counsellor byEmail = crepo.findByEmail(c.getEmail());
		if(byEmail!=null)
		{
			return "Duplicate Email";
		}
	    Counsellor save = crepo.save(c);
	    if(save.getCid() != null) {
	        return "Counsellor saved with name: " + save.getName();
	    } else {
	        return "Failed to save counsellor";
	    }
	}

	@Override
	public Counsellor loginCheck(String email, String pwd) {
		Counsellor byEmailAndPwd = crepo.findByEmailAndPwd(email, pwd);
		if(byEmailAndPwd!= null&&byEmailAndPwd.getEmail().equals(email)&&byEmailAndPwd.getPwd().equals(pwd)) {
			return byEmailAndPwd;
		}
		return null;
	}


	@Override
	public boolean recoverPwd(String email) {
	    Counsellor c= crepo.findByEmail(email);
	    if (c==null) {
	        return false;
	    }
	    String subject="Recover Password -vishalods";
	    
	    String body="<h1>Your Password: "+c.getPwd()+"</h1>" ;
	    
	    return emailUtils.sendEmail(subject, body, email);
	}



	@Override
	public DashboardResponse getDashboardInfo(Integer cid) {
		List<Student> allEnq = sRepo.findByCid(cid);
		
		int enrolledEnqs = allEnq.stream().filter(e-> e.getStatus().equals("Enrolled"))
								 .collect(Collectors.toList())
								 .size();
		
		DashboardResponse resp=new DashboardResponse();
		resp.setTotEnq(allEnq.size());
		resp.setEnrolledEnq(enrolledEnqs);
		resp.setLostEnq(allEnq.size()-enrolledEnqs);
		return resp;
	} 	
	



     	

}