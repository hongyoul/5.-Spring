package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.order.entity.Order;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.stats.repository.StatsRepository;

@SpringBootTest
public class OrderRepositoryTest {

      @Autowired
      OrderRepository orderRepository;
      
      @Autowired
      StatsRepository statsRepository;
   
      LocalDate localdate1 = LocalDate.of(2024, 10, 10);
      LocalDate localdate2 = LocalDate.now();      
      @Test
      void 등록() {
         
         Order order1 = Order.builder().orderDate(localdate1).price(10000).productName("무선 이어폰").build();
         Order order2 = Order.builder().orderDate(localdate1).price(20000).productName("블루투스 스피커").build();
         Order order3 = Order.builder().orderDate(localdate2).price(30000).productName("스마트 워치").build();
         Order order4 = Order.builder().orderDate(localdate2).price(40000).productName("노트북").build();
         Order order5 = Order.builder().orderDate(localdate2).price(50000).productName("게이밍 마우스").build();
         
         orderRepository.save(order1);
         orderRepository.save(order2);
         orderRepository.save(order3);
         orderRepository.save(order4);
         orderRepository.save(order5);
         
      }
      
      @Test
      void 지난_주문이력_삭제() {
            // 현재 날짜 구하기
            LocalDate now = LocalDate.of(2024, 10, 11);
            
            // 어제 날짜 구하기
            LocalDate yesterday = now.minusDays(1);
            
            // 주문 목록 조회
            List<Order> list = orderRepository.findAll();
            
            // 전날 들어온 주문이력을 찾아서 삭제
            list.stream().forEach(entity -> {
               int no = entity.getNo();
               LocalDate orderDate = entity.getOrderDate();
               
               if (orderDate.equals(yesterday)) {
                  orderRepository.deleteById(no);
                  System.out.println(no + " 삭제~");
               }
            });

      }
}
