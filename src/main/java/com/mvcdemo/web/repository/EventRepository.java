package com.mvcdemo.web.repository;

import com.mvcdemo.web.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {  }
