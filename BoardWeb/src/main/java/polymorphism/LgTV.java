package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{

	@Autowired
//	@Qualifier("sony")//아이디로 지정
//	@Resource(name = "apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("====> 엘지티비 객체 생성.");
	}
	
	public void powerOn(){
		System.out.println("엘지티비 ------ 전원 켠다.");
	}
	
	public void powerOff(){
		System.out.println("엘지티비 ------ 전원 끈다.");
	}
	
	public void volumeUp(){
		speaker.volumeUp();
	}
	
	public void volumeDown(){
		speaker.volumeDown();
	}
	
}
