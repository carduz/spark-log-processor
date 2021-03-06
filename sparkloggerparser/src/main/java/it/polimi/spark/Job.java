package it.polimi.spark;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Job {

	private String appID;
	private String clusterName;
	private int duration;
	private int id;
	static final Logger logger = LoggerFactory.getLogger(Job.class);
	private List<Stage> stages;

	/**
	 * @param appID
	 * @param appName
	 * @param jobID
	 */
	public Job(String clusterName, String appID, int jobID) {
		super();
		this.clusterName = clusterName;
		this.appID = appID;
		this.id = jobID;
		stages = new ArrayList<Stage>();
	}

	public String getAppID() {
		return appID;
	}

	public String getClusterName() {
		return clusterName;
	}

	public int getDuration() {
		return duration;
	}

	public int getID() {
		return id;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void addStage(Stage stage) {
		if (stage.getClusterName() != getClusterName()
				|| stage.getAppID() != getAppID()
				|| stage.getJobID() != getID()) {
			logger.warn("Trying to add a stage with wrong cluster name, application id or job ID, Skipped stage with id: "
					+ stage.getID());
			return;
		}

		stages.add(stage);
	}

	public List<Stage> getStages() {
		return stages;
	}

}
