package polymorphism;

public class LgTV implements TV{

	public void powerOn(){
		System.out.println("����Ƽ�� ------ ���� �Ҵ�.");
	}
	
	public void powerOff(){
		System.out.println("����Ƽ�� ------ ���� ����.");
	}
	
	public void volumeUp(){
		System.out.println("����Ƽ�� ------ �Ҹ� �ø���.");
	}
	
	public void volumeDown(){
		System.out.println("����Ƽ�� ------ �Ҹ� ������.");
	}
	
}
