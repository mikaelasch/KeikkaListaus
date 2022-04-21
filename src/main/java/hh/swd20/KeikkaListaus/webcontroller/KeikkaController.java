package hh.swd20.KeikkaListaus.webcontroller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
	
	@GetMapping("/index")
	public String index() {
	    return "index";
	}
	//hae keikat
	@RequestMapping(value="/keikat", method = RequestMethod.GET)
	public String getKeikat(Model model) {
		List<Keikka>keikat = (List<Keikka>) kRepository.findAll();
		model.addAttribute("keikat",keikat);
		return "keikat";
		
		}
	//Lisää keikka kategoria sekä artisti
	 @RequestMapping(value = "/addkeikka", method=RequestMethod.GET)
	    public String addKeikka(Model model){
	    	model.addAttribute("keikka", new Keikka());
	   // 	model.addAttribute("kategoria",kaRepo.findAll());
	        return "addkeikka";
	    }     
		
	    // Tallenna keikka
	    @RequestMapping(value = "/savekeikka", method = RequestMethod.POST)
	    public String save(Keikka keikka){
	       
	    	kRepository.save(keikka);
	       return "redirect:keikat";
	    }    
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		@PreAuthorize("hasAuthority('ADMIN')")
		public String deleteKeikka (@PathVariable("id")Long keikkaId, Model model) {
			kRepository.deleteById(keikkaId);
			return "redirect:../keikat";
			
		}
	
	 // RESTful service to get all gigs
	    @RequestMapping(value="/keikka", method = RequestMethod.GET)
	    public @ResponseBody List<Keikka> keikkaListRest() {	
	        return (List<Keikka>) kRepository.findAll();
	    }    

		// RESTful service to get keikka by id
	    @RequestMapping(value="/keikka/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Keikka> findKeikkaRest(@PathVariable("id") Long keikkaId) {	
	    	return kRepository.findById(keikkaId);
	    }      
	    
	    // RESTful service to save new keikka
	    @RequestMapping(value="/keikka", method = RequestMethod.POST)
	    public @ResponseBody Keikka saveKeikkaRest(@RequestBody Keikka keikka) {	
	    	return kRepository.save(keikka);
	    }

}
