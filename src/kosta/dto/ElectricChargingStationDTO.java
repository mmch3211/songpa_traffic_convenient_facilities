package kosta.dto;

public class ElectricChargingStationDTO {

	//�����Ҹ�, ��������ġ, �̿밡�ɽ��۽ð�, �̿밡������ð�, �޼�����Ÿ�Ա���, ������ΰ�, ���������θ��ּ�
	private String eleName;
	private String eleAddrDT;
	private String eleStart;
	private String eleEnd;
	private String eleQuickType;
	private String eleParkingFee;
	private String eleAddr;
	

	public ElectricChargingStationDTO(String eleName, String eleAddrDT, String eleStart, String eleEnd,
			String eleQuickType, String eleParkingFee, String eleAddr) {
		super();
		this.eleName = eleName;
		this.eleAddrDT = eleAddrDT;
		this.eleStart = eleStart;
		this.eleEnd = eleEnd;
		this.eleQuickType = eleQuickType;
		this.eleParkingFee = eleParkingFee;
		this.eleAddr = eleAddr;
	}
	
	public String getEleName() {
		return eleName;
	}
	public void setEleName(String eleName) {
		this.eleName = eleName;
	}
	public String getEleAddrDT() {
		return eleAddrDT;
	}
	public void setEleAddrDT(String eleAddrDT) {
		this.eleAddrDT = eleAddrDT;
	}
	public String getEleStart() {
		return eleStart;
	}
	public void setEleStart(String eleStart) {
		this.eleStart = eleStart;
	}
	public String getEleEnd() {
		return eleEnd;
	}
	public void setEleEnd(String eleEnd) {
		this.eleEnd = eleEnd;
	}
	public String getEleQuickType() {
		return eleQuickType;
	}
	public void setEleQuickType(String eleQuickType) {
		this.eleQuickType = eleQuickType;
	}
	public String getEleParkingFee() {
		return eleParkingFee;
	}
	public void setEleParkingFee(String eleParkingFee) {
		this.eleParkingFee = eleParkingFee;
	}
	public String getEleAddr() {
		return eleAddr;
	}
	public void setEleAddr(String eleAddr) {
		this.eleAddr = eleAddr;
	}
	

	
	
	
	
	
}
