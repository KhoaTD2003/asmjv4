package com.poly.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="history")
public class History {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId",referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
	private User user ;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "videoId",referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
	private Video video;
	
	@Column(name="viewedate")
	@CreationTimestamp
	private Timestamp viewedate;
	
	@Column(name="isLiked")
	private Boolean isLiked;
	
	@Column(name="likedDate")
	private Timestamp likeDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Timestamp getViewedate() {
		return viewedate;
	}

	public void setViewedate(Timestamp viewedate) {
		this.viewedate = viewedate;
	}

	public Boolean getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}

	public Timestamp getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Timestamp likeDate) {
		this.likeDate = likeDate;
	}

	public History(Integer id, User user, Video video, Timestamp viewedate, Boolean isLiked, Timestamp likeDate) {
		super();
		this.id = id;
		this.user = user;
		this.video = video;
		this.viewedate = viewedate;
		this.isLiked = isLiked;
		this.likeDate = likeDate;
	}

	public History() {
		super();
	}
	
}
