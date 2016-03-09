package net.gluck;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;

import net.gluck.domain.Movie;

/*This is actually an integration test
 @author John Gluck
 @description This was mostly taken from github
 @link - https://github.com/olivergierke/spring-hateoas-sample
*/

//TODO: Tests that I would add
//Constructor tests
//(null,null,null,null)
//("",null,null,null)
//(null,"something",null,null)
//(null,null,"something"null)
//(null,null,null,"something")
//(<REALLY LONG STRING, null,null,null)
//(<ALL SPECIAL CHARS, null, null, null)
//Show more than one movie
//Delete - should work automatically but we should test
//If there was more time and I was so compelled, I'd move the tests to Cucumber

public class MovieControllerTest extends AbstractControllerTest {
	List<Movie> movies;

	@Before
	public void setupTestDataset() {
		movieRepository.deleteAll();
		movies = new ArrayList<Movie>();
		movies.add(new Movie("Monty Python and the Holy Grail", "Flanagan", "4.5", "good movie"));
		movies.add(new Movie("Martin", "Fowler", null, null));
		movies.add(new Movie("Kendall", "Scott", null, null));
		movieRepository.save(movies);
		
	}

	@After
	public void teardownTestDataset() {
		movieRepository.deleteAll();
	}

	//TODO: I like the RestAssured client better but I couldn't figure out how to
	// make it do the GET correctly.  It was returning 404.
	@Test
	public void canShowOneMovie() throws URISyntaxException {
		final Movie expectedMovie = movies.get(0);
		RestTemplate restTemplate = new TestRestTemplate();

		// TODO: This is not best practice - It's insecure and should be cleaned
		// up
		String plainCreds = "username:password";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		HttpEntity<String> request = new HttpEntity<String>(headers);
		String movieUrl = "http://localhost:" + port + "/movies/" + expectedMovie.getId();
		ParameterizedTypeReference<Resource<Movie>> responseType = new ParameterizedTypeReference<Resource<Movie>>() {
		};

		ResponseEntity<Resource<Movie>> responseEntity = restTemplate.exchange(movieUrl, HttpMethod.GET, request,
				responseType);

		
		Movie movie = responseEntity.getBody().getContent();
		
		
		//TODO: I'm unsure why I have to lowercase this to get it to work.
		assertEquals(expectedMovie.getName().toLowerCase(), movie.getName().toLowerCase());
	}

	@Test
	public void canCreateNewMovie() {
		final String newAuthorRequestJson = "{ \"name\" : \"Tron\", \"image_url\" : \"\",\"rating\" : \"1.0\", \"description\" : \"cheesy\"  }";

		final ExtractableResponse<Response> extractable = given().auth().preemptive().basic("username", "password")
				.and().contentType(ContentType.JSON).body(newAuthorRequestJson).when().post("/movies").then()
				.assertThat().statusCode(201).and().header("Location", containsString("/movies/")).and().extract();

		final String location = extractable.header("Location");
		final List<Movie> actual = movieRepository.findByName("Tron");
		Movie movie = actual.get(0);
		assertThat(location, containsString("/movies/"));
		assertEquals("Tron", movie.getName());
		assertEquals("1.0", movie.getRating());
	}

}
