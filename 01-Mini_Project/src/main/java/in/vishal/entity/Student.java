package in.vishal.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity(name = "student_Info")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;

    private String name;

    private Long phone;

    private String classMode;

    private String courseName;

    private String status;
    @CreationTimestamp
    private String createdDate;

    private Integer cid;
    
    public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Integer eid, String name, Long phone, String classMode, String courseName, String status,
			String createdDate, Integer cid) {
		super();
		this.eid = eid;
		this.name = name;
		this.phone = phone;
		this.classMode = classMode;
		this.courseName = courseName;
		this.status = status;
		this.createdDate = createdDate;
		this.cid = cid;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Student [eid=" + eid + ", name=" + name + ", phone=" + phone + ", classMode=" + classMode
				+ ", courseName=" + courseName + ", status=" + status + ", createdDate=" + createdDate + ", cid=" + cid
				+ "]";
	}
	
}
