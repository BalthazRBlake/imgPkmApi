package org.dev.fhhf.urlpkmimg.resource;

import java.io.IOException;

import org.dev.fhhf.urlpkmimg.service.HtmlReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pkm")
public class HtmlReaderResource {
	
	@Autowired
	private HtmlReaderService htmlReaderService;
	
	@RequestMapping("/{pkmIdName}")
	public String getImgUrl(@PathVariable("pkmIdName") String pkmIdName) {
		
		String url;
		
		try {
			url = htmlReaderService.readUrl(pkmIdName);
		}catch(IOException ex) {
			ex.printStackTrace();
			return "El Pokémon " + pkmIdName + " NO existe";
		}
		
		return url;
	}
	
	@RequestMapping("")
	public String infoFormat() {
		return "Provide pkm # and name e.g. /pkm/006Charizard";
	}
}
