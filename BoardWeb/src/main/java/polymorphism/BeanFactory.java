package polymorphism;

public class BeanFactory {

	public Object getBean(String beanName) {		
		if(beanName.equals("�ＺƼ��")) {
			return new SamsungTV();
		}else if(beanName.equals("����Ƽ��")) {
			return new LgTV();
		}
		return null;
	}
}
