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
import kosta.dto.UserListDTO;


public class JTableView  extends JFrame implements ActionListener{
	
	UserListDTO dto;

	
	
	JMenu m = new JMenu("���");
	JMenu m2 = new JMenu("����");
	JMenuItem login = new JMenuItem("�α���");
	JMenuItem insert = new JMenuItem("ȸ������");
	JMenuItem logout = new JMenuItem("�α׾ƿ�");
	JMenuItem  parking=new JMenuItem("������");
	JMenuItem  carwash=new JMenuItem("������");
	JMenuItem  charging=new JMenuItem("������");
	JMenuItem bookmark = new JMenuItem("���ã��");
	JMenuItem  quit=new JMenuItem("����");
	JMenuBar mb=new JMenuBar();
		
	String [] nameCarwash={"������", "����������", "��������", "���������θ��ּ�", "��������ȭ��ȣ", "�����ͱ�����"};
	String [] nameCharging = {"�����Ҹ�", "��������ġ", "�̿밡�ɽ��۽ð�", "�̿밡������ð�", "�޼�����Ÿ�Ա���", "������ΰ�", "���������θ��ּ�"};
	String [] nameParking = {"�������̸�", "���������θ��ּ�", "������ȹ��", "����۽ð�", "�����ð�", "�����⺻�ð�", "�����⺻���", "��������ȭ��ȣ"};
	String[] nameBookmark = {"ID","���ǽü���", "���������θ��ּ�"};
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
	JButton bookmarkBtn = new JButton("���ã�� �߰�");
/**
	ȭ�鱸�� �� �̺�Ʈ���

*/
	public JTableView(){
		super("DB����");
		
		m.add(parking);
		m.add(carwash);
		m.add(charging);
		m.add(bookmark);
		m.add(quit);
		
		m2.add(insert);
		m2.add(login);
		m2.add(logout);
		
		mb.add(m);
		mb.add(m2);
		
		setJMenuBar(mb);//���������� �޴��ٸ� �ø�
		
		//South����
		
		p.setBackground(Color.GREEN);
		p.add(bookmarkBtn);
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
		bookmark.addActionListener(this);
		login.addActionListener(this);
		logout.addActionListener(this);
		insert.addActionListener(this);
		bookmarkBtn.addActionListener(this);
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
//    public void addRowTable2(List<Vector<Object>> list) {
//    	dt.setRowCount(0);
//    	Vector<Object> v = new Vector<Object>();
//    	if(list.size()>0) {
//	    	for(int i = 0; i <list.size(); i++) {
//	    		v.add(list.get(i).get(1));
//	    		v.add(list.get(i).get(2));
//	    		
//	    		dt.addRow(v);
//
//	    	}
//	    	
//	    	jt.setRowSelectionInterval(0, 0);
//    	}
//    }


	/**
     * ����/����/����/�˻������ ����ϴ� �޼ҵ�
     * */
		
	public void actionPerformed(ActionEvent e) {
		Object target = e.getSource(); //�̺�Ʈ�� �߻���Ű�� ��ü
		 
		if(target == parking) {//������
			dt.setColumnIdentifiers(nameParking);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectPK();
			this.addRowTable(list);
		}else if(target == carwash){//������
			dt.setColumnIdentifiers(nameCarwash);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectWS();
			this.addRowTable(list);
		}else if(target == charging) {//������
			dt.setColumnIdentifiers(nameCharging);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectELC();
			this.addRowTable(list);
			
		}else if (target == search) {//�ּҰ˻�
			
			String keyWord = jtf.getText().trim();
			if(keyWord.equals("")) {
				FailView.errorMessage("�˻��ܾ �Է����ּ���");
				jtf.requestFocus();
				return;
			}
			
			
			
			if(jt.getColumnName(0).equals("�������̸�")){
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
		}else if(target == defaultValue) {//�ʱ�ȭ��
			dt.setColumnIdentifiers(nameParking);
			List<Vector<Object>> list = ConvenientFacilitiesController.getSelectPK();
			this.addRowTable(list);
		}else if(target == bookmark) {//���ã��
			System.out.println("���ã��");
			//dto.getid�� id������ �� ���� ����Ʈ�� �޾Ƽ� �ξƾƾ� �Ѹ���.
			if(dto == null) {
				FailView.errorMessage("�α��� �� ������ּ���.");
			}
			List<Vector<Object>> list = ConvenientFacilitiesController.getFavoriteList(dto.getId());
			dt.setColumnIdentifiers(nameBookmark);
			this.addRowTable(list);

			
		}else if(target == insert) {//ȸ������
			new JDialogView(this, "ȸ������");
		}else if(target == login) {//�α���
			new LoginJDialogView(this, "�α���");

		}else if(target == logout) {//�α׾ƿ�
			System.out.println("�α׾ƿ�");
			dto = null;
			SuccessView.successMessage("�α׾ƿ� �Ǿ����ϴ�.");
		}else if(target == bookmarkBtn) { //���ã���߰�
			System.out.println("���ã�� �߰�");
			int row =0;
			String name = null;
			String addr = null;
			
			if(dto == null) {
				FailView.errorMessage("�α��� �� ������ּ���.");
			}
			
			if(jt.getColumnName(0).equals("�������̸�")){
				row = jt.getSelectedRow();
				name = jt.getValueAt(row, 0).toString();
				addr = jt.getValueAt(row, 1).toString();
				ConvenientFacilitiesController.favoriteUpdate(dto.getId(), name, addr);
				SuccessView.successMessage("���ã�� �߰�!");
//				System.out.println(row + " | " + name + " | " + addr);
			}else if(jt.getColumnName(0).equals("������")) {
				row = jt.getSelectedRow();
				name = jt.getValueAt(row, 0).toString();
				addr = jt.getValueAt(row, 3).toString();
				ConvenientFacilitiesController.favoriteUpdate(dto.getId(), name, addr);
				SuccessView.successMessage("���ã�� �߰�!");
			}else  {
				row = jt.getSelectedRow();
				name = jt.getValueAt(row, 0).toString();
				addr = jt.getValueAt(row, 6).toString();
				ConvenientFacilitiesController.favoriteUpdate(dto.getId(), name, addr);
				SuccessView.successMessage("���ã�� �߰�!");
			}

		}
		
		else {//�̿밡��
			String category = null;
			if(jt.getColumnName(0).equals("�������̸�")){
				category = "������";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectByUsingNow(category);
				this.addRowTable(list);
			}else if(jt.getColumnName(0).equals("������")) {
				FailView.errorMessage("�̿�ð��� ���� ������ �غ����Դϴ�.");
			}else  {
				category = "������";
				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectByUsingNow(category);
				this.addRowTable(list);
			}
			
		}

	
//		
	}
	public void setDTO(UserListDTO dto) {
		this.dto = dto;
	}
	
	

}
