package hh.swd20.KeikkaListaus.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.KeikkaListaus.domain.Kategoria;
import hh.swd20.KeikkaListaus.domain.KategoriaRepository;

@Controller
public class KategoriaController {

	@Autowired
	KategoriaRepository kaRepository;
	
	
	@RequestMapping(value="/kategoriat", method = RequestMethod.GET)
	public String getKategoria(Model model){
		List<Kategoria>kategoriat = (List<Kategoria>)kaRepository.findAll();
		model.addAttribute("kategoriat",kategoriat);
		return"kategoriat";
		
	}
}
