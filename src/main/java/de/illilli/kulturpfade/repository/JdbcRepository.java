package de.illilli.kulturpfade.repository;

import java.util.List;

public interface JdbcRepository<T> {

    List<T> find();

}
