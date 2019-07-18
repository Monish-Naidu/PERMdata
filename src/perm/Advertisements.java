package blog.model;

import java.util.Date;

public class Advertisements {
	protected int advertisementId;
	protected AdvertiseMeans means;
	protected Date startDate;
	protected Date endDate;
	protected Job job;

	public enum AdvertiseMeans {
		Newspaper,JobFair,OnCampus,WebPosts,ProfessionalOrg,JobSearchWebsites,
		EmplpoymentFirm,EmployeeReferal,CampusRecruitment,LocalEthicalPaper,RadioOrTV
	}

	public Advertisements(int advertisementId, AdvertiseMeans means, Date startDate, Date endDate, Job job) {
		this.advertisementId = advertisementId;
		this.means = means;
		this.startDate = startDate;
		this.endDate = endDate;
		this.job = job;
	}

	public Advertisements(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public Advertisements(AdvertiseMeans means, Date startDate, Date endDate, Job job) {
		this.means = means;
		this.startDate = startDate;
		this.endDate = endDate;
		this.job = job;
	}

	public int getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public AdvertiseMeans getMeans() {
		return means;
	}

	public void setMeans(AdvertiseMeans means) {
		this.means = means;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
}
