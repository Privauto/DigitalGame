package com.kaikai.DigitalGame.mySpider.PageProcessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/** 
* @author 作者 kaikai: 
* @version 创建时间：2020年8月19日 下午7:26:36 
* @Description 类说明 与彩票开奖结果相关的爬虫
*/
public class LotteryPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {
        page.putField("cp", page.getHtml().$(".ball_red","text").all().toString());
        if (page.getResultItems().get("cp") == null) {
            page.setSkip(true);
        }
    }
    @Override
    public Site getSite() {
        return site;
    }
}
