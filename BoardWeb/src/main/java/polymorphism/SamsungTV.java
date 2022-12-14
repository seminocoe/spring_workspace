package polymorphism;

import org.springframework.stereotype.Component;

//@Component("tv")
public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;

	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===>setSpeaker()ȣ??");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===>setPrice()ȣ??");
		this.price = price;
	}

	
	public void initMethod() {
		System.out.println("??ü ?ʱ?ȭ ?۾??? ó????......");
	}
	
	public void destroyMethod() {
		System.out.println("??ü ???? ???? ó???? ??????......");
	}
	
	public SamsungTV() {
		System.out.println("====>?ＺƼ??(1) ??ü ????...");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("====>?ＺƼ??(2) ??ü ????...");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("====>?ＺƼ??(3) ??ü ????...");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn(){
//		System.out.println("?ＺƼ?? ------ ???? ?Ҵ?.");
		System.out.println("?ＺƼ?? ------ ???? ?Ҵ?.(????:"+price+")");
	}
	
	public void powerOff(){
		System.out.println("?ＺƼ?? ------ ???? ????.");
	}
	
	public void volumeUp(){
//		System.out.println("?ＺƼ?? ------ ?Ҹ? ?ø???.");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	
	public void volumeDown(){
//		System.out.println("?ＺƼ?? ------ ?Ҹ? ??????.");
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
	
}
