package com.kaikai.DigitalGame.bean;
/** 
* @author 作者 kaikai: 
* @version 创建时间：2020年7月5日 下午2:18:39 
* @Description 类说明 
*/

import java.util.ArrayList;


public class LotteryBean {
	private ArrayList<Integer> redBall;
	private Integer blueBall;
	public ArrayList<Integer> getRedBall() {
		return redBall;
	}
	public void setRedBall(ArrayList<Integer> redBall) {
		this.redBall = redBall;
	}
	public Integer getBlueBall() {
		return blueBall;
	}
	public void setBlueBall(Integer blueBall) {
		this.blueBall = blueBall;
	}
	@Override
	public String toString() {
		return "LotteryBean [redBall=" + redBall + ", blueBall=" + blueBall + "]";
	}
	public LotteryBean(ArrayList<Integer> redBall, Integer blueBall) {
		super();
		for(int i= 0;i<6;i++) {
			redBall.add(1);
		}
		blueBall=16;
		this.redBall = redBall;
		this.blueBall = blueBall;
	}
	public LotteryBean() {
		super();
	}
}
