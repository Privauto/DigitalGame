package com.kaikai.DigitalGame.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaikai.DigitalGame.Utils.Message;
import com.kaikai.DigitalGame.bean.LotteryBean;
import com.kaikai.DigitalGame.services.DataService;

/** 
* @author 作者 kaikai: 
* @version 创建时间：2020年7月5日 下午3:55:23 
* @Description 类说明 
*/
@RestController
public class DataController {
	
	@Autowired
	private DataService dataservice;
	
	
	@GetMapping("/getData")
	public Message<LotteryBean> getData() {
		Message<LotteryBean> data = dataservice.getData();
		return data;
	}
}
