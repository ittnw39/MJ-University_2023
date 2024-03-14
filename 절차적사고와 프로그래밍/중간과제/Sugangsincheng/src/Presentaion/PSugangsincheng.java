package Presentaion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import value.VGangjwa;
import value.VUserInfo;

public class PSugangsincheng {
	private VUserInfo vuserinfo;
	private VGangjwa selectedGangjwa;
	private Scanner scanner;
	private ArrayList sinchengList;
	private ArrayList<String> jungbokList;

	public PSugangsincheng(VUserInfo vuserinfo) {
		this.vuserinfo = vuserinfo;
		System.out.println(vuserinfo.getName() + "님 안녕하세요.");
		 this.jungbokList = new ArrayList<String>();
		selectCampus();
	}
	private void selectCampus() {
		try {
			Scanner campusFile = new Scanner(new File("data/root.txt"));
			while (campusFile.hasNextLine()) {
				String line = campusFile.nextLine();
				String[] parts = line.split(" ");
				System.out.println(parts[0] + " " + parts[1]);
			}
			
			System.out.println("3 로그아웃");
			System.out.print(">> ");
			scanner = new Scanner(System.in);
			String campusCode = scanner.nextLine();

			Scanner campusFile2 = new Scanner(new File("data/root.txt"));
			boolean found = false;

			while (campusFile2.hasNextLine()) {
				String line = campusFile2.nextLine();
				String[] parts = line.split(" ");

				if (parts[0].equals(campusCode)) {
					found = true;
					String campusName = parts[2];
					System.out.println(parts[1] + "캠퍼스를 선택하였습니다.\n");

					Scanner campusScanner = new Scanner(new File("data/" + campusName + ".txt"));

					while (campusScanner.hasNextLine()) {
						String campusLine = campusScanner.nextLine();
						String[] campusParts = campusLine.split(" ");
						System.out.println(campusParts[0] + " " + campusParts[1]);
					}
					//////
					System.out.print(">> ");
					scanner = new Scanner(System.in);
					String daehakCode = scanner.nextLine();

					selectDaehak(campusName, daehakCode);

					break;
				}
			}
			if (campusCode.equals("3")) {
	            System.out.println("로그아웃합니다.");
	            System.exit(0);
	        }
			
			if (!found) {
	            System.out.println("존재하는 캠퍼스 코드를 입력해주세요.");
	            selectCampus();
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void selectDaehak(String campusName, String daehakCode) {
		try {
			Scanner daehakFile = new Scanner(new File("data/" + campusName + ".txt"));
			boolean found2 = false;

			while (daehakFile.hasNextLine()) {
				String line2 = daehakFile.nextLine();
				String[] parts2 = line2.split(" ");

				if (parts2[0].equals(daehakCode)) {
					found2 = true;
					String daehakName = parts2[2];
					System.out.println(parts2[1] + "을 선택하였습니다.\n");

					Scanner daehakScanner = new Scanner(new File("data/" + daehakName + ".txt"));

					while (daehakScanner.hasNextLine()) {
						String daehakLine = daehakScanner.nextLine();
						String[] daehakParts = daehakLine.split(" ");
						System.out.println(daehakParts[0] + " " + daehakParts[1]);
					}
					/////
					System.out.print(">> ");
					scanner = new Scanner(System.in);
					String hakgwaCode = scanner.nextLine();

					Scanner hakgwaFile = new Scanner(new File("data/" + daehakName + ".txt"));
					boolean found3 = false;

					while (hakgwaFile.hasNextLine()) {
						String line3 = hakgwaFile.nextLine();
						String[] parts3 = line3.split(" ");

						if (parts3[0].equals(hakgwaCode)) {
							found3 = true;
							String hakgwaName = parts3[2];
							System.out.println(parts3[1] + "을 선택하였습니다.\n");

							Scanner hakgwaScanner = new Scanner(new File("data/" + hakgwaName + ".txt"));

							while (hakgwaScanner.hasNextLine()) {
								String hakgwaLine = hakgwaScanner.nextLine();
								String[] hakgwaParts = hakgwaLine.split(" ");
								System.out.println(hakgwaParts[0] + " " + hakgwaParts[1] + " " + hakgwaParts[2] + " "
										+ hakgwaParts[3] + "학점 " + hakgwaParts[4]);
							}
							System.out.print(">> ");
							scanner = new Scanner(System.in);
							String gangjwaCode = scanner.nextLine();

							Scanner selectedGangjwaScanner = new Scanner(new File("data/" + hakgwaName + ".txt"));
							boolean found4 = false;

							while (selectedGangjwaScanner.hasNextLine()) {
								String line4 = selectedGangjwaScanner.nextLine();
								String[] parts4 = line4.split(" ");

								if (parts4[0].equals(gangjwaCode)) {
									found4 = true;
									char gc = gangjwaCode.charAt(gangjwaCode.length() - 1);
									gangjwaCode = hakgwaCode + gc;
									String gangjwaName = parts4[1];
									String gyosuName = parts4[2];
									int hakjum = Integer.parseInt(parts4[3].substring(0, 1));
									String time = parts4[4];
									selectedGangjwa = new VGangjwa(gangjwaCode, gangjwaName, gyosuName, hakjum, time);
									
									if (jungbokList.contains(gangjwaCode) || jungbokList.contains(gangjwaName) || jungbokList.contains(time)) {
					                    System.out.println("[ " + gangjwaCode + " ] << 이미 신청되었거나 시간이 겹치는 강좌입니다.");
					                }else {
									if (this.sinchengList == null) {
								        this.sinchengList = new ArrayList<>();
								    }
								    sinchengList.add(selectedGangjwa);
								    jungbokList.add(gangjwaCode);
								    jungbokList.add(gangjwaName);
								    jungbokList.add(time);
									System.out.println("\n[ " + selectedGangjwa + " ] << 수강신청 되었습니다.\n");
					                
								}
								}
							}
							break;
						}
					}
					break;
				}
			}

			System.out.println("\n1. 수강신청 목록 보기");
			System.out.println("2. 캠퍼스 선택하기");
			System.out.println("3. 로그아웃\n");
			System.out.print(">> ");

			scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println(sinchengList + "\n");
				selectCampus();
				break;
			case 2:
				selectCampus();
				break;
			case 3:
				System.out.println("로그아웃 되었습니다.");
		        vuserinfo = null;
		        return;
			default:
				System.out.println("존재하는 캠퍼스 코드를 입력해주세요.");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void run() {

	}
}
