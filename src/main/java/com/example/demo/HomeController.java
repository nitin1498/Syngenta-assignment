package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;   
@Controller
public class HomeController {
	
	private ArrayList<Contact> list = new ArrayList<>();
	
	HomeController() {
		list.add(new Contact("Dave","Smith","123 main st.","seattle","wa","43"));
		list.add(new Contact("Alice","Smith","123 Main St.","Seattle","WA","45"));
		list.add(new Contact("bOb","Williams","234 2nd Ave.","Tacoma","WA","26"));
		list.add(new Contact("Carol","Johnson","234 2nd Ave","Seattle","WA","67"));
		list.add(new Contact("TOm","Bombadillo","1212 Maple Street","Florida","GA","520"));
		list.add(new Contact("Jimbo","Jones","82 Pine Street","Atlanta","GA","2"));
		list.add(new Contact("Jackie","Jones","82 Pine Street","Atlanta","GA","6"));
		list.add(new Contact("Tommy","Jones","82 Pine Street","Atlanta","GA","29"));
		list.add(new Contact("tammy","Jones","82 Pine Street","Atlanta","GA","27"));
		list.add(new Contact("EvE","Smith","234 2nd Ave.","Tacoma","WA","25"));
		list.add(new Contact("Frank","Jones","234 2nd Ave.","Tacoma","FL","23"));
		list.add(new Contact("george","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","19"));
		list.add(new Contact("Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18"));
		list.add(new Contact("Ian","smith","123 main st ","Seattle","Wa","18"));
		list.add(new Contact("Jane","Smith","123 Main St.","Seattle","WA","13"));
		
	}
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("submit")
	public ModelAndView submit(String query) {
		ModelAndView mv=  new ModelAndView();
		mv.setViewName("result.jsp");
		query = query.toLowerCase();
		ArrayList<Contact> result = new ArrayList<>();
		for(Contact c : list) {
			if(c.fname.toLowerCase().contains(query)) {
				result.add(c);
			} else if(c.lname.toLowerCase().contains(query)) {
				result.add(c);
			} else if(c.address.toLowerCase().contains(query)) {
				result.add(c);
			} else if(c.city.toLowerCase().contains(query)) {
				result.add(c);
			} else if(c.code.toLowerCase().contains(query)) {
				result.add(c);
			} else if(c.pin.toLowerCase().contains(query)) {
				result.add(c);
			}
		}
		for(Contact c : result) {
			System.out.println(c.fname + " " + c.lname);
		}
		mv.addObject("result", new Gson().toJson(result));
		return mv;
	}
	
	
}
