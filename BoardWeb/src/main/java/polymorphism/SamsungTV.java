package polymorphism;

public class SamsungTV implements TV{

	public void powerOn(){
		System.out.println("�ＺƼ�� ------ ���� �Ҵ�.");
	}
	
	public void powerOff(){
		System.out.println("�ＺƼ�� ------ ���� ����.");
	}
	
	public void volumeUp(){
		System.out.println("�ＺƼ�� ------ �Ҹ� �ø���.");
	}
	
	public void volumeDown(){
		System.out.println("�ＺƼ�� ------ �Ҹ� ������.");
	}
	
}
