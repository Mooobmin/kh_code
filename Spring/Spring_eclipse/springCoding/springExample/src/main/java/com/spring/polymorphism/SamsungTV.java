package com.spring.polymorphism;

public class SamsungTV implements TV {
	public void powerOn() {
		System.out.println("SamsumgTV --- 전원을 킨다.");
	}
	
	public void powerOff() {
		System.out.println("SamsumgTV --- 전원을 끈다.");
	}
	
	public void volumeUp() {
		System.out.println("SamsumgTV --- 소리를 올린다.");
	}
	
	public void volumeDown() {
		System.out.println("SamsumgTV --- 소리를 내린다.");
	}
}
