package hh.swd20.KeikkaListaus.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import hh.swd20.KeikkaListaus.domain.Kategoria;
import hh.swd20.KeikkaListaus.domain.KategoriaRepository;


@Controller
public class KategoriaController {

	@Autowired
	KategoriaRepository kaRepository;
	
	//hae kategoriat
	@RequestMapping(value="/kategoriat", method = RequestMethod.GET)
	public String getKategoria(Model model){
		List<Kategoria>kategoriat = (List<Kategoria>)kaRepository.findAll();
		model.addAttribute("kategoriat",kategoriat);
		return"kategoriat";
		
	}
	
	//Lisää keikka kategoria 
		 @RequestMapping(value = "/addkategoria", method=RequestMethod.GET)
		    public String addKategoria(Model model){
		    	model.addAttribute("kategoria", new Kategoria());
		        return "addkategoria";
		    }     
	//tallenna kategoria
	@RequestMapping(value="/savekategoria", method = RequestMethod.POST)
	public String save(Kategoria kategoria) {
		kaRepository.save(kategoria);
		return "redirect:kategoriat";
	}
	
	// RESTful service to get all departments
    @RequestMapping(value="/kategoria", method = RequestMethod.GET)
    public @ResponseBody List<Kategoria> getKategoriaRest() {	
        return (List<Kategoria>) kaRepository.findAll();
    }    

	// RESTful service to get department by id
    @RequestMapping(value="/kategoria/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Kategoria> findKategoriaRest(@PathVariable("id") Long kId) {	
    	return kaRepository.findById(kId);
    } 
    
    // RESTful service to save new department
    @RequestMapping(value="/kategoria", method = RequestMethod.POST)
    public @ResponseBody Kategoria saveKategoriaRest(@RequestBody Kategoria kategoria) {	
    	return kaRepository.save(kategoria);
    }
	
}
