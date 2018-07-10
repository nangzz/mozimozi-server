package com.prography.appdev1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.prography.appdev1.mapper.dataMapper;


@Component
public class CronTable {
	
	@Autowired
	private dataMapper dm;

	
	@Scheduled(cron = "0 0 0 * * *")
	public void aJob() {
		
		try {
		dm.deleteTodayProduct();
		dm.setTodayProduct();
		System.out.println("실행 되고 있음");
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
}
