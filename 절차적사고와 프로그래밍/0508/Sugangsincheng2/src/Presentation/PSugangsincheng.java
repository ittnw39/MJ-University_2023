package Presentation;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import Controller.CIndex;

import valueObject.VIndex;

import valueObject.VUserInfo;

public class PSugangsincheng {

	private CIndex cIndex;
	
	public PSugangsincheng() {
		this.cIndex = new CIndex();

	}

	private String selectIndex(String message, String fileName, Scanner keyboard) {
		System.out.println("캠퍼스 코드를 입력하세요.");
		Vector<VIndex> vIndexVector =  cIndex.getVIndexVector(fileName);
		for (VIndex vIndex: vIndexVector) {
			System.out.println(vIndex.getCode() + " " + vIndex.getName());
		}
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		//iCode ==> selectedIndex
		int selectedIndex = 0;
		String selectedFileName = vIndexVector.get(selectedIndex).getFilename();
		return selectedFileName;
	}
	

	
	public void run(VUserInfo vUserinfo, Scanner keyboard) {
		String campusFileName = this.selectIndex("캠퍼스 코드를 입력하세요.", "root", keyboard);
		String collegeFileName = this.selectIndex("대학 코드를 입력하세요.", campusFileName, keyboard);
		String departmentFileName = this.selectIndex("학과 코드를 입력하세요.", collegeFileName, keyboard);
	}
	
}
