package mx.com.cinepolis.scheduler.service;



import mx.com.cinepolis.scheduler.commons.to.GithubUserTO;;

/**
 * @author uriel270195
 */
public interface GithubService {
	/**
     * Retorna la Informacion de GitHub
     * @param login acepta un login como string
     * @return Lista de la informacion de github
     */
	GithubUserTO getInfo(String login);
	GithubUserTO getLogin(String login, String pass);
	GithubUserTO setRegistrer(GithubUserTO registrer);
}
