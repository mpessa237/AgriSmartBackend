package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement,Integer> {
}
