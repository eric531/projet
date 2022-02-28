package com.erictohe.projet.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.erictohe.projet.dao.EntrepriseRepository;
import com.erictohe.projet.dao.TaxeRepository;
import com.erictohe.projet.entities.Entreprise;
import com.erictohe.projet.entities.Taxe;

import org.springframework.data.domain.Page;
@Controller 
public class TaxeController {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxeRepository;
	@RequestMapping(value="/entreprises",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE )
	public String index(Model model,
			@RequestParam(defaultValue="")String motCle,
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="4") int s){
		Page<Entreprise> pageEntreprises=entrepriseRepository.chercher(motCle, PageRequest.of(p, s));
		model.addAttribute("listEntreprises", pageEntreprises.getContent());
		int[] pages=new int[pageEntreprises.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", motCle);
		return "entreprises";
	}
	@RequestMapping(value="/formEntreprise")
	public String formEntreprise(Model model) {
		model.addAttribute("entreprise",new Entreprise());
		return "formEntreprise";
	}
	@RequestMapping(value="/saveEntreprise")
	public String save(Model model,Entreprise e) {
		entrepriseRepository.save(e);
		return "redirect:/entreprises";
	}
	
	@RequestMapping(value="/taxes")
	public String taxes(Model model,
			@RequestParam(name="code", defaultValue="-1")Long code) {
		 model.addAttribute("entreprises", entrepriseRepository.findAll()); 
		 if(code==-1) model.addAttribute("taxes",new ArrayList<Taxe>());
		 else {
				Entreprise e=new Entreprise();
				e.setCode(code);
				/* model.addAttribute("entreprises",taxeRepository.findAll()); */
				model.addAttribute("taxes",taxeRepository.findByEntreprise(e));
		 }
		 return "taxes";
	}
	
	/*
	 * @RequestMapping(value="/update") public String update(Model model) {
	 * model.addAttribute("entreprise",new Entreprise()); return "update"; }
	 */
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String formEntreprise(Model model,
			@RequestParam(required=false) Long code) {
		Entreprise entreprise= entrepriseRepository.finOnes(code);
		model.addAttribute("entreprise",new Entreprise());
		return "update";
	}
	@RequestMapping(value="/saveUpdate")
	public String save1(Model model,Entreprise e) {
		entrepriseRepository.save(e);
		return "redirect:/entreprises";
	} 
	
	 @RequestMapping( value =  "/delete/{code}" , method = RequestMethod . DELETE ) 
	 public  void  delete( @PathVariable String code )  { 
	     entrepriseRepository.delete(null);
	     return;
	 }
	/*
	 * @UpdateMapping public String update(Model model) {
	 * 
	 * }
	 */
	
	/*
	 * @DeleteMapping(value="/delete/{code}") public String delete(Model model,
	 * 
	 * @RequestParam(name="code")Long code) { ModelAndView mv= new ModelAndView();
	 * model.addAttribute("entreprises", entrepriseRepository.findAll());
	 * List<Entreprise> return "delete"; }
	 */
	/*
	 * @DeleteMapping(value = "/delete/{id}") public String delete
	 * deletePost(@PathVariable Long code) {
	 * 
	 * var isRemoved = entreprise.delete(code);
	 * 
	 * si (!isRemoved) { renvoie une nouvelle
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * 
	 * renvoie une nouvelle ResponseEntity<>(id, HttpStatus.OK); }
	 */
}

