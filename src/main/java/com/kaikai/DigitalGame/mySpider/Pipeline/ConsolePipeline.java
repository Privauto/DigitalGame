package com.kaikai.DigitalGame.mySpider.Pipeline;

import java.util.Map.Entry;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/** 
* @author 作者 kaikai: 
* @version 创建时间：2020年8月19日 下午7:30:07 
* @Description 类说明 输出到控制台
*/
public class ConsolePipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
    }
}
