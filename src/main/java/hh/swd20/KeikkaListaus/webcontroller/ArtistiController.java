package hh.swd20.KeikkaListaus.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.KeikkaListaus.domain.Artisti;
import hh.swd20.KeikkaListaus.domain.ArtistiRepository;

@Controller
public class ArtistiController {

	
	@Autowired
	ArtistiRepository aRepository;
	
	@RequestMapping(value="/artistit", method = RequestMethod.GET)
	public String getArtisti(Model model) {
		List<Artisti>artistit = (List<Artisti>) aRepository.findAll();
		model.addAttribute("artistit",artistit);
		return"artistit";
	}
	
	//Lisää keikka kategoria 
	 @RequestMapping(value = "/addartisti", method=RequestMethod.GET)
	    public String addArtisti(Model model){
	    	model.addAttribute("artisti", new Artisti());
	        return "artistit";
	    }     
//tallenna artisti
@RequestMapping(value="/saveartisti", method = RequestMethod.POST)
public String save(Artisti artisti) {
	aRepository.save(artisti);
	return "redirect:artistit";
}
	
	
}
