package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * GenericXmlApplicationContext
 *  -파일 시스템이나 클래스의 경로에 있는 xml설정파일을 로딩하여 구동하는 스프링 컨테이너
 * 
 * XmlWebApplicationContext
 *  -웹기반을 스프링 어플리케이션을 개발할 때 사용하는 스프링 컨테이너임
 * 
 */

public class TVUser {
	
	public static void main(String[] args) {
		
		/*
		 * BeanFactory factory = new BeanFactory();
		 * 
		 * // TV tv = new LgTV(); // TV tv = new SamsungTV(); TV tv =
		 * (TV)factory.getBean(args[1]); //런 컨피그레이션 안에(메인함수에)직접 넣어놨음
		 * 이거 원래 자바용 
		 */
		
		//1.spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
			
		//2.spring 컨테이너로 부터 필요한 객체를 요청한다.
		TV tv = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
//		TV tv2 = tv1;
//		TV tv3 = tv2;
		
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3.spring 컨테이너를 종료한다.
		factory.close();
	
	
	}
	
}
