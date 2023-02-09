package com.spring.polymorphism;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> Samsung(1) 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> Samsung(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> Samsung(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker 객체 생성");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice 객체 생성");
		this.price = price;
	}

	public void initMethod() {
		System.out.println("객체 초기화 작업 처리.");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV --- 전원을 켠다. (가격 : " + price + ")");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV --- 전원을 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}*/
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
//@Data
public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	


	public void initMethod() {
		System.out.println("객체 초기화 작업 처리.");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV --- 전원을 켠다. (가격 : " + price + ")");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV --- 전원을 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
