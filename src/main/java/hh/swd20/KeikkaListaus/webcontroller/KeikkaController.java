package hh.swd20.KeikkaListaus.webcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hh.swd20.KeikkaListaus.domain.ArtistiRepository;
import hh.swd20.KeikkaListaus.domain.KategoriaRepository;
import hh.swd20.KeikkaListaus.domain.Keikka;
import hh.swd20.KeikkaListaus.domain.KeikkaRepository;

@Controller
public class KeikkaController {
	
	
	@Autowired
	KeikkaRepository kRepository;
	KategoriaRepository kaRepo;
	ArtistiRepository aRepo;
	
	//hae keikat
	@RequestMapping(value="/keikat", method = RequestMethod.GET)
	public String getKeikat(Model model) {
		List<Keikka>keikat = (List<Keikka>) kRepository.findAll();
		model.addAttribute("keikat",keikat);
		return "keikat";
		
		}
	//Lisää keikka kategoria sekä artisti
	 @RequestMapping(value = "/add")
	    public String addKeikka(Model model){
	    	model.addAttribute("keikka", new Keikka());
	    	model.addAttribute("kategoria", kaRepo.findAll());
	    	model.addAttribute("artisti", aRepo.findAll());
	        return "addkeikka";
	    }     
		
	    // Tallenna keikka
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Keikka keikka){
	        kRepository.save(keikka);
	        return "redirect:keikat";
	    }    
	

}
