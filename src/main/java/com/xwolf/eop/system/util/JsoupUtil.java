package com.xwolf.eop.system.util;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

/**
 * jsoup解析网页
 * @author xwolf
 * @date 2016-12-13 18:11
 * @since V1.0.0
 */
public class JsoupUtil {

    public static JSONObject parse(String url){
        JSONObject json=new JSONObject();
        URL purl= null;
        try {
            purl = new URL(url);
            Document document=Jsoup.parse(purl,1000);
            Element elements=document.body();
           Elements findEles= elements.getElementsByClass("MsoNormal");

           for(Element ele:findEles){
              Elements langSpans= ele.getElementsByAttribute("lang");
              Elements  nameSpans=ele.getElementsByAttribute("style");
               for(int i=0;i<langSpans.size();i++){
                   json.put(langSpans.get(i).text().trim(),nameSpans.get(i).text().trim());
               }
           }
           return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
          return null;
    }

    public static void main(String[] args) {
       JSONObject json= parse("http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201608/t20160809_1386477.html");
        System.out.println(json.toJSONString());
    }
}
