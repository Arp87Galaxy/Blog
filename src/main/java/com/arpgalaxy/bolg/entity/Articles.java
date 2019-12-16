package com.arpgalaxy.bolg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Articles implements Serializable {
    @Id
    @GeneratedValue
    private int articleId;

    @Column(nullable = false,name = "user_id")
    private long userId;

    @Column(nullable = false,name = "article_title")
    private String articleTitle;

    @Column(nullable = false,name = "article_overview")
    private String articleOverview;

    @Column(nullable = false,name = "article_path")
    private String articlePath;

    @Column(nullable = false,name = "article_views")
    private int articleViews;

    @Column(nullable = false,name = "article_comment_count")
    private int articleCommentCount;

    @Column(nullable = false,name = "article_date")
    private Date articleDate;

    @Column(nullable = false,name = "article_like_count")
    private int articleLikeCount;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleOverview() {
        return articleOverview;
    }

    public void setArticleOverview(String articleOverview) {
        this.articleOverview = articleOverview;
    }

    public String getArticlePath() {
        return articlePath;
    }

    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }

    public int getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(int articleViews) {
        this.articleViews = articleViews;
    }

    public int getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(int articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public int getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(int articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }
}
