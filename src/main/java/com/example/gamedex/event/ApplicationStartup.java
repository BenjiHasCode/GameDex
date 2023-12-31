package com.example.gamedex.event;

import com.example.gamedex.model.Game;
import com.example.gamedex.model.Search;
import com.example.gamedex.repository.GameRepository;
import com.example.gamedex.service.GameService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import javax.inject.Inject;
import java.util.Set;

@Component
public class ApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {

    private final GameRepository gameRepository;
    private final GameService gameService;

    @Inject
    public ApplicationStartup(GameRepository gameRepository, GameService gameService) {
        this.gameRepository = gameRepository;
        this.gameService = gameService;
    }

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        Set<Game> games = gameRepository.findALlNonLazy();
        gameService.syncMeili(games);
    }
}
