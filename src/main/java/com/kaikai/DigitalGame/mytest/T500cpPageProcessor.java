package com.kaikai.DigitalGame.mytest;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/** 
* @author 作者 kaikai: 
* @version 创建时间：2020年8月19日 下午1:05:29 
* @Description 类说明 测试爬取500cp
*/
public class T500cpPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("cp", page.getHtml().$(".ball_red","text").all().toString());
        if (page.getResultItems().get("cp") == null) {
            //skip this page
            page.setSkip(true);
        }
        // 部分三：从页面发现后续的url地址来抓取
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new T500cpPageProcessor());
        spider.addUrl("https://kaijiang.500.com/ssq.shtml").addPipeline(new myConsolePipeline()).thread(1).run();
    }
}
