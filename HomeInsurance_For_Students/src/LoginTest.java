import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cts.insurance.homequote.bo.LoginBO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.model.User;

public class LoginTest {

	@Test
	public void getUserTest() {

		LoginBO login = new LoginBO();
		try {
			User user = login.getUser("shotundefm");
			assertEquals("shotundefm oluwafemi", user);

		} catch (HomequoteBusinessException e) {
			e.printStackTrace();
		}
	}

}
