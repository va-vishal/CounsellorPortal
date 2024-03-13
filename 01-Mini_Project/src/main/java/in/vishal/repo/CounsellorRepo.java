package in.vishal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.vishal.entity.Counsellor;

@Repository
public interface CounsellorRepo extends JpaRepository<Counsellor, Integer>{

       public Counsellor findByEmailAndPwd(String email, String pwd);

	   public Counsellor findByEmail(String email);

	

}
