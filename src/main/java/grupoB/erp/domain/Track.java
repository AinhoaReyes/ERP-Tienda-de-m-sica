package grupoB.erp.domain;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;

@Entity
@Table(name = "track")
@Data
public class Track implements Serializable{
    private static final long serialVersionUID = 1L;

    enum TrackFormat{
        cd, vinyl, digital
    }

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String album;

    @Column(name = "record_label", nullable = false)
    private String recordLabel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TrackFormat format;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Id
    private Product product;
}


