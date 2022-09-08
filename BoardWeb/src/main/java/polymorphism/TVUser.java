package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * GenericXmlApplicationContext
 *  -���� �ý����̳� Ŭ������ ��ο� �ִ� xml���������� �ε��Ͽ� �����ϴ� ������ �����̳�
 * 
 * XmlWebApplicationContext
 *  -������� ������ ���ø����̼��� ������ �� ����ϴ� ������ �����̳���
 * 
 */

public class TVUser {
	
	public static void main(String[] args) {
		
		/*
		 * BeanFactory factory = new BeanFactory();
		 * 
		 * // TV tv = new LgTV(); // TV tv = new SamsungTV(); TV tv =
		 * (TV)factory.getBean(args[1]); //�� ���Ǳ׷��̼� �ȿ�(�����Լ���)���� �־����
		 * �̰� ���� �ڹٿ� 
		 */
		
		//1.spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
			
		//2.spring �����̳ʷ� ���� �ʿ��� ��ü�� ��û�Ѵ�.
		TV tv = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
//		TV tv2 = tv1;
//		TV tv3 = tv2;
		
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3.spring �����̳ʸ� �����Ѵ�.
		factory.close();
	
	
	}
	
}
