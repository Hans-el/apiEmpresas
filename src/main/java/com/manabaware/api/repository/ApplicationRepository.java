package com.manabaware.api.repository;

import com.manabaware.api.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a JOIN FETCH a.jobOffer WHERE a.jobOffer.id = :jobOfferId")
    List<Application> findByJobOfferIdWithJobOffer(@Param("jobOfferId") Long jobOfferId);
}