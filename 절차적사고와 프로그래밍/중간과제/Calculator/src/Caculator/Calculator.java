package Caculator;

import java.io.IOException;

public class Calculator { 
	private static final int CR = 0x0d;
	private static final int zero = 0x30;
	private static final int LF = 0x0a;
	private static final int Tab = 0x09;
	private static final int Space = 0x20;
    
	private int readOperator() throws IOException {
		int code = System.in.read();
		
		while(code == Space || code == CR || code == LF || code == Tab) {
			code = System.in.read();
		}
		return code;
	}
	
	private int readInt() throws IOException{ 
		int number = 0;
		int code;
		code = System.in.read();
			
		while(code==CR || code==Tab || code==LF || code==Space) { //엔터,탭,스페이스 무시하기
				code = System.in.read();
			}
			
		if (code < '0' || code > '9') {
		        throw new IllegalArgumentException("You can only enter single-digit numbers. : " + (char) code);
		    }
		 
		while(code >= '0' && code <= '9') {
				number = number * 10 + (code - zero);
				code = System.in.read();
			}
		return number;
		}

	private void quit() {
		System.exit(0);
	}
	private int compute(int code) throws IOException {
		int result = 0;
		int number1 = readInt();
        int number2 = readInt();
        
		if (code == '+') {
			result = number1 + number2;
		} else if(code == '-'){
			result = number1 - number2;
		}else if(code == '*'){
			result = number1 * number2;
		}else if(code == '/'){
			result = number1 / number2;
		}else {
			throw new IOException("You have not entered an operator."); 
		}
		return result;
	}
	
	public void run() {
			try {
				System.out.println("Enter the operator (+, -, *, / | q->quit): ");
				int code = readOperator();
				while(code != 'q') { //q누르기 전까지 반복
					double result = compute(code);
					System.out.println(result);
					System.out.println("Enter the operator (+, -, *, / | q->quit): ");
					code = readOperator();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ArithmeticException e) { //0으로 나눌 경우 에러발생
				System.out.println("Division by zero is not allowed.");
			} catch(IllegalArgumentException e) { // +, -, *, / 가 아닌 연산자가 들어왔을 때
				System.out.println("You can only enter one operator.");
			}
	}

}


