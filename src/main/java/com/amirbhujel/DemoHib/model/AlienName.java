package com.amirbhujel.DemoHib.model;

import javax.persistence.Embeddable;

@Embeddable  // We don't want a new table. We want to embed this to the existing table.
public class AlienName {

	private String fName;
	private String lName;
	private String mName;
	
	public AlienName(){}
	
	public AlienName(String fName, String lName){
		this.fName = fName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}

	@Override
	public String toString() {
		return "AlienName [fName=" + fName + ", lName=" + lName + ", mName=" + mName + "]";
	}


}
