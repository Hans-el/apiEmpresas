package com.manabaware.api.repository;

import com.manabaware.api.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {

    // query derivada es más compleja a propósito, usa el patrón:
    // findBy + ActiveTrue (condición 1) + And + ExpiresAtAfter (condición 2, mayor
    // a una fecha) + Or + ExpiresAtIsNull
    // (condición 3, sin fecha de expiración). Se traduce a un WHERE active = true
    // AND (expires_at > ? OR expires_at IS NULL).
    List<JobOffer> findByActiveTrueAndExpiresAtAfterOrExpiresAtIsNull(LocalDateTime now);
}