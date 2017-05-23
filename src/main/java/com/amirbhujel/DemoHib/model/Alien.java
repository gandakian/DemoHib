package com.amirbhujel.DemoHib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity(name ="alien_table")  --This will change the Entity name as well.
@Entity
@Table(name="alien_table")  //This will just change the table name keeping the Entity name as Alien.
public class Alien {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aId;
	
	// @Transient -- This will not store the data into database.
	private AlienName aName;
	
	@Column(name="alien_color")
	private String aColor;
	
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public AlienName getaName() {
		return aName;
	}
	public void setaName(AlienName aName) {
		this.aName = aName;
	}
	public String getaColor() {
		return aColor;
	}
	public void setaColor(String aColor) {
		this.aColor = aColor;
	}
	
	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", aName=" + aName + ", aColor=" + aColor + "]";
	}
	
}
