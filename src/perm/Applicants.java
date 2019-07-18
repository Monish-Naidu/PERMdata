package blog.model;

public class Applicants {
	protected long applicantId;
	protected String city;
	protected String state;
	protected String code;
	protected String citizenship;
	protected String birthCountry;
	protected String admissionClass;
	protected EducationLevel education;
	protected String educationOther;
	protected String major;
	protected String yearCompleted;
	protected String institution;
	protected Job job;
	protected Employer employer;
	
	public enum EducationLevel {
		HighSchool,Associate,Bachelor,Master,Doctorate,None,Other
	}

	public Applicants(long applicantId, String city, String state, String code, String citizenship, String birthCountry,
			String admissionClass, EducationLevel education, String educationOther, String major, String yearCompleted,
			String institution, Job job, Employer employer) {
		this.applicantId = applicantId;
		this.city = city;
		this.state = state;
		this.code = code;
		this.citizenship = citizenship;
		this.birthCountry = birthCountry;
		this.admissionClass = admissionClass;
		this.education = education;
		this.educationOther = educationOther;
		this.major = major;
		this.yearCompleted = yearCompleted;
		this.institution = institution;
		this.job = job;
		this.employer = employer;
	}

	public Applicants(long applicantId) {
		this.applicantId = applicantId;
	}

	public Applicants(String city, String state, String code, String citizenship, String birthCountry,
			String admissionClass, EducationLevel education, String educationOther, String major, String yearCompleted,
			String institution, Job job, Employer employer) {
		this.city = city;
		this.state = state;
		this.code = code;
		this.citizenship = citizenship;
		this.birthCountry = birthCountry;
		this.admissionClass = admissionClass;
		this.education = education;
		this.educationOther = educationOther;
		this.major = major;
		this.yearCompleted = yearCompleted;
		this.institution = institution;
		this.job = job;
		this.employer = employer;
	}

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getAdmissionClass() {
		return admissionClass;
	}

	public void setAdmissionClass(String admissionClass) {
		this.admissionClass = admissionClass;
	}

	public EducationLevel getEducation() {
		return education;
	}

	public void setEducation(EducationLevel education) {
		this.education = education;
	}

	public String getEducationOther() {
		return educationOther;
	}

	public void setEducationOther(String educationOther) {
		this.educationOther = educationOther;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getYearCompleted() {
		return yearCompleted;
	}

	public void setYearCompleted(String yearCompleted) {
		this.yearCompleted = yearCompleted;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	
}
