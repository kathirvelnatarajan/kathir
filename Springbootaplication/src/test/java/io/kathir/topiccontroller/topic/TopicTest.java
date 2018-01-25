package io.kathir.topiccontroller.topic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.kathir.topiccontroller.topic.MovingAverage;
import io.kathir.topiccontroller.topic.Topic;
@RunWith(SpringJUnit4ClassRunner.class)
/*@SpringBootTest(classes={Topic.class})*/
@ContextConfiguration(classes= {DatabaseManager.class, JdbcTemplate.class})
@ActiveProfiles("test")
@WebMvcTest(Topic.class)
public class TopicTest {
	@Autowired
	Topic topic;
	@Mock
	DatabaseManager dm;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int noOfDays = 10;
		String ticker = "AAPL";
		List<MovingAverage> avgList = topic.calculate(noOfDays, ticker);
		assertEquals(10, avgList.size());
	}

}
