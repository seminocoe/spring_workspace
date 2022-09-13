package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{

	@Autowired
//	@Qualifier("sony")//���̵�� ����
//	@Resource(name = "apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("====> ����Ƽ�� ��ü ����.");
	}
	
	public void powerOn(){
		System.out.println("����Ƽ�� ------ ���� �Ҵ�.");
	}
	
	public void powerOff(){
		System.out.println("����Ƽ�� ------ ���� ����.");
	}
	
	public void volumeUp(){
		speaker.volumeUp();
	}
	
	public void volumeDown(){
		speaker.volumeDown();
	}
	
}
