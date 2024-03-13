package in.vishal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.vishal.entity.Student;
import in.vishal.formBindidngs.SearchCriteria;
import in.vishal.repo.StudentEnqRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentEnqRepo srepo;
	

	@Override
	public boolean saveStudent(Student s) {
		Student save = srepo.save(s);
		
		return save.getCid()!=null;
	}
	


	public List<Student> getEnquiries(Integer cid, SearchCriteria S) {
		
		Student s=new Student();
		
		s.setCid(cid);
		
		if(S.getClassMode()!=null && !S.getClassMode().equals("")) {
			s.setClassMode(S.getClassMode());
		}
		if(S.getCourseName()!=null&& !S.getCourseName().equals("")) {
			s.setCourseName(S.getCourseName());
		}
		if(S.getStatus()!=null&& !S.getStatus().equals("")) {
			s.setStatus(S.getStatus());
		}
		Example<Student> of = Example.of(s);
		
		List<Student> enquiries= srepo.findAll(of);
		
		return enquiries;
	}
	

}
