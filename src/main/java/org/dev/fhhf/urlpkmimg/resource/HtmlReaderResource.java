package org.dev.fhhf.urlpkmimg.resource;

import java.io.IOException;

import org.dev.fhhf.urlpkmimg.service.HtmlReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.dev.fhhf.urlpkmimg.model.ResponseObject;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
@RequestMapping(value = "/pkm", produces = MediaType.APPLICATION_JSON_VALUE)
public class HtmlReaderResource {
	
	@Autowired
	private HtmlReaderService htmlReaderService;

	@GetMapping("/{pkmIdName}")
	public ResponseObject getImgUrl(@PathVariable("pkmIdName") String pkmIdName) {
		
		String url;
		
		try {
			url = htmlReaderService.readUrl(pkmIdName);
		}catch(IOException ex) {
			ex.printStackTrace();
			ResponseObject responseObject = new ResponseObject("El Pokémon " + pkmIdName + " NO existe");
			return responseObject;
		}

		ResponseObject responseObject = new ResponseObject(url.substring(2));
		return responseObject;
	}
	
	@RequestMapping("")
	public ResponseObject infoFormat() {
		return new ResponseObject("Provide pkm # and name e.g. /pkm/006Charizard");
	}
}
