//package com.example.demo.job;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.scope.context.StepContext;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.core.step.tasklet.TaskletStep;
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import com.example.demo.order.entity.Order;
//import com.example.demo.order.repository.OrderRepository;
//import com.example.demo.stats.entity.Stats;
//import com.example.demo.stats.repository.StatsRepository;
//
//@Configuration
//public class SimpleJobConfig {
//
//      @Autowired
//      JobRepository jobRepository;
//      
//      @Autowired
//      PlatformTransactionManager manager;
//      
//      @Autowired
//      StatsRepository statsRepository;
//      
//      @Autowired
//      OrderRepository orderRepository;
//      
//      // 배치에 등록할 Job을 빈으로 저장
//      @Bean
//      public Job simpleJob1() {
//         
//         Job job = new JobBuilder("simpleJob", jobRepository)
//                                                                                       .start(step1())
//                                                                                       .next(step2())
//                                                                                       .next(step3())
//                                                                                       .build();
//                                             
//         
//         return job;
//      }
//      
//      @Bean
//      public Step step1() {
//         
//         TaskletStep step = new StepBuilder("step1.." , jobRepository)
//                                                            .tasklet(testTasklet(), manager)
//                                                            .build();
//         return step;
//      }
//      
//      @Bean
//      public Step step2() {
//         
//         TaskletStep step = new StepBuilder("step2.." , jobRepository)
//                                                            .tasklet(testTasklet2(), manager)
//                                                            .build();
//         return step;
//      }
//      
//      @Bean
//      public Step step3() {
//         
//         TaskletStep step = new StepBuilder("step3.." , jobRepository)
//                                                            .tasklet(testTasklet3(), manager)
//                                                            .build();
//         return step;
//      }
//      
//
//      @Bean
//      public Tasklet testTasklet() {
//         
//         Tasklet tasklet = (contribution,  chunkContext) -> {
//
//            
//               System.out.println("Step1. 주문 건수와 금액 계산하기");
//               
//               LocalDate now = LocalDate.of(2024, 10, 11);
//
//               List<Order> list = orderRepository.findByOrderDate(now);
//               
//               long count = list.stream().count();
//               int totalPrice = list.stream()
//                                                               .mapToInt(e -> e.getPrice())
//                                                               .sum();
//
//               
//               // 다음 스텝에 값을 전달하기 위해
//               // 컨텍스트 안에 값을 저장
//               StepContext context = chunkContext.getStepContext();
//               
//               ExecutionContext executionContext = context
//                                                                                    .getStepExecution()
//                                                                                    .getJobExecution()
//                                                                                    .getExecutionContext();
//               
//               executionContext.put("count", count);
//               executionContext.put("totalPrice", totalPrice);
//            
//               return RepeatStatus.FINISHED;
//         };
//         
//         return tasklet;
//         
//      }
//      
//      @Bean
//      public Tasklet testTasklet2() {
//         
//         Tasklet tasklet = (contribution,  chunkContext) -> {
//
//            System.out.println("Step2. 통계 테이블에 저장하기");
//            
//            // 컨텍스트에서 이전 단계에서 생성한 데이터 꺼내기
//            StepContext context = chunkContext.getStepContext();
//            ExecutionContext executionContext = context
//                                                                                 .getStepExecution()
//                                                                                 .getJobExecution()
//                                                                                 .getExecutionContext();
//            
//            String count = executionContext
//                                                            .get("count")
//                                                            .toString();
//            
//            String totalPrice = executionContext
//                                                            .get("totalPrice")
//                                                            .toString();
//            
//            long countNum = Long.parseLong(count);
//            
//            int priceNum = Integer.parseInt(totalPrice);
//                        
//            // 통계 테이블에 데이터 저장
//            Stats stats = Stats.builder()
//                                                   .orderDt(LocalDate.now())
//                                                   .count(countNum)
//                                                   .totalPrice(priceNum)
//                                                   .build();   
//            
//            statsRepository.save(stats);
//
//            return RepeatStatus.FINISHED;
//            
//         };
//         
//         return tasklet;
//         
//      }
//   
//      @Bean
//      public Tasklet testTasklet3() {
//         
//         Tasklet tasklet = (contribution,  chunkContext) -> {
//
//            System.out.println("Step3. 전날 주문 이력 삭제");
//
//            LocalDate now = LocalDate.of(2024, 10, 11);
//            
//            LocalDate yesterday = now.minusDays(1);
//            
//            orderRepository.removeByOrderDate(yesterday);
//            
//            return RepeatStatus.FINISHED;
//
//         };
//         
//         return tasklet;
//         
//      }
//   
//}
