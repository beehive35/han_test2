package com.ab180.demo.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ab180.demo.service.CsvService;

@Controller
public class CsvController2 {

	@Autowired
	private CsvService csvService;

	@RequestMapping(value = "/controller2", method = RequestMethod.GET)
	public String getFirstNameCount() throws IOException {
		// 파일 내용을 소스로 하는 스트림
		Path path = Paths.get("C:\\ab180\\ab180\\test_1.csv");

		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.err::println);
		stream.close();
		System.out.println();

//		Stream<String> stream1 = Files.lines(path, Charset.defaultCharset());
//		stream1.filter(m -> m.contains("jung"))
//				          .map(hobby -> hobby.split(":"))
//				          .collect(null);
//			   .count();                
//		       .forEach(System.err::println);
//		stream1.close();

//		System.out.println("1111111");
//		System.err.println(cnt);
		

//		Stream<String> stream2 = Files.lines(path, Charset.defaultCharset());
//		stream2.collect(Collectors.partitioningBy(","))
//	           .forEach(System.err::println);
//		stream2.close();
		
		return "test/test";
	}
}
