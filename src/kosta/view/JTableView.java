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
	JMenu m = new JMenu("���");
	JMenuItem  insert=new JMenuItem("������");
	JMenuItem  update=new JMenuItem("������");
	JMenuItem  delete=new JMenuItem("������");
	JMenuItem  use=new JMenuItem("�̿밡��");
	JMenuItem  quit=new JMenuItem("����");
	JMenuBar mb=new JMenuBar();
		
	String [] name={"������", "����������", "��������", "���������θ��ּ�", "��������ȭ��ȣ", "�����ͱ�����"};
	String [] name2 = {"�����Ҹ�", "��������ġ", "�̿밡�ɽ��۽ð�", "�̿밡������ð�", "�޼�����Ÿ�Ա���", "������ΰ�", "���������θ��ּ�"};
	
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
		South ������ �߰��� Componet��
	*/
	JPanel p= new JPanel();
	String [] comboName={"  ALL  "," ���θ� "};//�˻��׸�
	
	JComboBox combo = new JComboBox(comboName);
	JTextField jtf = new JTextField(20);
	JButton search = new JButton("�˻�");
	JButton using = new JButton("�̿�");
	
/**
	ȭ�鱸�� �� �̺�Ʈ���

*/
	public JTableView(){
		super("DB����");
		
		m.add(insert);
		m.add(update);
		m.add(delete);
		m.add(use);
		m.add(quit);
		mb.add(m);

		
		setJMenuBar(mb);//���������� �޴��ٸ� �ø�
		
		//South����
		
		p.setBackground(Color.GREEN);
		p.add(combo);
		p.add(jtf);
		p.add(search);
		p.add(using);
		add(jsp, "Center");
		add(p, "South");

		//DB�� ������ �����ͼ� ȭ�鿡 �ݿ�
		//controller -> service -> dao
		List<Vector<Object>> list = ConvenientFacilitiesController.getSelectWS();
		this.addRowTable(list);
		
		
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);

	
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		�̺�Ʈ���
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
		
//		if(target == insert) {//����
////			System.out.println("insert call");
//			new JDialogView(this, "����");
//		}else if(target == update) {//����
////			System.out.println("update call");
//			new JDialogView(this, "����");
//		}else if(target == delete) {//����
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
//		}else {//�˻�
//			//JComboBox ���õ� �׸�
//			String keyField = combo.getSelectedItem().toString().trim();
//			if(keyField.equals("ALL")) {
//				List<Vector<Object>> list = ConvenientFacilitiesController.getSelectAll();
//				this.addRowTable(list);
//			}else {
//				String keyWord = jtf.getText().trim();
//				if(keyWord.equals("")) {
//					FailView.errorMessage("�˻��ܾ �Է����ּ���");
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
