package org.dev.fhhf.urlpkmimg.model;

import org.springframework.stereotype.Repository;

@Repository
public class HtmlReader {
	
	String url;
	String href;

	public HtmlReader() {

	}

	/*public HtmlReader(String numberPkm){
		url = "https://bulbapedia.bulbagarden.net/wiki/File:" + numberPkm + ".png";
	}*/
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
