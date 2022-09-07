package polymorphism;

public class TVUser {
	
	public static void main(String[] args) {
		
		BeanFactory factory = new BeanFactory();
		
//		TV tv = new LgTV(); 
//		TV tv = new SamsungTV();
		TV tv = (TV)factory.getBean(args[1]);
		//런 컨피그레이션 안에(메인함수에)직접 넣어놨음
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}
	
}
