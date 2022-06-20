package com.communication.webflux.controller;

import com.communication.webflux.model.ProfileGithub;
import com.communication.webflux.repository.ProfileGitHubRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;

@WebFluxTest(controllers = ProfileController.class)
@AutoConfigureWebTestClient
class ProfileControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private ProfileGitHubRepository profileGitHubRepository;

    private static final String BASE_URL = "/api/profiles";

    @BeforeEach
    void setUp() {
        Mockito.when(profileGitHubRepository.findAll())
                .thenReturn(Flux.fromIterable(
                        Collections.singletonList(new ProfileGithub("1", "Ladgelson", Collections.emptyList()))
                ));

        Mockito.when(profileGitHubRepository.findById("1"))
                .thenReturn(Mono.just(new ProfileGithub("1", "Ladgelson", Collections.emptyList())));

        Mockito.when(profileGitHubRepository.save(new ProfileGithub(null, "Ladgelson", Collections.emptyList())))
                .thenReturn(Mono.just(new ProfileGithub("1", "Ladgelson", Collections.emptyList())));
    }

    @Test
    @DisplayName("Should persists a new profile")
    void addProfile() {
        client.post()
                .uri(BASE_URL)
                .body(Mono.just(new ProfileGithub("1", "Ladgelson", Collections.emptyList())), ProfileGithub.class)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(ProfileGithub.class);
    }

    @Test
    @DisplayName("Should returns a profile")
    void findById() {
        client.get()
                .uri(String.format("%s/%d", BASE_URL, 1))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(ProfileGithub.class);
    }

    @Test
    @DisplayName("Should returns a non-empty list of profiles")
    void findAll() {
        client.get()
                .uri(BASE_URL)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(ProfileGithub.class)
                .hasSize(1);
    }

    @Test
    @DisplayName("Should delete a profile")
    void deleteById() {
        client.delete()
                .uri(String.format("%s/%d", BASE_URL, 1))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }
}