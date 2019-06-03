package com.yadata.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.yadata.persistence.YadataUserDefaultJTableDAO;

public class YadataReserveList extends JDialog implements ActionListener{

	String[] name= {"Pdate","Rdate","Ploc","Rloc","carkind","carprice2","insurprice" 
		,"id","name","birth","email","licencek","licencenum","totalP"};

	DefaultTableModel dt;

	JTable jt; //=new JTable(dt);
	JScrollPane jsp; //=new JScrollPane(jt);
	//표테이블 자료가 많을 경우 스크롤바가 나타나게 됨

	JPanel p=new JPanel();

	String[] comboName= 
		{" ALL "," 아이디 "};
	JComboBox combo=new JComboBox(comboName);

	JTextField jtf=new JTextField(20);//검색 입력필드
	JButton search=new JButton("검색");


	YadataUserDefaultJTableDAO ydao = new YadataUserDefaultJTableDAO();

	public YadataReserveList() {
		setTitle("예약자 명단");

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
		jt.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jt.getColumnModel().getColumn(1).setPreferredWidth(50);
		jt.getColumnModel().getColumn(2).setPreferredWidth(50);
		jt.getColumnModel().getColumn(3).setPreferredWidth(50);
		jt.getColumnModel().getColumn(4).setPreferredWidth(50); 
		jt.getColumnModel().getColumn(5).setPreferredWidth(50);
		jt.getColumnModel().getColumn(6).setPreferredWidth(50);
		jt.getColumnModel().getColumn(7).setPreferredWidth(50);
		jt.getColumnModel().getColumn(8).setPreferredWidth(50); 
		jt.getColumnModel().getColumn(9).setPreferredWidth(50);
		jt.getColumnModel().getColumn(10).setPreferredWidth(50);
		jt.getColumnModel().getColumn(11).setPreferredWidth(50);
		jt.getColumnModel().getColumn(12).setPreferredWidth(50); 
		jt.getColumnModel().getColumn(13).setPreferredWidth(50);
		jt.getColumnModel().getColumn(14).setPreferredWidth(50);



		jsp=new JScrollPane(jt);

		add(jsp,"Center");//보더레이아웃으로 프레임 중앙에
		//JScrollPane추가(JTable)
		add(p,"South");

		search.addActionListener(this);//검색버튼 이벤트등록

		setSize(2000,500); setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면 사이즈
		Dimension mySize = getSize();// 띄우는 창 사이즈
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
		// 창을 중앙에서 나오게함

		ydao.userSelectAll(dt);//오라클의 모든 회원검색

		if(dt.getRowCount()>0) {//디폴드 테이블 모델에 회원
			//목록이 있다면
			jt.setRowSelectionInterval(0,0);//첫번째 행을 선택		  
		}

	} //생성자


	@Override
	public void actionPerformed(ActionEvent e) {
		//messageBox(this,"검색어를 입력!ee");
		//검색 
		if(e.getSource() == search) {
			String fieldName=combo.getSelectedItem().toString();
			//콤보박스목록 항목이름를 구함
			if(fieldName.trim().equals("아이디")) {
				fieldName = "r_id" ;
			}

			if(fieldName.trim().equals("ALL")) {//전체검색
				ydao.userSelectAll(dt);
				if(dt.getRowCount()>0) {
					jt.setRowSelectionInterval(0,0);
				}
			}else {//전체 검색이 아닌경우
				if(jtf.getText().trim().equals("")) {
					messageBox(this,"검색어를 입력!");
					jtf.requestFocus();//검색입력창으로 커서이동
				}else {//검색어를 입력한 경우
					ydao.getreserveSearch(dt,fieldName,jtf.getText());
					//회원테이블로 부터 검색
					if(dt.getRowCount()>0) {
						jt.setRowSelectionInterval(0,0);
					}
				}//if else
			}

		}

	}//actionPerformed();

	public static void messageBox(Object obj,String m) {
		JOptionPane.showMessageDialog((Component)obj,m);      
	}//메시지 박스
}