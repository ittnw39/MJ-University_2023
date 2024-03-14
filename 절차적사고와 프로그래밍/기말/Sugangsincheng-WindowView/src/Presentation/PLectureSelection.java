package Presentation;

import java.util.Scanner;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Controller.CIndex;
import Controller.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection extends JPanel{
	
	private CLecture cLecture;
	
	private class PSelection extends JTable { //테이블은 항상 상속받기. 복잡하기 때문, 버튼은 그대로 써도 됨.
		private CIndex cIndex;
		public PSelection(String titleName, String fileName) {
			String[] title = new String[1];
//			String[][] row = new String[2][1]; //테이블이 하나면 리스트이다. 테이블을 쓰는 이유는 4개의 테이블을 똑같이 하나로 활용하기 위해서이다.
			title[0] = titleName;
			DefaultTableModel tableModel = new DefaultTableModel(title,0); //만들 때 모델을 붙임.
			this.setModel(tableModel);
			
			RowSelectionListener rowSelectionListener = new RowSelectionListener();
			this.getSelectionModel().addListSelectionListener(rowSelectionListener);

			this.cIndex = new CIndex();
			Vector<VIndex> vIndexVector =  cIndex.getVIndexVector(fileName);
			for (VIndex vIndex: vIndexVector) {
				String[] row = new String[1];
				row[0] = vIndex.getName();
				tableModel.addRow(row);	
			}
		}
	}
	
	private class RowSelectionListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				int firstIndex = e.getFirstIndex();
				System.out.println("first- " + firstIndex);
				int lastIndex = e.getLastIndex();
				System.out.println("last- " + lastIndex);
				}
			}
		}
	
	public PLectureSelection() {
		
		PSelection pCampus = new PSelection("캠퍼스", "root");
		JScrollPane scrollpane = new JScrollPane(pCampus);
		this.add(scrollpane);
		
		PSelection pCollege = new PSelection("대학", "root");
		scrollpane = new JScrollPane(pCollege);
		this.add(scrollpane);
		
		PSelection pDepartment = new PSelection("학과", "root");
		scrollpane = new JScrollPane(pDepartment);
		this.add(scrollpane);
		
		this.cLecture = new CLecture();
	}

	private String findIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요.");
	
		
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		
		 String selectedFileName = null;
		    
		 return selectedFileName;
	}
	
	public VLecture findLecture(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요.");
		Vector<VLecture> vLectureVector =  cLecture.getVLectureVector(fileName);
		for (VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
		
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		VLecture selectedVLecture = null;
	    for (VLecture vLecture: vLectureVector) {
	        if (vLecture.getCode() == iCode) {
	            selectedVLecture = vLecture;
	            break;
	        }
	    }

	    if (selectedVLecture == null) {
	        System.out.println("잘못된 코드가 입력되었습니다.");
	    }

	    return selectedVLecture;
	}
	
	public VLecture selectLecture(VUserInfo vUserinfo, Scanner keyboard) {
		String campusFileName = this.findIndex("캠퍼스", "root", keyboard);
		String collegeFileName = this.findIndex("대학", campusFileName, keyboard);
		String departmentFileName = this.findIndex("학과", collegeFileName, keyboard);
		
		VLecture vLecture = this.findLecture("강좌", departmentFileName, keyboard);
		
		return vLecture;
	}
}
