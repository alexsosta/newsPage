package app.enitites;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Size(min = 1, max = 20, message = "1-20 letters and spaces")
    private String title;

    @Size(min = 1, max = 4000, message = "1-4000 letters and spaces")
    private String text;

    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public News() {
    }

    public News(@Size(min = 1, max = 20, message = "1-20 letters and spaces") String title, @Size(min = 1, max = 4000, message = "1-4000 letters and spaces") String text, Date date, Category category) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
