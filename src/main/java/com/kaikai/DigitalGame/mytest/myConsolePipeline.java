package com.kaikai.DigitalGame.mytest;

import java.util.Map.Entry;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/** 
* @author 作者 kaikai: 
* @version 创建时间：2020年8月19日 下午2:09:26 
* @Description 类说明 
*/
public class myConsolePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        System.out.println("爬取结果为"+resultItems);
        //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
        for (Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
    }
}