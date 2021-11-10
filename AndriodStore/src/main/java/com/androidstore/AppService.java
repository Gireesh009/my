package com.androidstore;

import java.util.List;
import org.springframework.data.domain.Page;
public interface AppService {

	List <Astore> getapp();
	void saveApp(Astore astore);
	Astore getAppById(long id);

	void deleteAppById(long id);
	List <Astore> findByKeyword(String keyword);
	Page<Astore> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
