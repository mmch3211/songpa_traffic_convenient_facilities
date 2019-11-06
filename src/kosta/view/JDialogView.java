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
	JLabel lablePassword=new JLabel("비밀번호");
	JLabel lableName=new JLabel("이름");
	JLabel lableAddr=new JLabel("주소");


	JTextField id=new JTextField();
	JTextField password=new JTextField();
	JTextField name=new JTextField();
	JTextField addr=new JTextField();
	

	JButton confirm;
	JButton reset=new JButton("취소");

   JTableView JTableView;

   JPanel idCkP =new JPanel(new BorderLayout());
   JButton idCkBtn = new JButton("IDCheck");
   
  //id체크를 했는지 안했는지 확인해주는 상태변수 (true이면 체크했음(중복아님))
   boolean idCheckState = false;

	public JDialogView(JTableView JTableView, String index){
		super(JTableView,"회원가입");
		
		this.JTableView=JTableView;
		
		if(index.equals("회원가입")){
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
		pw.add(lableName);//이름
		pw.add(lableAddr);//주소
	
		
		idCkP.add(id,"Center");
		idCkP.add(idCkBtn,"East");
		
		//TextField 추가
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

		//x클릭했을때 창닫기
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//이벤트등록
        confirm.addActionListener(this); //가입/수정 이벤트등록
        reset.addActionListener(this); //취소 이벤트등록
        idCkBtn.addActionListener(this);// ID중복체크 이벤트 등록
		
	}//생성자끝
    
	/**
	 * 가입/수정/취소/IDCheck 기능에 대한 부분
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if(label.equals("회원가입")) {
			//유효성 체크 (id, name, age, addr) 
			if(isValidate(id,password,name,addr)) {
				if(idCheckState) {
					UserListDTO dto = new UserListDTO(id.getText(), password.getText(), name.getText(), addr.getText());
					if(ConvenientFacilitiesController.userListInsert(dto) > 0) {
						//현재창 닫기, 메인창에 반영
						SuccessView.successMessage("회원가입 완료!");
						this.dispose();//현재창 닫기
					}
				}else {
					FailView.errorMessage("id중복체크를 해주세요.");
					id.requestFocus();
				}
			}
		}else if(label.equals("IDCheck")) {

			String idValue = id.getText();
			if(idValue.equals("")) {
				FailView.errorMessage("아이디를 입력해주세요.");
				id.requestFocus();
				return;
			}
//			controller -> service -> dao 갔다 결과 받는다.
			if(ConvenientFacilitiesController.getCheckById(idValue)) {
				FailView.errorMessage(idValue + "는 중복입니다.");
				id.setText("");
				id.requestFocus();
				return;
					
			}else {
				SuccessView.successMessage(idValue + "는 사용가능합니다.");
				idCheckState = true;
			}
//			
//		}
		}else {
			this.dispose();
		}
		
	}//actionPerformed끝
	
	/**TextField 유효성 체크하기
	 * true 성공, false 오류
	 */
	public boolean isValidate(JTextField ... text) {
		
		for(JTextField t : text) {
			if(t.getText().equals("")) {
				FailView.errorMessage("값을 입력하세요");
				t.requestFocus();
				return false;
			}
		}
		
		
		return true;
	}
	
	
	
}//클래스끝
