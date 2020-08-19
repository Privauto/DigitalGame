package com.kaikai.DigitalGame.services.serImp;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaikai.DigitalGame.DataBase.DigitalData;
import com.kaikai.DigitalGame.Utils.Message;
import com.kaikai.DigitalGame.Utils.StatusCodeUtil;
import com.kaikai.DigitalGame.bean.LotteryBean;
import com.kaikai.DigitalGame.services.DataService;

/** 
* @author 作者 kaikai: 
* @version 创建时间：2020年7月5日 下午4:37:21 
* @Description 类说明 
*/
@Service
public class DataServiceImp implements DataService {
	@Override
	public Message<LotteryBean> getData() {
		LotteryBean data=new LotteryBean(new ArrayList<>(), new Integer(1));
		Message<LotteryBean> message = new Message<>(StatusCodeUtil.SUCCESS_CODE, "成功", data,new Date().getTime());	
		return message;
	}	
}
