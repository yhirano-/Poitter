package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.annotation.CreatedTimestamp;

import play.db.ebean.Model;

@Entity
public class Channel extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	public String channel_id;

	@CreatedTimestamp
	public Date created;

	public String body;

	public static Finder<Long, Channel> find = new Finder<Long, Channel>(Long.class, Channel.class);

}
