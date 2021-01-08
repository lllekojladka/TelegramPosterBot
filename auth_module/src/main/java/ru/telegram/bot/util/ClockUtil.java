package ru.telegram.bot.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class ClockUtil {

    private final Clock clock;


    public Date getCurrentDate() {
        return toDate(clock);
    }


    private Date toDate(Clock clock) {
        return Date.from(clock.instant());
    }


    public Date getCurrentDatePlusSec(long plusSeconds) {
        return toDate(clock.instant().plusSeconds(plusSeconds));
    }


    private Date toDate(Instant instant) {
        return Date.from(instant);
    }
}
