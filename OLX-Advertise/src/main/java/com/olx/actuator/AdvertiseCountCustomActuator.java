package com.olx.actuator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "advstats")
public class AdvertiseCountCustomActuator {
	
	
	@ReadOperation
	public void getAllAdCount() {
		
		Random random = new Random();
		int randomNo = random.nextInt(100);
		int rand1 = random.nextInt(70);
		int rand2 = random.nextInt(40);
		
		Map<String, List<String>> AdsCount = new HashMap<>();
		
		AdsCount.put("Total No of Ads :", Arrays.asList("Total No of Ads :", "80"));
		AdsCount.put("No of Open Ads :",
				Arrays.asList("No of Open Ads :", "45"));
		
		System.out.println(AdsCount);
	
		
		
		
//		System.out.println("Total No of Ads : " +randomNo);
//		System.out.println("No of Open Ads : " +rand1);
//		System.out.println("No of Ads posted in a last month : " +rand2);
		
//		Map<String, Integer> AdsCount = new HashMap<String, Integer>();
//		AdsCount.put("Total No of Ads", +randomNo);
//		AdsCount.put("No of Open Ads", +rand1);
//		AdsCount.put("No of Ads posted in a last month", +rand2);
//		
       
	}

}
