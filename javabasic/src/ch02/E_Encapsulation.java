package ch02;

// 캡슐화: 멤버 변수(속성)와 메서드를 묶어서 변수에 대한 조작을 메서드를 통해서만 할 수 있도록 하는 것
// 정보 은닉과 데이터 보호, 데이터 무결성 보장할 수 있음
class FootballPlayerB {
	// private을 사용하여 외부에서 접근할 수 없도록 함
	private String name;
	private String birth;
	private String team;
	private int goal;
	
	// 생성자(초기화를 가능하게 하기 위한 용도)
	FootballPlayerB (String name, String birth, String team, int goal) {
		this.name = name;
		this.birth = birth; // 생일은 바뀌지 않으므로 setter 안 씀
		this.team = team;
		this.goal = goal;
	}
	
	// getter의 형태: 반환데이터타입 get(변수명) () { return 변수명; }
	// getter 메서드(가져올 때/값만 반환)
	String getName () {
		return this.name;
	}
	
	String getBirth () {
		return this.birth;
	}
	
	String getTeam () {
		return this.team;
	}

	int getGoal () {
		return this.goal;
	}
	
	// setter의 형태: void set(변수명) (매개변수) {  }
	// setter 메서드(입력할 때/값 변경)
	// setter 정확한 값를 넣기 위한 제약조건
	void setName (String name) {
		this.name = name;
	}
	
	void setTeam (String team) {
		this.team = team;
	}
	
	void setGoal (int goal) {
		if (goal < 0) return;
		this.goal = goal;
	}
}

class FootballPlayerC {
	private String name;
	private String birth;
	private String team;
	private int goal;
	
	
	// alt+shift+s 해서 generate constructor using fields... 로 만들 수 있음(eclipse로만 가능)
	FootballPlayerC(String name, String birth, String team, int goal) {
//		super(); // 상위 클래스인 Object 인식
		this.name = name;
		this.birth = birth;
		this.team = team;
		this.goal = goal;
	}
	// alt+shift+s 해서 generate getters and setters... 로 만들 수 있음
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getTeam() {
		return team;
	}
	void setTeam(String team) {
		this.team = team;
	}
	int getGoal() {
		return goal;
	}
	void setGoal(int goal) {
		this.goal = goal;
	}
	String getBirth() {
		return birth;
	}
	
	
}

public class E_Encapsulation {

	public static void main(String[] args) {
		
		// 일반 인스턴스 변수의 경우 매개변수가 필요 없지만 생성자의 경우 매개변수가 필요함
		FootballPlayerB son = new FootballPlayerB("손흥민", "920000", "토트넘 홋스퍼", 0);
//		son.name = "손흥민";
//		son.team = "토트넘 홋스퍼";
//		son.goal = 0;
		
		son.setGoal(-1);		
		
		System.out.println(son.getGoal());

	}

}
