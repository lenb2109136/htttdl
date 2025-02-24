package com.example.htttdl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.htttdl.modal.Xa;

@Service
public class XaService {
	@Autowired
	private XaService xaService;
	
	public List<Xa> getXaByHuyen(int id){
		return xaService.getXaByHuyen(id);
	}
}
