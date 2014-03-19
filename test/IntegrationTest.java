import models.Channel;

import org.junit.*;

import controllers.Channels;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest {
	
	private void post1(String channel_id, String body) {
		Channel channel = new Channel();
    	channel.channel_id = channel_id;
    	channel.body = body;
    	channel.save();
	}

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void test1() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
            	post1("test", "1234");
            	
                browser.goTo("http://localhost:3333/test");
                assertThat(browser.pageSource()).contains("1234");
                assertThat(browser.pageSource()).contains("2014");
                assertThat(browser.pageSource()).contains("更新");

            	post1("test", "ほげほげ");
            	
                browser.goTo("http://localhost:3333/test");
                assertThat(browser.pageSource()).contains("1234");
                assertThat(browser.pageSource()).contains("ほげほげ");
            }
        });
    }

}
