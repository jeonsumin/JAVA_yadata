package com.yadata.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.yadata.persistence.YadataUserDefaultJTableDAO;

public class YadataMenuJTableExam extends JFrame 
implements ActionListener {
	JMenuBar mb=new JMenuBar();

	JMenu m=new JMenu("회원관리");
	//  JMenuItem insert=new JMenuItem("회원가입");
	JMenuItem update=new JMenuItem("회원수정");
	JMenuItem delete=new JMenuItem("회원삭제");
	JMenuItem quit=new JMenuItem("종료");

	JMenu y1=new JMenu("예약자 명단");
	JMenuItem memlist = new JMenuItem("예약명단자");


	String[] name= {"아이디","pwd","name","e_mail"};
	String[] namey1= {"Pdate","Rdate","Ploc","Rloc","carkind","carprice2","insurprice" 
			,"id","name","birth","email","licencek","licencenum","totalP"};
	//테이블 열이름을 문자열 배열로 초기화
	DefaultTableModel dt; //=new DefaultTableModel(name,0);
	//name은 테이블 열이름, 0은 테이블이 보관유지하는 행수
	DefaultTableModel dt2;

	JTable jt; //=new JTable(dt);
	JScrollPane jsp; //=new JScrollPane(jt);
	//표테이블 자료가 많을 경우 스크롤바가 나타나게 됨

	/*프레임 남쪽에 배치될 검색 */
	JPanel p=new JPanel();
	JPanel p2=new JPanel();
	String[] comboName= 
		{" ALL "," ID "," NAME "," 예약현황 "};
	JComboBox combo=new JComboBox(comboName);

	String[] comboName2= 
		{" ALL "," ID "};
	JComboBox combo2=new JComboBox(comboName2);

	JTextField jtf=new JTextField(20);//검색 입력필드
	JButton search=new JButton("검색");

	YadataUserDefaultJTableDAO ydao=new YadataUserDefaultJTableDAO();

	@SuppressWarnings("serial")
	public YadataMenuJTableExam() {
		super("회원관리 프로그램");//프레임 제목
		setJMenuBar(mb);//프레임 윈도우에 메뉴바 붙임

		mb.add(m);//메뉴바에 메뉴추가
		mb.add(y1);

		// m.add(insert);
		m.add(update); m.add(delete);
		m.add(quit);//메뉴에 항목추가
		y1.add(memlist);

		//  insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		quit.addActionListener(this);
		memlist.addActionListener(this);//각 메뉴항목 이벤트등록

		p.setBackground(Color.yellow);//패널 배경색 노랑
		p.add(combo); p.add(jtf); p.add(search);//패널에
		//검색 컴포넌트 추가

		dt = new DefaultTableModel(name, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}
		};//익명클래스 문법으로 dt=>JTable셀 내용 수정불가



		jt=new JTable(dt);
		jt.getColumnModel().getColumn(0).setPreferredWidth(30); 
		//JTable 의 컬럼 길이 조절
		jt.getColumnModel().getColumn(1).setPreferredWidth(30);
		jt.getColumnModel().getColumn(2).setPreferredWidth(10);
		jt.getColumnModel().getColumn(3).setPreferredWidth(200);
		//각 JTable 컬럼 길이 조절

		jsp=new JScrollPane(jt);

		add(jsp,"Center");//보더레이아웃으로 프레임 중앙에
		//JScrollPane추가(JTable)
		add(p,"South");

		search.addActionListener(this);//검색버튼 이벤트등록

		setSize(800,500); setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면 사이즈
		Dimension mySize = getSize();// 띄우는 창 사이즈
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
		// 창을 중앙에서 나오게함

		ydao.usermemberAll(dt);//오라클의 모든 회원검색

		if(dt.getRowCount()>0) {//디폴드 테이블 모델에 회원
			//목록이 있다면
			jt.setRowSelectionInterval(0,0);//첫번째 행을 선택		  
		}
	}//생성자

	@Override
	public void actionPerformed(ActionEvent e){
		/*   if(e.getSource()==insert) {//가입 메뉴항목을 선택
    	  new YadataUserJDialogGUI(this,"가입");//오버로딩된
    	  //생성자를 호출하면서 회원가입창을 띄움
      }else   */
		if(e.getSource() == memlist) {
			//System.out.println("예약자 명단");
			//  setTitle("예약자 명단");
			// p.add(combo2);
			// p.remove(jtf); p.remove(search);
			//p.add(combo2);
			//  add(p,"South");

			//  dt2 = new DefaultTableModel(namey1, 0) {
			//	    @Override
			//	    public boolean isCellEditable(int row, int column) {
			//	        if (column >= 0) {
			//	            return false;
			//        } else {
			//            return true;
			//        }
			//    }
			//	};//익명클래스 문법으로 dt=>JTable셀 내용 수정불가
			dispose();
			new YadataReserveList();
		}

		if(e.getSource()==update) {//정보수정
			new YadataUserJDialogGUI(this,"수정");
		}else if(e.getSource()==delete) {//삭제
			int row=jt.getSelectedRow();//선택된 행번호
			Object obj=jt.getValueAt(row,0);//선택된 행의
			//첫번째 열 아이디값을 가져옴.

			if(ydao.userDelete(obj.toString())>0) {
				YadataUserJDialogGUI.messageBox(this,"회원삭제에 성공했습니다!");
				ydao.userSelectAll(dt);

				if(dt.getRowCount() > 0) {
					jt.setRowSelectionInterval(0,0);
				}//if
			}else {
				YadataUserJDialogGUI.messageBox(this,"삭제에 실패했습니다!");    		  
			}//if else
		}else if(e.getSource()==quit) {
			System.exit(0);//프레임 윈도우 창 닫기
		}else if(e.getSource() == search) {//검색버튼 실행
			String fieldName=combo.getSelectedItem().toString();
			//콤보박스목록 항목이름를 구함
			if(fieldName.trim().equals("ALL")) {//전체검색
				ydao.userSelectAll(dt);
				if(dt.getRowCount()>0) {
					jt.setRowSelectionInterval(0,0);
				}
			}else {//전체 검색이 아닌경우
				if(jtf.getText().trim().equals("")) {
					YadataUserJDialogGUI.messageBox(this,"검색어를 입력!");
					jtf.requestFocus();//검색입력창으로 커서이동
				}else {//검색어를 입력한 경우
					ydao.getUserSearch(dt,fieldName,jtf.getText());
					//회원테이블로 부터 검색
					if(dt.getRowCount()>0) {
						jt.setRowSelectionInterval(0,0);
					}
				}
			}//if else
		}
	}//이벤트 발생시 호출
	public static void main(String[] args) {
		new YadataMenuJTableExam();//생성자 호출
	}
}