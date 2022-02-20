package com.ab180.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab180.demo.domain.LncsMng;
import com.ab180.demo.mapper.MvcMapper;

@Service
public class MvcService {

	@Autowired
	private MvcMapper mvcMapper;

	public List<LncsMng> getList() {
		return mvcMapper.getList();
	}
}
