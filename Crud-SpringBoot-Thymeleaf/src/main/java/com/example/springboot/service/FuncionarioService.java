package com.example.springboot.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.springboot.model.Funcionario;
import com.example.springboot.repository.FuncionarioRepository;


@Service
public interface FuncionarioService {
	
		
	List<Funcionario> getAllFuncionario();
	

		//método salvar funcionário
	    void saveFuncionario(Funcionario funcionario);

	  //método atualizar funcionário
		Funcionario getFuncionarioById(long id);
		
		//método deletar funcionário
		void deleteFuncionarioById(long id);
		
	
	 
		
	}

		