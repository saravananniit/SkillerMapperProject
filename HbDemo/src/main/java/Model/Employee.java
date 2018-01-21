package Model;


import javax.persistence.*;

@Entity
@Table
public class Employee {
	
	@Id
	private int id;

	public int getId() {
		return id;
	}
	
	//this is an model for database program
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private String name;
	
	

}
