package com.example.springboot.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.repository.FuncionarioRepository;


import com.example.springboot.model.Funcionario;


@Service
public class FuncionarioServiceImplements implements FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	@Override
	public void saveFuncionario(Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
	}
	
	
	@Override
    public Funcionario getFuncionarioById(long id) {
         Optional<Funcionario> optional = funcionarioRepository.findById(id);
        Funcionario funcionario = null;
        if (optional.isPresent()) {
            funcionario = optional.get();
        } else {
            throw new RuntimeException(" Id do funcionario não encontrado :: " + id);
        }
        return funcionario;
    }

	
	  @Override
	    public void deleteFuncionarioById(long id) {
	        this.funcionarioRepository.deleteById(id);
	    }

	


	
	}
	
	

	
	
	
	
	

