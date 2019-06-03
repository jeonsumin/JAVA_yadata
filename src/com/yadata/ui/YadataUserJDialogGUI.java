package com.yadata.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.yadata.persistence.YadataUserDefaultJTableDAO;

public class YadataUserJDialogGUI extends JDialog 
implements ActionListener {
    JPanel pw=new JPanel(new GridLayout(4,1));//4행 1열
    JPanel pc=new JPanel(new GridLayout(4,1));
    JPanel ps=new JPanel();//패널 기본레이아웃은 플로우레
    //이아웃
    
    JLabel label_Id=new JLabel("ID");
    JLabel label_Pwd=new JLabel("pwd");
    JLabel label_Name=new JLabel("name");
    JLabel label_E_mail=new JLabel("e_mail");
    
    public JTextField id=new JTextField();
    public JTextField pwd=new JTextField();
    public JTextField name=new JTextField();
    public JTextField e_mail=new JTextField();
    
    JButton confirm;
    JButton reset=new JButton("취소");
    YadataMenuJTableExam me;
    
    JPanel idCkP=new JPanel(new BorderLayout());
    JButton idCkBtn=new JButton("IDCheck");
    
    YadataUserDefaultJTableDAO ydao=new YadataUserDefaultJTableDAO();
    
    public YadataUserJDialogGUI(YadataMenuJTableExam me,String index){
    super(me,"회원정보 수정");
    this.me=me;
    
    if(index.equals("수정완료")) {
       confirm=new JButton("수정완료");
   
       
       int row=me.jt.getSelectedRow();//선택된 행번호
       id.setText(me.jt.getValueAt(row,0).toString());
//아이디 입력박스에 JTable회원목록의 선택된 행의 첫번째 열
// 회원아이디를 문자열로 가져와 출력      
    pwd.setText(me.jt.getValueAt(row,1).toString());
    name.setText(me.jt.getValueAt(row,2).toString());
    e_mail.setText(me.jt.getValueAt(row,3).toString());
    
    id.setEditable(false);//정보수정에서 아이디를 수정못
    //하게 입력박스를 비 활성화
    idCkBtn.setEnabled(false);//id중복검색 버튼을 비활성
    }//if else    
    
    pw.add(label_Id); pw.add(label_Pwd);
    pw.add(label_Name); pw.add(label_E_mail);
    
    idCkP.add(id,"Center"); idCkP.add(idCkBtn,"East");
    pc.add(idCkP); pc.add(pwd); pc.add(name);
    pc.add(e_mail);
    ps.add(confirm); ps.add(reset);//2개 버튼이 플로우 레
    //이아웃으로 배치
    
    add(pw,"West"); add(pc,"Center"); add(ps,"South");
    //각 패널을 프레임 추가
    
    setSize(300,250); setVisible(true);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    //JDialog 닫는다.
    
    confirm.addActionListener(this);
    reset.addActionListener(this);
    idCkBtn.addActionListener(this);//3개 버튼 이벤트등록
   }//생성자 오버로딩
    
   @Override
   public void actionPerformed(ActionEvent e) {
      String btnLabel=e.getActionCommand();//버튼위 캡
      //션문자열
      if(btnLabel.equals("IDCheck")) {//아이디 중복검색
         if(id.getText().trim().equals("")) {
//아이디 입력박스 아이디값 양쪽공백을 제거해서 빈공백일때
            messageBox(this,"ID를 입력하세요!");
            id.requestFocus();//아이디입력박스 포커
            //스 이동
         }else {//아이디가 입력된 경우
            if(ydao.getIdByCheck(id.getText())) {
               //==true생략,중복아이디가 없는 경우
     messageBox(this,id.getText()+"는 사용가능합니다!");   
     name.requestFocus();     
            }else {//중복아이디가 있는 경우
     messageBox(this,id.getText()+"는 중복입니다!");
                 id.setText("");//아이디 입력박스 초기화
                 id.requestFocus();
            }
         }//if else
      }else if(btnLabel.equals("수정")) {
         if(ydao.userUpdate(this)>0) {
            messageBox(this,"수정 성공했습니다!");
            dispose();
            ydao.userSelectAll(me.dt);
            if(me.dt.getRowCount()>0) {
               me.jt.setRowSelectionInterval(0,0);
            }//if
         }else {
            messageBox(this,"수정 실패했습니다!");
         }//if else
      }else if(btnLabel.equals("취소")) {
         dispose();
      }
   }//이벤트 발생시 호출
   
   public static void messageBox(Object obj,String m) {
     JOptionPane.showMessageDialog((Component)obj,m);      
   }//메시지 박스
}