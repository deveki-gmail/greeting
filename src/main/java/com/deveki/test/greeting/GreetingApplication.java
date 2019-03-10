package com.deveki.test.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable("name") String name){
		if(StringUtils.isEmpty(name)){
			return "Hi User";
		}
		return "Hi "+name;
	}
	
	@PostMapping("/hi")
	public GreetingResponse hiPost(@RequestBody(required = true) GreetingRequest req){
		if(req == null || (req.getName() == null || "".equals(req.getName()))){
			GreetingResponse res = new GreetingResponse();
			res.setErrorMessage("Name is required.");
			res.setStatus("ERROR");
			return res;
		}
		String greetword = getGreetingWord(req.getLang());
		GreetingResponse res = new GreetingResponse();
		res.setStatus("OK");
		res.setGreeting(req.getName()+" "+greetword);
		return res;
		
	}
	
	private String getGreetingWord(String lang){
		String greeting = "";
		if(lang == null || "".equals(lang)){
			greeting = "Hi";
		}
		
		if( lang != null && lang.equalsIgnoreCase("jp")){
			greeting = "Konnichiwa";
		}
		
		if(lang != null &&  lang.equalsIgnoreCase("en")){
			greeting = "Hello";
		}
		
		return greeting;
	}

}
