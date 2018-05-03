package mx.com.cinepolis.scheduler.facade;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.com.cinepolis.scheduler.commons.to.GithubUserTO;
import mx.com.cinepolis.scheduler.service.GithubService;

@Stateless
@LocalBean
public class GithubFacadeEJB {
	 @Inject
	 GithubService githubService;
	 public GithubUserTO getInfoGithub(String login) {
		return githubService.getInfo(login);
	 }
	 public GithubUserTO getLoginGithub(String login, String pass) {
			return githubService.getLogin(login, pass);
		 }
	 public GithubUserTO setRegistrerGithub(GithubUserTO login) {
			return githubService.setRegistrer(login);
		 }
}
