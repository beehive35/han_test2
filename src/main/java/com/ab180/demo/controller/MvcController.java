package com.ab180.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab180.demo.domain.LncsMng;
import com.ab180.demo.service.MvcService;

@RestController
public class MvcController {

	@Autowired
	private MvcService mvcService;

//	@RequestMapping(value = "/mvcController")
//	public void getList() {
//		List<LncsMng> list = mvcService.getList();
//
//		for (LncsMng data : list) {
//			System.err.println(data.toString());
//		}
//	}

	@GetMapping(value = "/mvcController")
	public void getList() {
		List<LncsMng> list = mvcService.getList();

		for (LncsMng data : list) {
			System.err.println(data.toString());
		}
	}
}
