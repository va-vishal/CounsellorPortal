package in.vishal.service;

import in.vishal.entity.Counsellor;
import in.vishal.formBindidngs.DashboardResponse;

public interface CounsellorService {

	public String saveCounsellor(Counsellor c);
	 
	public Counsellor loginCheck(String email, String pwd);

	public boolean recoverPwd(String email);

	public DashboardResponse getDashboardInfo(Integer cid);

}
