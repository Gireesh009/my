package com.androidstore;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AppRepository extends JpaRepository<Astore,Long> {
	
  @Query(value="Select * from Astore a where  a.app_name like %:keyword% or  a.publisher like %:keyword% or  a.app_type like %:keyword%", nativeQuery=true)
	List<Astore> findByKeyword(@Param("keyword") String keyword);
 // @Query(value="Select * from Astore a where  a.app_name order by Asc ", nativeQuery=true)
 //  List<Astore> findByOrderByNameAsc();
//  @Query("FROM Astore")
//  List<Astore> findOrderByNameAsc(Sort sort);
}
