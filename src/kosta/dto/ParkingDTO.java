package kosta.dto;

public class ParkingDTO {
	
	//주차장이름, 소재지도로명주소, 주차구획수, 운영시작시간, 운영종료시간, 주차기본시간, 주차기본요금, 주차장전화번호.
	private String parkingName;
	private String parkingAddr;
	private int parkingLot;
	private String parkingStart;
	private String parkingEnd;
	private int parkingTime;
	private int parkingFee;
	private String parkingContact;
	
	public ParkingDTO(String parkingName, String parkingAddr, int parkingLot, String parkingStart, String parkingEnd,
			int parkingTime, int parkingFee, String parkingContact) {
		super();
		this.parkingName = parkingName;
		this.parkingAddr = parkingAddr;
		this.parkingLot = parkingLot;
		this.parkingStart = parkingStart;
		this.parkingEnd = parkingEnd;
		this.parkingTime = parkingTime;
		this.parkingFee = parkingFee;
		this.parkingContact = parkingContact;
	}
	
	public String getParkingName() {
		return parkingName;
	}
	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}
	public String getParkingAddr() {
		return parkingAddr;
	}
	public void setParkingAddr(String parkingAddr) {
		this.parkingAddr = parkingAddr;
	}
	public int getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(int parkingLot) {
		this.parkingLot = parkingLot;
	}
	public String getParkingStart() {
		return parkingStart;
	}
	public void setParkingStart(String parkingStart) {
		this.parkingStart = parkingStart;
	}
	public String getParkingEnd() {
		return parkingEnd;
	}
	public void setParkingEnd(String parkingEnd) {
		this.parkingEnd = parkingEnd;
	}
	public int getParkingTime() {
		return parkingTime;
	}
	public void setParkingTime(int parkingTime) {
		this.parkingTime = parkingTime;
	}
	public int getParkingFee() {
		return parkingFee;
	}
	public void setParkingFee(int parkingFee) {
		this.parkingFee = parkingFee;
	}
	public String getParkingContact() {
		return parkingContact;
	}
	public void setParkingContact(String parkingContact) {
		this.parkingContact = parkingContact;
	}
	
	
	

}
