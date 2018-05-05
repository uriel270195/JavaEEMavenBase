package mx.com.cinepolis.scheduler.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import mx.com.arquitectura.base.model.UserDO;
import mx.com.cinepolis.scheduler.commons.to.CatalogsTO;
import mx.com.cinepolis.scheduler.commons.to.UserTO;
import mx.com.cinepolis.scheduler.data.persistence.dao.UserDAO;
import mx.com.cinepolis.scheduler.service.CatalogService;

public class CatalogServiceImpl implements CatalogService{
	@Inject
	private UserDAO userDAO;
    /**
     * {@inheritDoc}
     */
    @Override
    public UserTO getUser() {
        UserTO userTO = new UserTO();
        userTO.setIdUser(1L);
        userTO.setName("Javier");
        userTO.setAvatarUrl("");
        userTO.setLogin("");
        return userTO;
    }

	@Override
	public List<CatalogsTO> getEstados(String pais) {
		// TODO Auto-generated method stub
		List<CatalogsTO> catalogsTOList = new ArrayList<>();
		if(pais.equals("Mexico")) {
			catalogsTOList.add(new CatalogsTO() {{
				setId(1);
				setName("Puebla");
			}});
			catalogsTOList.add(new CatalogsTO() {{
				setId(2);
				setName("Tlaxcala");
			}});
			catalogsTOList.add(new CatalogsTO() {{
				setId(3);
				setName("CDMX");
			}});
		}else if(pais.equals("USA")){
			catalogsTOList.add(new CatalogsTO() {{
				setId(1);
				setName("California");
			}});
			catalogsTOList.add(new CatalogsTO() {{
				setId(2);
				setName("New York");
			}});
			catalogsTOList.add(new CatalogsTO() {{
				setId(3);
				setName("Texas");
			}});
		}
		return catalogsTOList;
	}

	@Override
	public List<UserTO> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserDO> userDOList = userDAO.findAll();
		return userDOList.stream().map(x -> new UserTO() {{
				setLogin(x.getLogin());
				setFollowers(x.getFollowers());
				setFollowing(x.getFollowing());
				setAvatarUrl(x.getAvatarUrl());
				setName(x.getName());
				setIdUser(x.getIdUser());
		}}).collect(Collectors.toList());
	}

	@Override
	public UserTO setUser(UserTO userTO) {
		// TODO Auto-generated method stub
		UserDO userDO = new UserDO();
		userDO.setLogin(userTO.getLogin());
		userDO.setAvatarUrl(userTO.getAvatarUrl());
		userDO.setFollowers(userTO.getFollowers());
		userDO.setFollowing(userTO.getFollowing());
		userDO.setName(userTO.getName());
		userDAO.create(userDO);
		//userDAO.flush();
		//userDO.setIdUser(userTO.getIdUser());
		return userTO;
	}
}
