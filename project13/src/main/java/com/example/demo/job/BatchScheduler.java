package com.example.demo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler {

	// 배치를 실행하는 컴포넌트
	@Autowired
	JobLauncher jobLauncher;

	// 우리가 만든 배치 작업
	@Autowired
	Job simpleJob1;
	
	// 일정 주기로 JOB을 등록
	@Scheduled(cron = "0/10 * * * * * ")
	public void runBatchJob() throws Exception {
		
		// JOB 실행이력을 관리하기 위한 파라미터
		JobParameters parameters = new JobParametersBuilder()
										.addLong("time", System.currentTimeMillis())
										.toJobParameters();
		
		jobLauncher.run(simpleJob1, parameters);
	}
	
}
