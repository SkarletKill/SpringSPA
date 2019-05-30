package ua.kpi.utils;

import org.springframework.stereotype.Service;
import ua.kpi.entities.News;
import ua.kpi.models.NewsDetailsRequestModel;

@Service
public class NewsRequestParser {
    public News getNews(NewsDetailsRequestModel model) {
        News news = new News();
        news.setContent(model.getContent());
        news.setTitle(model.getTitle());
        return news;
    }
}
