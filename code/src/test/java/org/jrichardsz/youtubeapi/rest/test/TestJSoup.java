package org.jrichardsz.youtubeapi.rest.test;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJSoup {
	
	public static void main(String[] args) throws IOException {
		
		Document doc = Jsoup.connect("http://www.youtube.com/user/ZERL1NG/videos?view=0&flow=grid").get();
		Elements newsHeadlines = doc.select("div.yt-lockup.clearfix.yt-lockup-video.yt-lockup-grid");
		Iterator<Element> iterator = newsHeadlines.iterator(); 
		
		while(iterator.hasNext()){
			Element element = iterator.next();			
			System.out.println(element.select("h3.yt-lockup-title a").attr("title"));
			
			Iterator<Element> thumbnail = element.select(".yt-thumb-clip").iterator();
			
			while(thumbnail.hasNext()){
				Element thumb = thumbnail.next();
				System.out.println(thumb.getElementsByTag("img").attr("src"));
			}
		}
		
	}
}
