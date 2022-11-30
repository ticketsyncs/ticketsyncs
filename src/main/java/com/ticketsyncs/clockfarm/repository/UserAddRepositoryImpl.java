package com.ticketsyncs.clockfarm.repository;

import com.ticketsyncs.clockfarm.postgres.PgUser;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Repository
@RequiredArgsConstructor
public class UserAddRepositoryImpl implements UserAddRepository {

  private static final String SQL_SAVE_USER =
      "INSERT INTO ticket_syncs.user_account(username, password) VALUES (:username, :pass)";
  private final DatabaseClient db;

  @Override
  public Mono<Void> add(PgUser user) {
    return this.db.sql(SQL_SAVE_USER)
        .bind("username", user.getUsername())
        .bind("pass", user.getPassword())
        .fetch()
        .first()
        .then();
  }
}