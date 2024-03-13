package in.vishal.formBindidngs;

public class DashboardResponse {

	private Integer TotEnq;

	private Integer enrolledEnq;
	
	private Integer lostEnq;
	public Integer getTotEnq() {
		return TotEnq;
	}
	public void setTotEnq(Integer totEnq) {
		TotEnq = totEnq;
	}
	public Integer getEnrolledEnq() {
		return enrolledEnq;
	}
	public void setEnrolledEnq(Integer enrolledEnq) {
		this.enrolledEnq = enrolledEnq;
	}
	public Integer getLostEnq() {
		return lostEnq;
	}
	public void setLostEnq(Integer lostEnq) {
		this.lostEnq = lostEnq;
	}
	
	
	
}
