package com.arpgalaxy.bolg.dao;

import com.arpgalaxy.bolg.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles,Integer> {
    @Override
    List<Articles> findAll();

        @Query(value = "select * from articles where article_title like %?1% ORDER BY articles.article_date DESC",nativeQuery = true)
    List<Articles> findByLikeName(String name);

    @Query(value = "select * from articles where article_title =?1 ORDER BY articles.article_date DESC",nativeQuery = true)
    List<Articles> findByName(String name);
    @Override
    Optional<Articles> findById(Integer integer);
}
