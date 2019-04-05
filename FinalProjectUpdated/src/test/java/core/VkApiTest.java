package core;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class VkApiTest {

	private HttpClient client;
	private static String accessToken = "ac0e310e7fd4c5aeac1209be4e3a2a4fe453a789f08fd3b7ebfd0a302bb54c55f1bb5eab6fe3746a95339";
	private static String ownerId = "536083852";
	private static String version = "5.92";

	@Before
	public void setUp() {
		client = HttpClientBuilder.create().build();
	}

	@Test
	public void addingMessageToWallTest() throws ClientProtocolException, URISyntaxException, IOException {
		Assert.assertEquals(200, createMessageOnWall().getStatusLine().getStatusCode());
	}

	@Test
	public void updatingMessageOnWallTest() throws URISyntaxException, ClientProtocolException, IOException {
		String postId = getPostId(createMessageOnWall());
		Assert.assertEquals(200, editMessageOnWall(postId).getStatusLine().getStatusCode());
	}

	@Test
	public void removingMessageFromWallTest() throws ParseException, ClientProtocolException, IOException, URISyntaxException {
		String postId = getPostId(createMessageOnWall());
		Assert.assertEquals(200, deleteMessageFromWall(postId).getStatusLine().getStatusCode());
	}

	private HttpResponse createMessageOnWall() throws URISyntaxException, ClientProtocolException, IOException {
		String message = "LPV New Message";
		URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("message", message).setParameter("v", version);
		HttpPost request = new HttpPost(builder.build());
		return client.execute(request);
	}

	private HttpResponse editMessageOnWall(String postId) throws URISyntaxException, ClientProtocolException, IOException {
		String message = "LPV Edited Message";
		URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.edit?");
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("post_id", postId).setParameter("message", message).setParameter("v", version);
		HttpGet request = new HttpGet(builder.build());
		return client.execute(request);
	}

	private HttpResponse deleteMessageFromWall(String postId) throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.delete?");
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("post_id", postId).setParameter("v", version);
		HttpGet request = new HttpGet(builder.build());
		return client.execute(request);
	}

	private String getPostId(HttpResponse response) throws ParseException, IOException {
		return EntityUtils.toString(response.getEntity()).replaceAll("[^0-9]", "");
	}

}
