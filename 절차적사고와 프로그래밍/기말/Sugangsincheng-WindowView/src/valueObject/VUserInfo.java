package valueObject;

public class VUserInfo { //account에서 돌아오는 정보
	private String name;
	private String userID;
	private String maxHakjum;
	
	public String getMaxHakjum() {
		return maxHakjum;
	}

	public void setMaxHakjum(String maxHakjum) {
		this.maxHakjum = maxHakjum;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getUserID() {
		// TODO Auto-generated method stub
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}