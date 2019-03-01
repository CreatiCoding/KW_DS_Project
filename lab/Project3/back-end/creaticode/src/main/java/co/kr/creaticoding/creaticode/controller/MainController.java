package co.kr.creaticoding.creaticode.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.creaticoding.creaticode.vo.UserVO;

import org.springframework.social.oauth2.OAuth2Parameters;

@Controller
public class MainController {

	@Autowired
	GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	OAuth2Parameters oAuth2Parameters;

	
	@RequestMapping(value = "/googleLogin", method = RequestMethod.GET)
	public String doGoogleSignInActionPage(HttpServletResponse response, Model model) throws Exception{
	  OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	  String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
	  System.out.println("/member/googleSignIn, url : " + url);
	  model.addAttribute("url",url);
	  return "googleLogin";
	}

	@RequestMapping(value = "/googleSignInCallback", method = RequestMethod.GET)
	public String doSessionAssignActionPage(HttpServletRequest request, RedirectAttributes redirectAttributes)throws Exception{
	  String code = request.getParameter("code");

	  OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	  AccessGrant accessGrant = oauthOperations.exchangeForAccess(code , oAuth2Parameters.getRedirectUri(),
	      null);

	  String accessToken = accessGrant.getAccessToken();
	  Long expireTime = accessGrant.getExpireTime();
	  if (expireTime != null && expireTime < System.currentTimeMillis()) {
	    accessToken = accessGrant.getRefreshToken();
	    System.out.printf("accessToken is expired. refresh token = {}", accessToken);
	  }
	  
	  Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
	  Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();

	  PlusOperations plusOperations = google.plusOperations();
	  Person profile = plusOperations.getGoogleProfile();
	  
	  UserVO vo = new UserVO();

	  vo.setOauth_name("google");
	  vo.setProfile(profile.getDisplayName());
	  vo.setUser_id(profile.getId());
	  vo.setOauth_uid(accessToken);

	  System.out.println(profile.getDisplayName());
	  System.out.println(profile.getId());
	  System.out.println(accessToken);
	  
	  redirectAttributes.addAttribute("name", profile.getDisplayName());
	  redirectAttributes.addAttribute("id", profile.getId());
	  redirectAttributes.addAttribute("token", accessToken);
	  return "redirect:/";
	}
}
