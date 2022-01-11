package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.springboot.model.Funcionario;
import com.example.springboot.service.FuncionarioService;





@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	//lista de funcionarios
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listFuncionario", funcionarioService.getAllFuncionario());
		return "index";
		
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Funcionario funcionario = new Funcionario();
		model.addAttribute("funcionario", funcionario);
		return "novo funcionario";
		
	}
	
	
	@PostMapping("/saveFuncionario")
	public String saveFuncionario(@ModelAttribute("funcionario")Funcionario funcionario) {
		funcionarioService.saveFuncionario(funcionario);
		 return "redirect:/";
		
	}

	 @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
	       
				Funcionario funcionario = funcionarioService.getFuncionarioById(id);

	        model.addAttribute("funcionario", funcionario);
	        return "atualizar funcionario";
	    

	 }
	 
	 
	@GetMapping("/deleteEmployee/{id}")
	    public String deleteFuncionario(@PathVariable(value = "id") long id) {

	        //chama o método deletar  
	        this.funcionarioService.deleteFuncionarioById(id);
	        return "redirect:/";
	    }

	

}