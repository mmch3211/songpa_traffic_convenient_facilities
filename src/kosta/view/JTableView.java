package kosta.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

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

import kosta.controller.ConvenientFacilitiesController;


public class JTableView  extends JFrame implements ActionListener{
	JMenu m = new JMenu("목록");
	JMenuItem  insert=new JMenuItem("주차장");
	JMenuItem  update=new JMenuItem("세차장");
	JMenuItem  delete=new JMenuItem("충전소");
	JMenuItem  use=new JMenuItem("이용가능");
	JMenuItem  quit=new JMenuItem("종료");
	JMenuBar mb=new JMenuBar();
		
	String [] name={"사업장명", "사업장업종명", "세차유형", "소재지도로명주소", "세차장전화번호", "데이터기준일"};
	String [] name2 = {"충전소명", "충전소위치", "이용가능시작시간", "이용가능종료시각", "급속충전타입구분", "주차료부과", "소재지도로명주소"};
	
	DefaultTableModel dt= new DefaultTableModel(name,0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	DefaultTableModel dt2= new DefaultTableModel(name2,0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	JTable jt=new JTable(dt);
	JScrollPane jsp=new JScrollPane(jt);
	
	/*
		South 영역에 추가할 Componet들
	*/
	JPanel p= new JPanel();
	String [] comboName={"  ALL  "," 도로명 "};//검색항목
	
	JComboBox combo = new JComboBox(comboName);
	JTextField jtf = new JTextField(20);
	JButton search = new JButton("검색");
	JButton using = new JButton("이용");
	
/**
	화면구성 및 이벤트등록

*/
	public JTableView(){
		super("DB연동");
		
		m.add(insert);
		m.add(update);
		m.add(delete);
		m.add(use);
		m.add(quit);
		mb.add(m);

		
		setJMenuBar(mb);//프레임위에 메뉴바를 올림
		
		//South영역
		
		p.setBackground(Color.GREEN);
		p.add(combo);
		p.add(jtf);
		p.add(search);
		p.add(using);
		add(jsp, "Center");
		add(p, "South");

		//DB에 데이터 가져와서 화면에 반영
		//controller -> service -> dao
		List<Vector<Object>> list = ConvenientFacilitiesController.getSelectWS();
		this.addRowTable(list);
		
		
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);

	
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		이벤트등록
		insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		search.addActionListener(this);
		
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		
		
	}//생성자끝
	
	
	/**
	 * DefaultTableModel에 DB에서 나온 결과를 추가하기
	 * */
    public void addRowTable(List<Vector<Object>> list) {
    	dt.setRowCount(0);
    	if(list.size()>0) {
	    	for(Vector<Object> v : list) {
	    		dt.addRow(v);
	    	}
	    	
	    	jt.setRowSelectionInterval(0, 0);
    	}
    }



	/**
     * 가입/수정/삭제/검색기능을 담당하는 메소드
     * */
		
	public void actionPerformed(ActionEvent e) {
		Object target = e.getSource(); //이벤트를 발생시키는 주체
		
//		if(target == insert) {//삽입
////			System.out.println("insert call");
//			new JDialogView(this, "가입");
//		}else if(target == update) {//수정
////			System.out.println("update call");
//			new JDialogView(this, "수정");
//		}else if(target == delete) {//삭제
///*			int[] rows = jt.getSelectedRows();
//			String[] ids = new String[rows.length];
//			for(int i = 0; i < rows.length; i++) {
//				ids[i] = jt.getValueAt(rows[i], 0).toString();
//			}
//			
//			UserListController.userListDelete(ids);
//			List<Vector<Object>> list = UserListController.getSelectAll();
//			this.addRowTable(list);
//	*/		
//			int[] rows = jt.getSelectedRows();
//			String[] ids = new String[rows.length];
//			for(int i = 0; i < ids.length; i++) {
//				String id = jt.getValueAt(rows[i], 0).toString();
//				ids[i] = id;
//			}
//			int result = ConvenientFacilitiesController.userListDelete(ids);
//			if(result == rows.length) {
//				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectAll();
//				this.addRowTable(list);
//			}
//			
//		}else {//검색
//			//JComboBox 선택된 항목
//			String keyField = combo.getSelectedItem().toString().trim();
//			if(keyField.equals("ALL")) {
//				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectAll();
//				this.addRowTable(list);
//			}else {
//				String keyWord = jtf.getText().trim();
//				if(keyWord.equals("")) {
//					FailView.errorMessage("검색단어를 입력해주세요");
//					jtf.requestFocus();
//					return;
//				}
//				
//				List<Vector<Object>>list = ConvenientFacilitiesController.;
//				if(list != null && list.size()>0) this.addRowTable(list);
//			}
//			
//		}
//		
	}

}
