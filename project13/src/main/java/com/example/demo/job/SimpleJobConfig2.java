package com.example.demo.job;

import java.time.LocalDateTime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SimpleJobConfig2 {

	@Autowired
	JobRepository jobRegistry;
	
	@Autowired
	PlatformTransactionManager manager;
	
	@Bean 
	public Job simpleJob1() {
		
		Job job = new JobBuilder("simpleJob", jobRegistry)
						.start(step1())
						.next(step2())
						.next(step3())
						.build();
		
			return job;
	}
	
	@Bean 
	public Step step1() {
		
		Step step = new StepBuilder("step1..", jobRegistry)
						.tasklet(testTasklet(), manager)
						.build();
		
		return step;
	}
	
	@Bean 
	public Step step2() {
		
		Step step = new StepBuilder("step2..", jobRegistry)
						.tasklet(testTasklet2(), manager)
						.build();
		
			return step;
	}
	
	@Bean 
	public Step step3() {
		
		Step step = new StepBuilder("step3..", jobRegistry)
						.tasklet(testTasklet3(), manager)
						.build();
		
			return step;
	}
	
	@Bean 
	public Tasklet testTasklet() {
		
		Tasklet tasklet = (contribution, chunkContext) -> {
			
			System.out.println("step1. " + LocalDateTime.now());
			
			return RepeatStatus.FINISHED;
		};
		
			return tasklet;
	}
	
	@Bean 
	public Tasklet testTasklet2() {
		
		Tasklet tasklet = (contribution, chunkContext) -> {
			
			System.out.println("step2. " + LocalDateTime.now());
			
			return RepeatStatus.FINISHED;
		};
		
			return tasklet;
	}
	
	@Bean 
	public Tasklet testTasklet3() {
		
		Tasklet tasklet = (contribution, chunkContext) -> {
			
			System.out.println("step3. " + LocalDateTime.now());
			
			return RepeatStatus.FINISHED;
		};
		
			return tasklet;
	}
}
