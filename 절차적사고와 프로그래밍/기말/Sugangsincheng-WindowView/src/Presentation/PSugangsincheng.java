package Presentation;

import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheng extends JPanel{

private PLectureSelection pLectureSelection;
private PLectureBasket pLectureBasket;
private PMiridamgi pMiridamgi;
private PSincheng pSincheng;
 
 public PSugangsincheng() {
	 
	 this.setBackground(Color.WHITE);
	 
	 LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS); // x축을 기준으로 평행하게
	 this.setLayout(layoutManager);
	 
	 //add child components
	 this.pLectureSelection = new PLectureSelection();
	 this.pLectureSelection.setBackground(Color.GREEN);
	 this.add(this.pLectureSelection);
	 
	 this.pLectureSelection = new PLectureSelection();
	 this.pLectureSelection.setBackground(Color.YELLOW);
	 this.add(this.pLectureSelection);
	 
	 this.pMiridamgi = new PMiridamgi();
	 this.pMiridamgi.setBackground(Color.BLUE);
	 this.add(this.pMiridamgi);
	 
	 this.pSincheng = new PSincheng();
	 this.pSincheng.setBackground(Color.RED);
	 this.add(this.pSincheng);
//	 this.pLectureSelection = new PLectureSelection();
//	 
//	 this.pMiridamgi = new PMiridamgi();
//	 this.pSincheng = new PSincheng();
 }

 public void run(VUserInfo vuserinfo, Scanner keyboard) {
		VLecture vLecture = null;
		boolean BRunning = true;
		while(BRunning) {
			System.out.println("[메뉴] 강좌 선택 0, 미리담기 1, 수강신청 2, 장바구니 보기 3, 신청강좌 보기 4, 종료 9");
			
			String sCode = keyboard.next();
			int iCode = Integer.parseInt(sCode);
			switch(iCode) {
			case 0:
				vLecture = selectLecture(vuserinfo, keyboard);
				break;
			case 1:
				if (vLecture != null) {
					pMiridamgi.goBasket(vuserinfo,vLecture, keyboard);
					vLecture = null;
				} else {
					System.out.println("강의를 먼저 선택해주세요.");
				}
				break;
			case 2: //수강신청
				if (vLecture != null) {
					pSincheng.goSincheng(vLecture, vuserinfo, keyboard);
					vLecture = null;
				} else {
					System.out.println("강의를 먼저 선택해주세요.");
				}
				break;
			case 3: //장바구니 보기
				pMiridamgi.loadBasket(vuserinfo.getUserID(), vuserinfo);
				pMiridamgi.showBasket(keyboard, vuserinfo.getUserID(), vLecture, vuserinfo);
                 break;
			case 4:
				pSincheng.loadSincheng(vuserinfo.getUserID(), vuserinfo);
				pSincheng.showSincheng(keyboard, vuserinfo.getUserID(), vuserinfo);
				break;
			case 9: //종료
				BRunning = false;
				break;
			default:
					break;
		}
 }
		System.exit(0);
 }

	private VLecture selectLecture(VUserInfo vuserinfo, Scanner keyboard) {
		return pLectureSelection.selectLecture(vuserinfo, keyboard);
	}
	}
