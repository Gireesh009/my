package com.music;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MusicRepository extends JpaRepository<Music,Long> {
	
    @Query(value="Select * from Music m where  m.artist like %:keyword% or  m.genre like %:keyword%", nativeQuery=true)
	List<Music> findByKeyword(@Param("keyword") String keyword);
}
