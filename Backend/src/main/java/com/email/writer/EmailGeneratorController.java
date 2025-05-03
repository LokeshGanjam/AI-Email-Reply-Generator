package com.email.writer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/email")
public class EmailGeneratorController {

	private final EmailGeneratorService emailGeneratorService ;
	
	@PostMapping("/generate")
	public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
	    System.out.println("Received Request: " + emailRequest);

	    if (emailRequest.getEmailContent() == null || emailRequest.getEmailContent().trim().isEmpty()) {
	        return ResponseEntity.badRequest().body("emailContent is required");
	    }

	    String response = emailGeneratorService.generateEmailReply(emailRequest);
	    return ResponseEntity.ok(response);
	}


	public EmailGeneratorController(EmailGeneratorService emailGeneratorService) {
		super();
		this.emailGeneratorService = emailGeneratorService;
	}


}
  