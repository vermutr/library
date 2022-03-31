package net.roma.librarydemo.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.service.UserBookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class Scheduler {

    private final UserBookService userBookService;

    @Scheduled(cron = "${expired.data}")
    void checkExpiredDate() {
        userBookService
                .getAll()
                .stream()
                .filter(userBook -> !userBook.isDebtor())
                .forEach(e -> {
                    if (e.getCreationDate().plusDays(3).isBefore(LocalDate.now())) {
                        e.setDebtor(true);
                        userBookService.save(e);
                    }
                });
    }
}
