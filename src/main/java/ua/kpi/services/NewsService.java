package ua.kpi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.entities.News;
import ua.kpi.exceptions.NewsNotFoundException;
import ua.kpi.repositories.NewsRepository;

import java.util.List;

@Service
public class NewsService {
    private NewsRepository repository;

    @Autowired
    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public List<News> getAllNews() {
        return  repository.findAll();
    }

    public long getNewsCount() {
        return repository.count();
    }

    public News newNews(News newNews) { return repository.save(newNews); }

    public News one(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException(id));
    }

    public News replaceNews(News newNews, Long id) {
        return repository.findById(id)
                .map(news -> {
                    news.setTitle(newNews.getTitle());
                    news.setContent(newNews.getContent());
                    return repository.save(news);
                }).orElseGet(() -> {
                    newNews.setId(id);
                    return repository.save(newNews);
                });
    }

    public void deleteNews(Long id) { repository.deleteById(id); }
}
