package Caculator;

import java.io.IOException;

public class Main {//고정
	
	public Main() {//고정
		
	}
	public void run() { //여기만 바꾸는 것.
		Calculator calculator = new Calculator();
		calculator.run(); //무한대의 기계를 만들어낼 수 있다.
	}
	public static void main(String[] args) { 	//프로그램의 시작점을 나타내는 함수 - main, 고정시키는 것이 좋다.
		Main main = new Main();
		main.run();
	}

}
