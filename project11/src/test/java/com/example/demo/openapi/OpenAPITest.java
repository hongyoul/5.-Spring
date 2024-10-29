package com.example.demo.openapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



public class OpenAPITest {
	
	String key = "공공데이터 마이페이지에서 키값은 복사해서 사용하기";

	
	public String getWeather() throws IOException {
		
		
	    StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode("11B20201", "UTF-8")); /*11A00101(백령도), 11B10101 (서울), 11B20201(인천) 등... 별첨 엑셀자료 참조(‘육상’ 구분 값 참고)*/
        @SuppressWarnings("deprecation")
		URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString()); //JSON 형식의 문자열로 반환되는 부분(즉, 원하는 부분을 꺼낼 수 없기 때문에 파싱이 필요함)
        
        // 응답데이터 반환 부분↓
        return sb.toString();
	}
	
	// JSON 문자열을 클래스로 변환하기
	@Test
	public void jsonToDto() throws IOException {
		
		// 매퍼 객체 생성
		ObjectMapper mapper = new ObjectMapper();
		
		// 분석할 수 없는 구문을 무시하는 옵션 설정
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		// 호출하기하면 에러가 남, 예외처리하면 에러가 안남(throws IOException 더져주면 됨)
		// getWeather();
		
		// 날씨 데이터 가져오기
		String weather = getWeather();
		
		Root root = null;
		
		// JSON 문자열을 클래스로 변환
		// 원본테이터, 변환할 클래스
		root = mapper.readValue(weather, Root.class);
		
		System.out.println(root.response.body.items.item.get(0).wf);
		System.out.println(root.response.body.items.item.get(3).wf);
		System.out.println(root.response.header.resultMsg);
		System.out.println(root.response.body.dataType);
		
	}
}

