package net.roma.librarydemo.mystarter;

import com.example.hellostarter.IntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloStarter {

    private final IntroductionService introductionService;

    @EventListener(ContextRefreshedEvent.class)
    void contextRefreshedEvent() {
        introductionService.sayHello();
    }


}
