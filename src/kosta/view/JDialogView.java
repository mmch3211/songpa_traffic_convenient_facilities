package kosta.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kosta.controller.ConvenientFacilitiesController;
import kosta.dto.UserListDTO;



public class JDialogView extends JDialog implements ActionListener{
	JPanel pw=new JPanel(new GridLayout(4,1));
	JPanel pc=new JPanel(new GridLayout(4,1));
	JPanel ps=new JPanel();

	JLabel lableId = new JLabel("ID");
	JLabel lablePassword=new JLabel("��й�ȣ");
	JLabel lableName=new JLabel("�̸�");
	JLabel lableAddr=new JLabel("�ּ�");


	JTextField id=new JTextField();
	JTextField password=new JTextField();
	JTextField name=new JTextField();
	JTextField addr=new JTextField();
	

	JButton confirm;
	JButton reset=new JButton("���");

   JTableView JTableView;

   JPanel idCkP =new JPanel(new BorderLayout());
   JButton idCkBtn = new JButton("IDCheck");
   
  //idüũ�� �ߴ��� ���ߴ��� Ȯ�����ִ� ���º��� (true�̸� üũ����(�ߺ��ƴ�))
   boolean idCheckState = false;

	public JDialogView(JTableView JTableView, String index){
		super(JTableView,"ȸ������");
		
		this.JTableView=JTableView;
		
		if(index.equals("ȸ������")){
			confirm=new JButton(index);
		}
//		else{
//			confirm=new JButton("����");	
//			
//			//���õ� ���� �� ���� ���� �о textField�� �ֱ�
//			int row = userJTableView.jt.getSelectedRow();
//			id.setText(userJTableView.jt.getValueAt(row, 0).toString());
//			name.setText(userJTableView.jt.getValueAt(row, 1).toString());
//			age.setText(userJTableView.jt.getValueAt(row, 2).toString());
//			addr.setText(userJTableView.jt.getValueAt(row, 3).toString());
//			
//			
//			//id text�ڽ� ��Ȱ��
//			id.setEditable(false);
//	
//			//IDCheck��ư ��Ȱ��ȭ
//			idCkBtn.setEnabled(false);
//		}
		
		
		//Label�߰��κ�
		pw.add(lableId);//ID
		pw.add(lablePassword);//���ӹй�ȣ
		pw.add(lableName);//�̸�
		pw.add(lableAddr);//�ּ�
	
		
		idCkP.add(id,"Center");
		idCkP.add(idCkBtn,"East");
		
		//TextField �߰�
		pc.add(idCkP);
		pc.add(password);
		pc.add(name);
		pc.add(addr);
		
		
		
		ps.add(confirm); 
		ps.add(reset);
	
		add(pw,"West"); 
		add(pc,"Center");
		add(ps,"South");
		
		setSize(400,300);
		setVisible(true);

		//xŬ�������� â�ݱ�
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ���
        confirm.addActionListener(this); //����/���� �̺�Ʈ���
        reset.addActionListener(this); //��� �̺�Ʈ���
        idCkBtn.addActionListener(this);// ID�ߺ�üũ �̺�Ʈ ���
		
	}//�����ڳ�
    
	/**
	 * ����/����/���/IDCheck ��ɿ� ���� �κ�
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if(label.equals("ȸ������")) {
			//��ȿ�� üũ (id, name, age, addr) 
			if(isValidate(id,password,name,addr)) {
				if(idCheckState) {
					UserListDTO dto = new UserListDTO(id.getText(), password.getText(), name.getText(), addr.getText());
					if(ConvenientFacilitiesController.userListInsert(dto) > 0) {
						//����â �ݱ�, ����â�� �ݿ�
						SuccessView.successMessage("ȸ������ �Ϸ�!");
						this.dispose();//����â �ݱ�
					}
				}else {
					FailView.errorMessage("id�ߺ�üũ�� ���ּ���.");
					id.requestFocus();
				}
			}
		}else if(label.equals("IDCheck")) {

			String idValue = id.getText();
			if(idValue.equals("")) {
				FailView.errorMessage("���̵� �Է����ּ���.");
				id.requestFocus();
				return;
			}
//			controller -> service -> dao ���� ��� �޴´�.
			if(ConvenientFacilitiesController.getCheckById(idValue)) {
				FailView.errorMessage(idValue + "�� �ߺ��Դϴ�.");
				id.setText("");
				id.requestFocus();
				return;
					
			}else {
				SuccessView.successMessage(idValue + "�� ��밡���մϴ�.");
				idCheckState = true;
			}
//			
//		}
		}else {
			this.dispose();
		}
		
	}//actionPerformed��
	
	/**TextField ��ȿ�� üũ�ϱ�
	 * true ����, false ����
	 */
	public boolean isValidate(JTextField ... text) {
		
		for(JTextField t : text) {
			if(t.getText().equals("")) {
				FailView.errorMessage("���� �Է��ϼ���");
				t.requestFocus();
				return false;
			}
		}
		
		
		return true;
	}
	
	
	
}//Ŭ������
