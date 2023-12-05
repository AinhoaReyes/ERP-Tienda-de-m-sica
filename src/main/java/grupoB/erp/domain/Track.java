package grupoB.erp.domain;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name = "track")
@Data
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "album", nullable = false)
    private String album;

    @Column(name = "record_label", nullable = false)
    private String recordLabel;

    @Column(name = "format", nullable = false)
    private TrackFormat format;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;
}


