package com.mvcdemo.web.service.impl;

import com.mvcdemo.web.dto.EventDto;
import com.mvcdemo.web.mapper.EventMapper;
import com.mvcdemo.web.models.Club;
import com.mvcdemo.web.models.Event;
import com.mvcdemo.web.repository.ClubRepository;
import com.mvcdemo.web.repository.EventRepository;
import com.mvcdemo.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mvcdemo.web.mapper.EventMapper.mapToEvent;
import static com.mvcdemo.web.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ClubRepository   clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventReporsitory, ClubRepository clubRepository) {
        this.eventRepository = eventReporsitory;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }


}
