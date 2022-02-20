package com.ab180.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ab180.demo.service.CsvService;

@Controller
public class CsvController3 {
	@Autowired
	private CsvService csvService;

	@RequestMapping(value = "/controller3", method = RequestMethod.GET)
	public String getList() {

		String filePath = "C:\\ab180\\ab180\\test_1.csv";

		List<List<String>> dataList = csvService.ReadCsv(filePath);

		dataList.remove(0); // 제목 첫줄 제거

		dataList.stream().filter(m -> m.get(0).contains("jung"))
		                 .flatMap(m -> Arrays.stream(m.get(1).split(":"))) // 취미를 플랫하게 스트림으로 분리
		                 .forEach(System.out::println);

		return "test/test";
	}

}
