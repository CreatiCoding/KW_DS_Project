package co.kr.creaticoding.creaticode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;

@Configuration
public class SpringConfig {
	
	@Bean
	public GoogleConnectionFactory googleConnectionFactory() {
		String ClientID="123162417830-p1l0d5ckcphopnur3udq1jbslqj245eh.apps.googleusercontent.com";
		String password="Qs-xM-_rsyUT1TodCIovW9zP";
		return new GoogleConnectionFactory(ClientID, password);
	}
	
	@Bean
	public OAuth2Parameters oAuth2Parameters() {
		OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();
		oAuth2Parameters.setScope("https://www.googleapis.com/auth/plus.login");
		String reUri = "http://localhost/googleSignInCallback";
		oAuth2Parameters.setRedirectUri(reUri);
		return oAuth2Parameters;
	}
	
}