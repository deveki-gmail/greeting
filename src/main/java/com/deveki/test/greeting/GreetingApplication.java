package com.deveki.test.greeting;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class GreetingApplication {

	Logger logger = LoggerFactory.getLogger(GreetingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable("name") String name){
		logger.info("Requet received for general greeting.");
		if(StringUtils.isEmpty(name)){
			logger.error("Name is required.");
			return "Name is required";
		}
		
		if(!Util.isValidName(name)){
			logger.error("Name is incorrect.");
			return "Name ["+name+"] is incorrect.";
		}
		
		
		return "Hi "+name;
	}
	
	
	
	
	@PostMapping("/hi")
	public GreetingResponse hiPost(@RequestBody(required = true) GreetingRequest req){
		logger.info("Requet received for greeting language wise.");
		if(req == null || (req.getName() == null || "".equals(req.getName()))){
			
			logger.error("Name is required.");
			
			GreetingResponse res = new GreetingResponse();
			res.setErrorMessage("Name is required.");
			res.setStatus("ERROR");
			return res;
		}
		
		if(!Util.isValidName(req.getName())){
			logger.error("Name is incorrect.");
			GreetingResponse res = new GreetingResponse();
			res.setErrorMessage("Name ["+req.getName()+"] is incorrect.");
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
