package com.kaikai.DigitalGame.Utils;



import java.util.Date;

import javax.xml.crypto.Data;

/**
 * 返回数据
 * @author 22897
 *
 */
public class MessageUtil {

	/**
	 * 成功并且返回数据给前台
	 * @param obj
	 * @return
	 */
	public static <E>Message<E> success(E obj){
		return new Message<E>(200,"success",obj,new Date().getTime());
	}
	/**
	 * 成功无返回数据给前台
	 * @param obj
	 * @return
	 */
	public static <E>Message<E> success(){
		return new Message<E>(200,"success",null,new Date().getTime());
	}
	/**
	 * 失败
	 * @param obj
	 * @return
	 */
	public static <E>Message<E>error(Integer code,String msg){
		return new Message<E>(code,msg,null,new Date().getTime());

	}
}












