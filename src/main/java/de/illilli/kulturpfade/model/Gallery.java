package de.illilli.kulturpfade.model;

import java.util.Objects;

public class Gallery {

    private String href;
    private String title;

    public String getHref() {
        return href;
    }

    public String getTitle() {
        return title;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gallery gallery = (Gallery) o;
        return Objects.equals(href, gallery.href) && Objects.equals(title, gallery.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, title);
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "href='" + href + '\'' +
                ", titel='" + title + '\'' +
                '}';
    }
}
