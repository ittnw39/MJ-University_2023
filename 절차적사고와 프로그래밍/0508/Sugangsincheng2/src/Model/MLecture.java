package Model;

import java.util.Scanner;

public class MLecture {

	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	
	public boolean read(Scanner scanner) {

		while (scanner.hasNext()) {
			String line =scanner.nextLine();
			String[] info = line.split("\\s");
				
			this.id = info[0];
			this.name = info[1];
			this.professor = info[2];
			this.credit = info[3];
			this.time = info[4];

			return true;
		}
		return false;
	}
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
	
}