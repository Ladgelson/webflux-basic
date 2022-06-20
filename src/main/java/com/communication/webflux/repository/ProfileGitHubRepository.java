package com.communication.webflux.repository;

import com.communication.webflux.model.ProfileGithub;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileGitHubRepository extends ReactiveMongoRepository<ProfileGithub, String> {
}
