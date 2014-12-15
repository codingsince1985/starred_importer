package com.j5ee.starred.importer.domain;

import java.util.List;

public class Item {
    private String crawlTimeMsec;
    private String timestampUsec;
    private String id;
    private List<String> categories;
    private String title;
    private int published;
    private int updated;
    private List<Alternate> alternate;
    private Summary summary;
    private Content content;
    private String author;
    private List<String> comments;
    private List<Annotation> annotations;
    private Origin origin;

    public String getCrawlTimeMsec() {
        return crawlTimeMsec;
    }

    public void setCrawlTimeMsec(String crawlTimeMsec) {
        this.crawlTimeMsec = crawlTimeMsec;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getTimestampUsec() {
        return timestampUsec;
    }

    public void setTimestampUsec(String timestampUsec) {
        this.timestampUsec = timestampUsec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public List<Alternate> getAlternate() {
        return alternate;
    }

    public void setAlternate(List<Alternate> alternate) {
        this.alternate = alternate;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
