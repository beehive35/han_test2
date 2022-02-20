package com.ab180.demo.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CsvService {

	public List<List<String>> ReadCsv(String filePath) {
		// 반환용 리스트
		List<List<String>> ret = new ArrayList<List<String>>();
		BufferedReader br = null;

		try {
//			br = Files.newBufferedReader(Paths.get(filePath));
//			Charset.forName("UTF-8");
			br = new BufferedReader(new FileReader(filePath));
			
			String line = "";

			while ((line = br.readLine()) != null) {
				// CSV 1행을 저장하는 리스트
				List<String> tmpList = new ArrayList<String>();
				String array[] = line.split(",");
				// 배열에서 리스트 반환
				tmpList = Arrays.asList(array);
				System.out.println(tmpList);
				ret.add(tmpList);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	void writeCSV(List<List<String>> dataList) {
//        File csv = new File("여기에 .csv파일의 절대경로를 입력한다");
		BufferedWriter bw = null; // 출력 스트림 생성

		try {
//			bw = new BufferedWriter(new FileWriter(csv, true));
			// csv파일의 기존 값에 이어쓰려면 위처럼 true를 지정하고, 기존 값을 덮어쓰려면 true를 삭제한다

			for (int i = 0; i < dataList.size(); i++) {
				List<String> data = dataList.get(i);
				String aData = "";
//				aData = data[0] + "," + data[1] + "," + data[2] + "," + data[3];
				aData = data.get(0) + "," + data.get(1) + "," + data.get(2);
				// 한 줄에 넣을 각 데이터 사이에 ,를 넣는다
				bw.write(aData);
				// 작성한 데이터를 파일에 넣는다
				bw.newLine(); // 개행
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.flush(); // 남아있는 데이터까지 보내 준다
					bw.close(); // 사용한 BufferedWriter를 닫아 준다
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
