package com.androidstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AppController {
	@Autowired
	AppService appservice;
	@RequestMapping("/")
	public String index(Model model) {
//		List <Astore> listApps= appservice.getapp();
//		model.addAttribute("listApps" ,listApps);
//		return "home";
		return findPaginated(1,"appName", "asc", model);
		}
	
	@GetMapping("/home")
	public String index1(Model model, String keyword) {
		if(keyword !=null) {
			model.addAttribute("listApps" ,appservice.findByKeyword(keyword));

		}else {
		
		model.addAttribute("listApps" ,appservice.getapp());
		}
		return "home";
	}
	@GetMapping("/newAppform")
	public String showappform(Model model) {
		Astore astore=new Astore();
		model.addAttribute("astore",astore);
		return "newAppform";
	}
	
	@PostMapping("/save")
	public String saveApp(@ModelAttribute ("astore") Astore astore) {
		appservice.saveApp(astore);
		return "redirect:/";
	}
 
	@GetMapping("/showFormForUpdate/{id}") 
	public String showForm(@PathVariable (value="id")long id,Model model) {
		Astore astore=appservice.getAppById(id);
		model.addAttribute("astore",astore);
		return "updateform";
	}
	
	@GetMapping("/deleteApp/{id}") 
	public String showForm(@PathVariable (value="id")long id) {
	 this.appservice.deleteAppById(id);
	 return "redirect:/";
	}

	@GetMapping("/page/{pageNo}") 
   public String findPaginated(@PathVariable (value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,@RequestParam("sortDir") String sortDir, Model model) {
	   int pageSize =10;
	   Page<Astore> page = appservice.findPaginated(pageNo, pageSize, sortField, sortDir);
       List<Astore> listApps = page.getContent();
	   model.addAttribute("currentPage", pageNo);
	   model.addAttribute("tottalPages", page.getTotalPages());
	   model.addAttribute("totalItems", page.getTotalElements());
	   
	   model.addAttribute("sortField", sortField);
	   model.addAttribute("sortDir", sortDir);
	   model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	   model.addAttribute("listApps", listApps);
	   return "home";

	}

}

