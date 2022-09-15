package com.global.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

	public void execeptionLog(JoinPoint jp, Exception exceptionObj) {
		
		String method = jp.getSignature().getName();
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력 되었습니다.");
		}else if(exceptionObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		}else if(exceptionObj instanceof Exception) {
			System.out.println("문제가 무쟈게 발생했습니다.");
		}
		
		System.out.println("[예외 처리]"+method+"()메소드 수행 중 발생한 예외 메시지: "
		+exceptionObj.getMessage());
	}
	
}
