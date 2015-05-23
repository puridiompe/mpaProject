package com.puridiompe.mpa.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puridiompe.mpa.domain.persistence.TrafficTicket;

public interface TrafficTicketRepository extends JpaRepository<TrafficTicket, Integer>{

}
