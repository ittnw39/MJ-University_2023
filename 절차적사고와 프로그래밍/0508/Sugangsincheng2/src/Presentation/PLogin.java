package Presentation;

import java.io.FileNotFoundException;
import java.util.Scanner;
import Controller.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin { // presentation 占쎌넅筌롳옙

	public VUserInfo login() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in); // 占쎈뮞筌�癒�瑗ワ옙�삂 占쎄텕癰귣�諭� 占쎈염野껓옙. 占쎈뼄 占쎈쾺筌롳옙 占쎈즼占쎌젻餓μ꼷鍮� 占쎈맙. 占쎈즴占쎌젎占쎌읅占쎌몵嚥∽옙 占쎄땀揶쏉옙 占쎈쿈 占쎈땾 占쎌뿳占쎈선占쎈튊 占쎈맙.

		System.out.println("아이디를 입력하세요.");
		String userID = sc.next();
		System.out.println("비밀번호를 입력하세요.");
		String userPW = sc.next();

		int loginsido = 0;
//		while (loginsido < 5) {
			VLogin vlogin = new VLogin(); // value object占쎈퓠 占쎈뼖疫뀐옙
			vlogin.setUserID(userID); // vlogin占쎈퓠 占쎈툡占쎌뵠占쎈탵 占쎈뼖疫뀐옙
			vlogin.setUserPW(userPW); // vlogin占쎈퓠 �뜮袁⑨옙甕곕뜇�깈 占쎈뼖疫뀐옙

			CLogin clogin = new CLogin();
			VUserInfo vuserinfo = clogin.login(vlogin);

			if (vuserinfo == null) {
//				
//				System.out.println("占쎌삋筌륅옙 占쎌뿯占쎌젾占쎈┷占쎈�占쎈뮸占쎈빍占쎈뼄. 占쎈뼄占쎈뻻 占쎈뻻占쎈즲占쎈퉸雅뚯눘苑�占쎌뒄. �궓�� : " + (5 - loginsido) + ")");
//				loginsido++;
//				System.out.println("占쎈툡占쎌뵠占쎈탵�몴占� 占쎌뿯占쎌젾占쎈릭占쎄쉭占쎌뒄.");
//				userID = sc.next();
//				System.out.println("�뜮袁⑨옙甕곕뜇�깈�몴占� 占쎌뿯占쎌젾占쎈릭占쎄쉭占쎌뒄.");
//				userPW = sc.next();
//				
			} else {
				System.out.println(vuserinfo.getName() + "님 안녕하세요.");
			}
		//}
			return vuserinfo;
		//System.out.println("嚥≪뮄�젃占쎌뵥 占쎈뻻占쎈즲 占쎌뒒占쎈땾�몴占� �룯�뜃�궢占쎈릭占쎈연 占쎈쐭 占쎌뵠占쎄맒 嚥≪뮄�젃占쎌뵥占쎌뵠 �겫�뜃占쏙옙鍮�占쎈빍占쎈뼄..");
	}
}
