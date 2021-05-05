package com.example.users.infrastructure.repository.springdata.mongodb;

import com.example.users.infrastructure.repository.springdata.mongodb.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringDataMongoDBUsersRepository extends MongoRepository<UserDocument, UUID> {}
