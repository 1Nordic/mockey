package com.lhamacorp.mockey.repository;

import java.time.Instant;

public interface MockRepositoryCustom {
    void updateLastAccessed(String id, Instant lastAccessed);
}
