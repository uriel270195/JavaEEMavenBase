package mx.com.cinepolis.scheduler.service.impl;


import mx.com.cinepolis.scheduler.commons.to.GithubUserTO;
import mx.com.cinepolis.scheduler.service.GithubService;

public class GithubServiceImpl implements GithubService{
	private 
	GithubUserTO githubUserTO= new GithubUserTO();
	@Override
	public GithubUserTO getInfo(String login){
		if(login.equals("uriel270195")) {
			githubUserTO.setLogin(login);
			githubUserTO.setName("Irvin Uriel Aguilar Cosme");
			githubUserTO.setAvatar_url("https://myonlineaccount.affinitywater.co.uk/Content/Images/glyphicon/login-icon@3x.png");
			githubUserTO.setFollowers(100);
			githubUserTO.setFollowing(100);
			githubUserTO.setPassword("123");
		}else if(login.equals("IngJavierR")) {
			githubUserTO.setLogin(login);
			githubUserTO.setName("Javier Rodríguez");
			githubUserTO.setAvatar_url("https://myonlineaccount.affinitywater.co.uk/Content/Images/glyphicon/login-icon@3x.png");
			githubUserTO.setFollowers(150);
			githubUserTO.setFollowing(150);
			githubUserTO.setPassword("123");
		}else {
			githubUserTO.setLogin("Error");
			githubUserTO.setName("");
			githubUserTO.setAvatar_url("");
			githubUserTO.setFollowers(0);
			githubUserTO.setFollowing(0);
			githubUserTO.setPassword("");
		}
		return githubUserTO;
	}
	
	@Override
	public GithubUserTO getLogin(String login, String pass) {
		// TODO Auto-generated method stub
		GithubUserTO validate= this.getInfo(login);
		if(validate.getLogin().equals(login) && validate.getPassword().equals(pass)) {
			return validate;
		}
		return githubUserTO;
	}

	@Override
	public GithubUserTO setRegistrer(GithubUserTO registrer) {
		// TODO Auto-generated method stub
		return registrer;
	}

}
