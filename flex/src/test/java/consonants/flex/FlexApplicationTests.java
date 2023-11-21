package consonants.flex;

import consonants.flex.interface_adapter.login.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlexApplicationTests {

	@Autowired
	private LoginController controller;

	@Test
	void contextLoads() throws Exception {
		System.out.println("hi!");
		System.out.println(assertThat(controller).isNotNull());
	}

}
