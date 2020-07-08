package com.kaikai.DigitalGame.services;
/** 
* @author 作者 kaikai: 
* @version 创建时间：2020年7月5日 下午4:35:57 
* @Description 类说明 
*/

import com.kaikai.DigitalGame.Utils.Message;
import com.kaikai.DigitalGame.bean.LotteryBean;

public interface DataService {
	Message<LotteryBean> getData();
}
