package ch02_sub;

class InterfaceSub implements G_Message {
	// G_Message에 G_Method 내용을 넣을 경우 G_Method의 method들을 필요하지 않아도 선언해서 사용해야만 함
	
	int method3 (int number) {
		System.out.println(GREETING_MESSAGE);
		
		System.out.println(GOODBYE_MESSAGE);
		return 3 + number;
	}
	
}

public class G_InterfaceSub implements G_Message, G_Method { // 다중 구현: 다이아몬드 문제가 일어나지 않음
	
	// 이 클래스 내에서만 사용 가능
	// G_Method에서 method1이 public이지만 'void method1 ()'은 default이기 때문에 public을 앞에 적어줘야 함
	public void method1 () {
		System.out.println(GREETING_MESSAGE);
		
		System.out.println(GOODBYE_MESSAGE);
	}
	
	// 어느 클래스에서든 사용하기 위한 범위 지정
	// G_Method에서 method2가 public이지만 'void method2 ()'는 default이기 때문에 public을 앞에 적어줘야 함
	public void method2 () {
		System.out.println(G_Message.GREETING_MESSAGE);
		
		System.out.println(G_Message.GOODBYE_MESSAGE);
	}
}
