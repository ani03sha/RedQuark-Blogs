package org.redquark.retrofit.gerrit.model;

/**
 * @author Anirudh Sharma
 * 
 * This is the model class for the Change
 */
public class Change {

	/**	
	 * Subject of the change
	 */
	private String subject;

	/**
	 * Status of the change
	 */
	private String status;

	/**
	 * Owner of the change
	 */
	private String owner;

	/**
	 * Project in which the change is done
	 */
	private String project;

	/**
	 * Branch in which the change is done
	 */
	private String branch;

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

}
