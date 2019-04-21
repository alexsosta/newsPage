package app.repositories;

import app.enitites.News;
import org.springframework.data.repository.CrudRepository;

import java.util.List;;

public interface NewsRepository extends CrudRepository<News, Long> {

    List<News> findByTextContaining(String text);

    List<News> findByTitleContaining(String title);

    List<News> findByCategoryId(int category_id);

    News findById(int id);
}
