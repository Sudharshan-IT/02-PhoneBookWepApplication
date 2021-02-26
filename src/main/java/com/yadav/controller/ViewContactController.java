package com.yadav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yadav.model.Contact;
import com.yadav.service.ContactService;

@Controller
public class ViewContactController {
	/**
	 * Contact Service is injected to this controller
	 */
	 @Autowired
	private ContactService contactservice;
	 /**
	  * this method is used to perform edit operation on the db table
	  * @param contactId
	  * @param model
	  * @return String
	  */
	 @GetMapping(value="/editContact")
	 public String editContact(@RequestParam("cid") Integer contactId,Model model) {
		 Contact contact = contactservice.getContactById(contactId);
		 model.addAttribute("contact", contact);
		return "index";
	 }
	 /**
	  * this method is used to perform delete operation on the db table
	  * @param contactId
	  * @return String
	  */
	 @GetMapping(value="deleteContact")
	 public String deleteContact(@RequestParam("cid") Integer contactId) {
		 contactservice.deleteContactById(contactId);
		return "redirect:viewContacts";
		 
	 }
	
}
