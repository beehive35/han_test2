package com.ab180.demo.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CsvController4 {

	@RequestMapping(value = "/controller4", method = RequestMethod.GET)
	public String getList() throws IOException {

		// 파일 내용을 소스로 하는 스트림
		Path path = Paths.get("C:\\ab180\\ab180\\test_1.csv");
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		
		System.err.println("111111");
		
		stream.skip(1)
		      .filter(m -> m.contains("jung"))
		      .flatMap(m -> Arrays.stream(m.split(",")))
//		      .limit(2) 
//		      .skip(1)
		      .forEach(System.err::println);

		System.err.println("222222");

		System.out.println();

		return "test/test";
	}

}
