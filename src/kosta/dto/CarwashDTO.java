package kosta.dto;

public class CarwashDTO {
	//사업장명, 사업장업종명, 세차유형, 소재지도로명주소, 세차장전화번호, 데이터기준일.
	
	private String CarwashName;
	private String CarwashField;
	private String CarwashKind;
	private String CarwashAddr;
	private String CarwashContact;
	private String CarwashDate;
	
	
	public CarwashDTO(String carwashName, String carwashField, String carwashKind, String carwashAddr,
			String carwashContact, String carwashDate) {
		super();
		CarwashName = carwashName;
		CarwashField = carwashField;
		CarwashKind = carwashKind;
		CarwashAddr = carwashAddr;
		CarwashContact = carwashContact;
		CarwashDate = carwashDate;
	}
	public String getCarwashName() {
		return CarwashName;
	}
	public void setCarwashName(String carwashName) {
		CarwashName = carwashName;
	}
	public String getCarwashField() {
		return CarwashField;
	}
	public void setCarwashField(String carwashField) {
		CarwashField = carwashField;
	}
	public String getCarwashKind() {
		return CarwashKind;
	}
	public void setCarwashKind(String carwashKind) {
		CarwashKind = carwashKind;
	}
	public String getCarwashAddr() {
		return CarwashAddr;
	}
	public void setCarwashAddr(String carwashAddr) {
		CarwashAddr = carwashAddr;
	}
	public String getCarwashContact() {
		return CarwashContact;
	}
	public void setCarwashContact(String carwashContact) {
		CarwashContact = carwashContact;
	}
	public String getCarwashDate() {
		return CarwashDate;
	}
	public void setCarwashDate(String carwashDate) {
		CarwashDate = carwashDate;
	}
	
	

}
