package com.urlshortener.restservice;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UrlShortenerController {

	private final UrlShortenerRepository repository;

	UrlShortenerController(UrlShortenerRepository repository){
		this.repository = repository;
	}

	@GetMapping("/")
	public String test() {
		return "Hello World";
	}
	
	@PostMapping(path = "/", produces = "application/json")
	public String alias(@RequestBody UrlShortenerEntity newUrlShortenerEntity){

		String url = newUrlShortenerEntity.getUrl();
		String alias = AliasGenerator.generate(url);
		
		newUrlShortenerEntity.setAlias(alias);
		repository.save(newUrlShortenerEntity);

		return String.format("{\"alias\":%s}", alias);
	}

	@GetMapping(path = "/{alias}")
	public RedirectView getAlias(@PathVariable String alias){

		List<UrlShortenerEntity>  shorteners = repository.findByAlias(alias);

		if(shorteners.isEmpty()){
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "alias not found"
				);
		}

		return new RedirectView(shorteners.get(0).getUrl());
	}
}
