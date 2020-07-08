package com.kaikai.DigitalGame.DataBase;
import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.context.annotation.Configuration;
import com.kaikai.DigitalGame.bean.LotteryBean;

/**
 * @author 作者 kaikai:
 * @version 创建时间：2020年7月5日 下午4:49:56
 * @Description 类说明
 */
@Configuration
public class DigitalData {
	//迭代使用的资源
	private ArrayList<Integer> redball=new ArrayList<Integer>();
	private Integer blueball;
	Integer num=6;

	public LotteryBean getDigitalData() {	
		int[] redpool = new int[33];
		int[] bluepool = new int[16];
		LotteryBean lotteryBean = new LotteryBean();
		LotteryBean lotteryBean2 = new LotteryBean();
		
		// pool中数据的初始化
		for (int i = 1; i <= 33; i++) {
			redpool[i-1] = i;
		}
		for (int i = 1; i <= 16; i++) {
			bluepool[i-1] = i;
		}
		//方法调用，迭代完成
		getChaos(redpool, 33);
		getChaos(bluepool);	
		redball.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int flag = o1>o2 ? 0 :-1;
				return flag;
			}		
		});
		//返回数据
		lotteryBean.setRedBall(redball);
		lotteryBean.setBlueBall(blueball);
		
		//清空缓存
		if(redball!=null) {
			redball=new ArrayList<Integer>();
		}
		if(num!=null) {
			num=6;
		}
		if(blueball!=null) {
			blueball=0;
		}
		return lotteryBean;
	}

	/**
	 * 红球迭代
	 * @param redpool
	 * @param quantity
	 */
	public void getChaos(int[] oldpool, int quantity) {
		int index = getChaosCoefficient(quantity);
		redball.add(oldpool[index]);
		//生成新的pool
		int [] newpool=new int[quantity-1];
		int newpoolindex=0;
		for(int i=0;i<oldpool.length;i++) {
			if(i==index) {
				continue;
			}else {
				newpool[newpoolindex]=oldpool[i];
			}
			newpoolindex++;
		}
		this.num--;
		if(this.num!=0) {
			getChaos(newpool, quantity-1);
		}
	}	
	
	/**
	 * 生成篮球
	 * @param bluepool
	 */
	public void getChaos(int[] bluepool) {
		int blueball=getChaosCoefficient(16);
		this.blueball=bluepool[blueball];
	}
	
	/**
	 * 得到随机数下标
	 * @param number
	 * @return
	 */
	public static int getChaosCoefficient(int number) {
		Integer coefficient = 0;
		coefficient=(int)(Math.random()*number+1);
		return coefficient;
	}
	
}










