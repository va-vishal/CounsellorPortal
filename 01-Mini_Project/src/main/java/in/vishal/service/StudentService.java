package in.vishal.service;

import java.util.List;

import in.vishal.entity.Student;
import in.vishal.formBindidngs.SearchCriteria;

public interface StudentService {

	
	public boolean saveStudent(Student s);
	public List<Student> getEnquiries(Integer cid,SearchCriteria c);
}
