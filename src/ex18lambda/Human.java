package ex18lambda;

public class Human {
	//멤버변수 : 이름, 성별, 점수
	String name;
	String gender;
	int score;
	//생성자
	public Human(String name, String gender, int score) {
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}