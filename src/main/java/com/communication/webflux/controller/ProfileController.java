package com.communication.webflux.controller;

import com.communication.webflux.model.ProfileGithub;
import com.communication.webflux.repository.ProfileGitHubRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileGitHubRepository repository;

    public ProfileController(ProfileGitHubRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProfileGithub> addProfile(@RequestBody ProfileGithub profileGithub) {
        return repository.save(profileGithub);
    }

    @GetMapping("/{id}")
    public Mono<ProfileGithub> findById(@PathVariable String id) {
        return repository.findById(id);
    }

    @GetMapping
    public Flux<ProfileGithub> findAll() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable String id) {
        return repository.deleteById(id);
    }

}
