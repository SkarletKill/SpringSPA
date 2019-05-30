package ua.kpi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.models.Statistics;

@Service
public class StatisticsService {
    private CompositionService compositionService;
    private ComposerService composerService;
    private AdService adService;
    private NewsService newsService;

    public StatisticsService(CompositionService compositionService, ComposerService composerService, AdService adService, NewsService newsService) {
        this.compositionService = compositionService;
        this.composerService = composerService;
        this.adService = adService;
        this.newsService = newsService;
    }

    public Statistics getStatistics() {
        return Statistics.builder()
                .composerCount(this.composerService.getComposersCount())
                .compositionCount(this.compositionService.getCompositionCount())
                .adCount(this.adService.getAdsCount())
                .newsCount(this.newsService.getNewsCount())
                .build();
    }
}
