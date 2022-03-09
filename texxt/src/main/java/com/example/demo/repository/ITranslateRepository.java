package com.example.demo.repository;

import com.example.demo.model.Translate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITranslateRepository extends JpaRepository<Translate,Integer> {
    @Query(value = "select * from translate where flag =1", nativeQuery = true)
    List<Translate> findAll();

    Translate findTranslateById(Integer id);

    @Query(value = "select * from translate\n" +
            "join customer on customer.id = translate.customer_id\n" +
            "join service_type on service_type.id = translate.service_type_id\n" +
            "where service_type_name like %?1% and customer_name like %?2%", nativeQuery = true)
    List<Translate> searchTranslate(String serviceType, String customerName);
}
