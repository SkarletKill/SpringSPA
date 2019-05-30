package ua.kpi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.entities.Ad;
import ua.kpi.exceptions.AdNotFoundException;
import ua.kpi.repositories.AdRepository;

import java.util.List;

@Service
public class AdService {
    private AdRepository repository;
    private CompositionService service;

    @Autowired
    public AdService(AdRepository repository, CompositionService service) {
        this.repository = repository;
        this.service = service;
    }

    public List<Ad> getAllAds() { return repository.findAll(); }

    public Long getAdsCount() { return  repository.count(); }

    public Ad newAd(Ad ad) {
        return repository.save(ad);
    }

    public Ad one(Long id) {
        return repository.findById(id).orElseThrow(() -> new AdNotFoundException(id));
    }

    public Ad replaceAd(Ad newAd, Long id) {
        return repository.findById(id)
                .map((ad) -> {
                    ad.setTitle(newAd.getTitle());
                    ad.setText(newAd.getText());
                    ad.setComposition(newAd.getComposition());
                    return repository.save(ad);
                }).orElseGet(() -> {
                    newAd.setId(id);
                    return repository.save(newAd);
                });
    }

    public void deleteAd(Long id) {
        repository.deleteById(id);
    }
}
