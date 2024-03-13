package in.vishal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.vishal.entity.Student;

@Repository
public interface StudentEnqRepo extends JpaRepository<Student, Integer> {
    
	
	public List<Student> findByCid(Integer cid);
    
}
