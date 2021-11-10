package com.androidstore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "astore")
public class Astore {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	@Column(name = "app_name")
	private String appName;
	@Column(name = "publisher")
	private String publisher;
	@Column(name = "app_type")
	private String aType;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAType() {
		return aType;
	}
	public void setAType(String aType) {
		this.aType = aType;
	}
	public Astore()
	{
		
	}
//	public Astore(Long id, String appName, String publisher, String aType ) {
//	this.id=id;
//	this.appName=appName;
//	this.publisher=publisher;
//	this.aType=aType;
//	}
}
