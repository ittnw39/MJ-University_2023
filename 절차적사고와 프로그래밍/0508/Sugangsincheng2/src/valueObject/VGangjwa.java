package valueObject;

public class VGangjwa {
	 private String gangjwaNumber; // 강의 번호
	    private String gangjwaName; // 강의명
	    private String gyosuName; // 교수명
	    private int hakjum; // 학점
	    private String time; // 수업 시간
	    
	    public VGangjwa(String gangjwaNumber, String gangjwaName, String gyosuName, int hakjum, String time) {
	        this.gangjwaNumber = gangjwaNumber;
	        this.gangjwaName = gangjwaName;
	        this.gyosuName = gyosuName;
	        this.hakjum = hakjum;
	        this.time = time;
	    }
	    
	    public String getGangjwaNum() {
	        return gangjwaNumber;
	    }
	    
	    public String getGangjwaName() {
	        return gangjwaName;
	    }
	    
	    public String getGyosuName() {
	        return gyosuName;
	    }
	    
	    public int getCredit() {
	        return hakjum;
	    }
	    
	    public String getTime() {
	        return time;
	    }
	    
	    @Override
	    public String toString() {
	        return gangjwaNumber + " " + gangjwaName + " " + gyosuName + " " + hakjum + "학점 " + time;
	    }
}
