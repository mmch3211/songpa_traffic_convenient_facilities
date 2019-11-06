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
	JMenu m = new JMenu("���");
	JMenuItem  parking=new JMenuItem("������");
	JMenuItem  carwash=new JMenuItem("������");
	JMenuItem  charging=new JMenuItem("������");

	JMenuItem  quit=new JMenuItem("����");
	JMenuBar mb=new JMenuBar();
		
	String [] nameCarwash={"������", "����������", "��������", "���������θ��ּ�", "��������ȭ��ȣ", "�����ͱ�����"};
	String [] nameCharging = {"�����Ҹ�", "��������ġ", "�̿밡�ɽ��۽ð�", "�̿밡������ð�", "�޼�����Ÿ�Ա���", "������ΰ�", "���������θ��ּ�"};
	String [] nameParking = {"�������̸�", "���������θ��ּ�", "������ȹ��", "����۽ð�", "�����ð�", "�����⺻�ð�", "�����⺻���", "��������ȭ��ȣ"};
	DefaultTableModel dt= new DefaultTableModel(nameCarwash,0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	
	
	JTable jt=new JTable(dt);
	JScrollPane jsp=new JScrollPane(jt);
	
	/*
		South ������ �߰��� Componet��
	*/
	JPanel p= new JPanel();
	String [] comboName={" ���θ� "};//�˻��׸�
	
	JComboBox combo = new JComboBox(comboName);
	JTextField jtf = new JTextField(20);
	JButton search = new JButton("�˻�");
	JButton using = new JButton("�̿밡��");
	JButton defaultValue = new JButton("�ʱ�ȭ��");
	
/**
	ȭ�鱸�� �� �̺�Ʈ���

*/
	public JTableView(){
		super("DB����");
		
		m.add(parking);
		m.add(carwash);
		m.add(charging);

		m.add(quit);
		mb.add(m);

		
		setJMenuBar(mb);//���������� �޴��ٸ� �ø�
		
		//South����
		
		p.setBackground(Color.GREEN);
		p.add(combo);
		p.add(jtf);
		p.add(search);
		p.add(using);
		p.add(defaultValue);
		
		add(jsp, "Center");
		add(p, "South");

		//DB�� ������ �����ͼ� ȭ�鿡 �ݿ�
		//controller -> service -> dao
		

		dt.setColumnIdentifiers(nameParking);
		List<Vector<Object>> list = ConvenientFacilitiesController.getSelectPK();
		this.addRowTable(list);
		
		
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);

	
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		�̺�Ʈ���
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
		
		
	}//�����ڳ�
	
	
	/**
	 * DefaultTableModel�� DB���� ���� ����� �߰��ϱ�
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
     * ����/����/����/�˻������ ����ϴ� �޼ҵ�
     * */
		
	public void actionPerformed(ActionEvent e) {
		Object target = e.getSource(); //�̺�Ʈ�� �߻���Ű�� ��ü
		 
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
				FailView.errorMessage("�˻��ܾ �Է����ּ���");
				jtf.requestFocus();
				return;
			}
			
			
			
			if(jt.getColumnName(0).equals("�������̸�")){
//				System.out.println(1);
				String category = "������";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSearchByAddr1(category, keyWord);
				this.addRowTable(list);
			}else if(jt.getColumnName(0).equals("������")) {
				String category = "������";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSearchByAddr1(category, keyWord);
				this.addRowTable(list);
			}else  {
				String category = "������";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSearchByAddr1(category, keyWord);
				this.addRowTable(list);
			}
		}else if(target == defaultValue) {
			dt.setColumnIdentifiers(nameParking);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectPK();
			this.addRowTable(list);
		}

		else {
//			System.out.println("�̿� ��ư");
			String category = null;
			if(jt.getColumnName(0).equals("�������̸�")){
//				System.out.println("������");
				category = "������";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectByUsingNow(category);
				this.addRowTable(list);
			}else if(jt.getColumnName(0).equals("������")) {
//				System.out.println("������");
				FailView.errorMessage("�̿�ð��� ���� ������ �غ����Դϴ�.");
			}else  {
//				System.out.println("������");
				category = "������";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectByUsingNow(category);
				this.addRowTable(list);
			}
			
		}

//		
	}

}
