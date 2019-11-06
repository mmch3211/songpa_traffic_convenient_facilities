package kosta.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.sound.midi.ControllerEventListener;
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
	JMenuItem  parking=new JMenuItem("주차장");
	JMenuItem  carwash=new JMenuItem("세차장");
	JMenuItem  charging=new JMenuItem("충전소");

	JMenuItem  quit=new JMenuItem("종료");
	JMenuBar mb=new JMenuBar();
		
	String [] nameCarwash={"사업장명", "사업장업종명", "세차유형", "소재지도로명주소", "세차장전화번호", "데이터기준일"};
	String [] nameCharging = {"충전소명", "충전소위치", "이용가능시작시간", "이용가능종료시각", "급속충전타입구분", "주차료부과", "소재지도로명주소"};
	String [] nameParking = {"주차장이름", "소재지도로명주소", "주차구획수", "운영시작시간", "운영종료시간", "주차기본시간", "주차기본요금", "주차장전화번호"};
	DefaultTableModel dt= new DefaultTableModel(nameCarwash,0) {
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
	String [] comboName={" 도로명 "};//검색항목
	
	JComboBox combo = new JComboBox(comboName);
	JTextField jtf = new JTextField(20);
	JButton search = new JButton("검색");
	JButton using = new JButton("이용가능");
	JButton defaultValue = new JButton("초기화면");
	
/**
	화면구성 및 이벤트등록

*/
	public JTableView(){
		super("DB연동");
		
		m.add(parking);
		m.add(carwash);
		m.add(charging);

		m.add(quit);
		mb.add(m);

		
		setJMenuBar(mb);//프레임위에 메뉴바를 올림
		
		//South영역
		
		p.setBackground(Color.GREEN);
		p.add(combo);
		p.add(jtf);
		p.add(search);
		p.add(using);
		p.add(defaultValue);
		
		add(jsp, "Center");
		add(p, "South");

		//DB에 데이터 가져와서 화면에 반영
		//controller -> service -> dao
		

		dt.setColumnIdentifiers(nameParking);
		List<Vector<Object>> list = ConvenientFacilitiesController.getSelectPK();
		this.addRowTable(list);
		
		
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);

	
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		이벤트등록
		parking.addActionListener(this);
		carwash.addActionListener(this);
		charging.addActionListener(this);
		search.addActionListener(this);
		defaultValue.addActionListener(this);
		using.addActionListener(this);
		
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
		 
		if(target == parking) {
			dt.setColumnIdentifiers(nameParking);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectPK();
			this.addRowTable(list);
		}else if(target == carwash){
			dt.setColumnIdentifiers(nameCarwash);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectWS();
			this.addRowTable(list);
		}else if(target == charging) {
			dt.setColumnIdentifiers(nameCharging);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectELC();
			this.addRowTable(list);
			
		}else if (target == search) {
			System.out.println("search call");
			
			String keyWord = jtf.getText().trim();


			if(keyWord.equals("")) {
				FailView.errorMessage("검색단어를 입력해주세요");
				jtf.requestFocus();
				return;
			}
			
			
			
			if(jt.getColumnName(0).equals("주차장이름")){
//				System.out.println(1);
				String category = "주차장";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSearchByAddr1(category, keyWord);
				this.addRowTable(list);
			}else if(jt.getColumnName(0).equals("사업장명")) {
				String category = "세차장";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSearchByAddr1(category, keyWord);
				this.addRowTable(list);
			}else  {
				String category = "충전소";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSearchByAddr1(category, keyWord);
				this.addRowTable(list);
			}
		}else if(target == defaultValue) {
			dt.setColumnIdentifiers(nameParking);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectPK();
			this.addRowTable(list);
		}

		else {
//			System.out.println("이용 버튼");
			String category = null;
			if(jt.getColumnName(0).equals("주차장이름")){
//				System.out.println("주차장");
				category = "주차장";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectByUsingNow(category);
				this.addRowTable(list);
			}else if(jt.getColumnName(0).equals("사업장명")) {
//				System.out.println("세차장");
				FailView.errorMessage("이용시간에 대한 데이터 준비중입니다.");
			}else  {
//				System.out.println("충전소");
				category = "충전소";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectByUsingNow(category);
				this.addRowTable(list);
			}
			
		}

//		
	}

}
