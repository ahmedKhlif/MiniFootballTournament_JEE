package entities;

import java.time.LocalDate;

public class Journee {
    private Long id;
    private Long tournoiId;
    private LocalDate dateJournee;

    public Journee(Long id, Long tournoiId, LocalDate dateJournee) {
        this.id = id;
        this.tournoiId = tournoiId;
        this.dateJournee = dateJournee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTournoiId() {
        return tournoiId;
    }

    public void setTournoiId(Long tournoiId) {
        this.tournoiId = tournoiId;
    }

    public LocalDate getDateJournee() {
        return dateJournee;
    }

    public void setDateJournee(LocalDate dateJournee) {
        this.dateJournee = dateJournee;
    }
}
