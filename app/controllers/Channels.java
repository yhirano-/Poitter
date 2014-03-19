package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Channel;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

public class Channels extends Controller {
	public static Result show(String channel_id) {
		Form<Channel> channel_form = form(Channel.class);
		List<Channel> list = Channel.find.where().eq("channel_id", channel_id).orderBy("created").findList();
		return ok(ChannelsView.render(channel_id, channel_form, list));
	}
	
	public static Result post(String channel_id) {
		Form<Channel> channel_form = form(Channel.class).bindFromRequest();
		if (!channel_form.hasErrors()) {
			Channel channel = channel_form.get();
			if (channel.body != null && channel.body.length() > 0) {
				channel.channel_id = channel_id;
				channel.save();
			}
		}
		return redirect(routes.Channels.show(channel_id));
	}
}
