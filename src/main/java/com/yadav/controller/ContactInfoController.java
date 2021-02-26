package com.yadav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yadav.model.Contact;
import com.yadav.service.ContactService;

@Controller
public class ContactInfoController {
	/**
	 * ContactService injected to this controller
	 */
	@Autowired
	private ContactService contactservice;
	/**
	 * this method is meant for
	 * to load the form page 
	 * to the end user
	 * @param model
	 * @return String
	 */
	@GetMapping(value= {"/","loadForm"})
	public String displayContactForm(Model  model) {
		Contact c=new Contact();
		model.addAttribute("contact", c);
		return "index";
	}
	/**
	 * this method is used for
	 * to capture the form data
	 * given by the end user
	 * @param contact
	 * @param rattr
	 * @return String
	 */
	@PostMapping(value="/saveContact")
	public String handleSumbitButton(@ModelAttribute("contact") Contact contact ,RedirectAttributes rattr){
	 boolean isSaved=contactservice.saveContact(contact);
	 if(isSaved) { 
		      if(contact.getContactId()!=null) {
		    	  rattr.addFlashAttribute("succMsg", "Contact Updated Successfully");
		      }else {
		    	  rattr.addFlashAttribute("succMsg", "Contact Saved Succesfully");
		      }
	    }else {
		 rattr.addFlashAttribute("errMsg", "Failed to Save Contact");
	 }
	return "redirect:loadForm";
		}
	/**
	 * this method is used 
	 * for retrive the all contact from the db
	 * @param model
	 * @return 
	 */
    @GetMapping(value="/viewContacts")
    public String viewContacts(Model model) {
    	List<Contact> allContacts = contactservice.getAllContacts();
    	model.addAttribute("contacts", allContacts);
    	return "ViewContacts";
    }
    }


