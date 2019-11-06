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
	JLabel lablePassword=new JLabel("비밀번호");


	JTextField id=new JTextField();
	JTextField password=new JTextField();
	

	JButton confirm;
	JButton reset=new JButton("취소");

    JTableView JTableView;
    UserListDTO dto;
   
  //id체크를 했는지 안했는지 확인해주는 상태변수 (true이면 체크했음(중복아님))
   boolean idCheckState = false;

	public LoginJDialogView(JTableView JTableView, String index){
		super(JTableView,"로그인");
		
		this.JTableView=JTableView;
		
		if(index.equals("로그인")){
			confirm=new JButton(index);
		}
//		else{
//			confirm=new JButton("수정");	
//			
//			//선택된 행의 각 열의 값을 읽어서 textField에 넣기
//			int row = userJTableView.jt.getSelectedRow();
//			id.setText(userJTableView.jt.getValueAt(row, 0).toString());
//			name.setText(userJTableView.jt.getValueAt(row, 1).toString());
//			age.setText(userJTableView.jt.getValueAt(row, 2).toString());
//			addr.setText(userJTableView.jt.getValueAt(row, 3).toString());
//			
//			
//			//id text박스 비활성
//			id.setEditable(false);
//	
//			//IDCheck버튼 비활성화
//			idCkBtn.setEnabled(false);
//		}
		
		
		//Label추가부분
		pw.add(lableId);//ID
		pw.add(lablePassword);//ㅂㅣ밀번호
		
		
		//TextField 추가
		pc.add(id);
		pc.add(password);
		
		
		
		ps.add(confirm); 
		ps.add(reset);
	
		add(pw,"West"); 
		add(pc,"Center");
		add(ps,"South");
		
		setSize(400,150);
		setVisible(true);

		//x클릭했을때 창닫기
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//이벤트등록
        confirm.addActionListener(this); //가입/수정 이벤트등록
        reset.addActionListener(this); //취소 이벤트등록
		
	}//생성자끝
    
	/**
	 * 가입/수정/취소/IDCheck 기능에 대한 부분
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if(label.equals("로그인")) {
			UserListDTO dto2 = ConvenientFacilitiesController.getLogin(id.getText(),password.getText());
			if(dto2 == null) {
//				FailView.errorMessage("로그인 실패");
				id.requestFocus();
				return;
			}else {
				SuccessView.successMessage("로그인 성공");
//				setUserListDTO(dto2);
				JTableView.setDTO(dto2);
//				System.out.println(dto.getName());
				this.dispose();
			}
		}else {
			this.dispose();
		}
		
	}//actionPerformed끝
	
//	public UserListDTO getUserListDTO() {
//		
//	}

	public void setUserListDTO(UserListDTO dto) {
		this.dto = dto;
	}
	
	public UserListDTO getUserListDTO() {
		return dto;
	}
	
	
}//클래스끝
