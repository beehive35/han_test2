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
public class CsvController {

	@Autowired
	private CsvService csvService;

	@RequestMapping(value = "/controller", method = RequestMethod.GET)
//	@RequestMapping(value = "/getFirstNameCount")
	public String getFirstNameCount() {
		String filePath = "C:\\ab180\\ab180\\test_1.csv";

		List<List<String>> dataList = csvService.ReadCsv(filePath);
		int count = 0;

		dataList.remove(0); // 제목 첫줄 제거

//		System.err.println(dataList);
//		
//		dataList.stream().filter(m -> m.get(0).contains("jung"))
//		                 .collect(Collectors.toList());
////		                 .forEach(null)

		Map<String, Integer> result = new HashMap<>();

		dataList.stream().flatMap(member -> Arrays.stream(member.get(1).split(":"))) // 취미를 플랫하게 스트림으로 분리
				         .forEach(hobby -> result.merge(hobby, 1, (oldValue, newValue) -> ++oldValue));

		// 출력
		result.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		return "test/test";
//		return "index";
	}
}
