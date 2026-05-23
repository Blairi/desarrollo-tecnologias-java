package mx.unam.dgtic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHAPTER")
public class Chapter {
    @Id
    @Column(name = "ISBN")
    private int chapterNumber;

//    private Book book;

    @Column(name = "TITLE")
    private String title;

    public Chapter() {
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
