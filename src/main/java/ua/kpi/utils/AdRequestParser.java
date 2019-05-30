package ua.kpi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.entities.Ad;
import ua.kpi.entities.Composition;
import ua.kpi.models.AdDetailsRequestModel;
import ua.kpi.repositories.CompositionRepository;

@Service
public class AdRequestParser {
    private CompositionRepository repository;

    @Autowired
    public AdRequestParser(CompositionRepository repository) {
        this.repository = repository;
    }

    public Ad getAd(AdDetailsRequestModel model) {
        if (model == null) { return null; }

        Composition composition = repository.findById(model.getCompositionId()).orElse(null);
        Ad ad = new Ad();
        ad.setComposition(composition);
        ad.setText(model.getText());
        ad.setTitle(model.getTitle());
        return ad;
    }
}
