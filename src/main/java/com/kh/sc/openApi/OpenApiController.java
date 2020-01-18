package com.kh.sc.openApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 


@Controller
public class OpenApiController {

	@RequestMapping("/openApi/openApiRun.do")
	@ResponseBody
	public static Map<String,String> planExamAPI() {
		 Map<String,String> map= new HashMap();
		 
		try {
		StringBuilder urlBuilder = new StringBuilder("http://openapi.q-net.or.kr/api/service/rest/InquiryTestDatesNationalProfessionalQualificationSVC/getList"); /*URL*/
        
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=OWGL3QLLsoaqhascZ8Lz3TfHs%2FXvi5QSrmg9lQhHtpDU2kotIyF%2FDRLI4p9tBduphT%2FPRW5azD%2F648D6CwRhnw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("OWGL3QLLsoaqhascZ8Lz3TfHs%2FXvi5QSrmg9lQhHtpDU2kotIyF%2FDRLI4p9tBduphT%2FPRW5azD%2F648D6CwRhnw%3D%3D", "UTF-8")); /*발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("seriesCd","UTF-8") + "=" + URLEncoder.encode("03", "UTF-8")); /*계열코드*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*json으로 받기*/
        
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
       // System.out.println(sb.toString());
        //System.out.println(sb.getClass().getName());
       String info =  sb.toString();
        
        map.put("test", info);
     
    } catch(Exception e) {
    	
    	System.out.println(e.getMessage());
    	
    }
		return map;
	}
}
