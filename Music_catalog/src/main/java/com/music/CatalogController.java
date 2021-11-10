package com.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CatalogController {
	@Autowired
	MusicService musicservice;
	@RequestMapping("/")
	public String index(Model model) {
		List <Music> listMusic= musicservice.getmusic();
		model.addAttribute("listMusic" ,listMusic);
		return "home";
		}
	@GetMapping("/home")
	public String index1(Model model, String keyword) {
		if(keyword !=null) {
			model.addAttribute("listMusic" ,musicservice.findByKeyword(keyword));
		}else {
		model.addAttribute("listMusic" ,musicservice.getmusic());
		}
		return "home";
	}
	@GetMapping("/newEmpform")
	public String showmuiscform(Model model) {
		Music music=new Music();
		model.addAttribute("music",music);
		return "newEmpform";
	}
	
	@PostMapping("/save")
	public String saveMusic(@ModelAttribute ("music") Music music) {
		musicservice.saveMusic(music);
		return "redirect:/";
	}
 
	@GetMapping("/showFormForUpdate/{id}") 
	public String showForm(@PathVariable (value="id")long id,Model model) {
		Music music=musicservice.getMusicById(id);
		model.addAttribute("music",music);
		return "updateform";
	}
	
	@GetMapping("/deleteMusic/{id}") 
	public String showForm(@PathVariable (value="id")long id) {
	 this.musicservice.deleteMusicById(id);
	 return "redirect:/";
	}
	
}
