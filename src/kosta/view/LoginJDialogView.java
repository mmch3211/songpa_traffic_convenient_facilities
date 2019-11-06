package kosta.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kosta.controller.ConvenientFacilitiesController;
import kosta.dto.UserListDTO;



public class LoginJDialogView extends JDialog implements ActionListener{
	JPanel pw=new JPanel(new GridLayout(2,1));
	JPanel pc=new JPanel(new GridLayout(2,1));
	JPanel ps=new JPanel();

	JLabel lableId = new JLabel("ID");
	JLabel lablePassword=new JLabel("��й�ȣ");


	JTextField id=new JTextField();
	JTextField password=new JTextField();
	

	JButton confirm;
	JButton reset=new JButton("���");

    JTableView JTableView;
    UserListDTO dto;
   
  //idüũ�� �ߴ��� ���ߴ��� Ȯ�����ִ� ���º��� (true�̸� üũ����(�ߺ��ƴ�))
   boolean idCheckState = false;

	public LoginJDialogView(JTableView JTableView, String index){
		super(JTableView,"�α���");
		
		this.JTableView=JTableView;
		
		if(index.equals("�α���")){
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
		
		
		//TextField �߰�
		pc.add(id);
		pc.add(password);
		
		
		
		ps.add(confirm); 
		ps.add(reset);
	
		add(pw,"West"); 
		add(pc,"Center");
		add(ps,"South");
		
		setSize(400,150);
		setVisible(true);

		//xŬ�������� â�ݱ�
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ���
        confirm.addActionListener(this); //����/���� �̺�Ʈ���
        reset.addActionListener(this); //��� �̺�Ʈ���
		
	}//�����ڳ�
    
	/**
	 * ����/����/���/IDCheck ��ɿ� ���� �κ�
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if(label.equals("�α���")) {
			UserListDTO dto2 = ConvenientFacilitiesController.getLogin(id.getText(),password.getText());
			if(dto2 == null) {
//				FailView.errorMessage("�α��� ����");
				id.requestFocus();
				return;
			}else {
				SuccessView.successMessage("�α��� ����");
//				setUserListDTO(dto2);
				JTableView.setDTO(dto2);
//				System.out.println(dto.getName());
				this.dispose();
			}
		}else {
			this.dispose();
		}
		
	}//actionPerformed��
	
//	public UserListDTO getUserListDTO() {
//		
//	}

	public void setUserListDTO(UserListDTO dto) {
		this.dto = dto;
	}
	
	public UserListDTO getUserListDTO() {
		return dto;
	}
	
	
}//Ŭ������
