package org.dev.fhhf.urlpkmimg.service;

import java.io.IOException;

import org.dev.fhhf.urlpkmimg.model.HtmlReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HtmlReaderImpl implements HtmlReaderService{
	
	@Autowired
	private HtmlReader htmlReader;

	@Override
	public String readUrl(String pkmIdName) throws IOException{
		
		//System.out.println(pkmIdName.length() <= 3);
		if(pkmIdName.length() <= 3) {
			return "Provide pkm # and name e.g. /pkm/006Charizard";
		}
		
		htmlReader.setUrl("https://bulbapedia.bulbagarden.net/wiki/File:" + pkmIdName + ".png");
		
		Document doc;
		//try {
			
			doc = Jsoup.connect(htmlReader.getUrl()).get(); 
			//title = doc.title();
			//System.out.println(title);
			//System.out.println(doc);
			Elements resultLinks = doc.select("a");
			//System.out.println("number of links: " + resultLinks.size());
			for (Element link : resultLinks) {
				Element parent = link.parent();
				//System.out.println(parent.className());
				if(parent.className().equals("fullImageLink")) {
				    htmlReader.setHref( link.attr("href") );
				    //System.out.println("Title: " + link.text());
				    //System.out.println("Url: " + htmlReader.getHref());
				}
			}
		/*}catch( IOException e) {
			e.printStackTrace();
		}*/
		return htmlReader.getHref();
	}
}
