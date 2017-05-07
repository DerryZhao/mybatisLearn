package com.zhq.pojo;

import java.util.Date;

public class Activity {
	private int id;
	private String title;
	private String note;
	private String imgPath;
	private Date startTime;
	private Date endTime;

	public Activity() {
		super();
	}

	public Activity(int id, String title, String note, String imgPath, Date startTime, Date endTime) {
		super();
		this.id = id;
		this.title = title;
		this.note = note;
		this.imgPath = imgPath;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Activity(String title, String note, String imgPath, Date startTime, Date endTime) {
		super();
		this.title = title;
		this.note = note;
		this.imgPath = imgPath;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", title=" + title + ", note=" + note + ", imgPath=" + imgPath + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

}
