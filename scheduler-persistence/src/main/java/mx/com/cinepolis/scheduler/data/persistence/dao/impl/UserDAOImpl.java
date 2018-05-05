package mx.com.cinepolis.scheduler.data.persistence.dao.impl;

import mx.com.arquitectura.arquitectura.persistence.impl.BaseDAOImpl;
import mx.com.arquitectura.base.model.UserDO;
import mx.com.cinepolis.scheduler.data.persistence.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author jorge.lopez
 */
public class UserDAOImpl extends BaseDAOImpl<UserDO, Long> implements UserDAO {

    private static final String QUERY_USER_DO_FIND_ACTIVE_BY_DS_USERNAME = "UserDO.findActiveByDsUsername";
    private static final String QUERY_COUNT_USERS = "UserDO.countUsers";
    private static final String QUERY_FIND_USERS = "UserDO.findUsers";

    private static final String PARAM_USER_NAME = "userName";
    private static final String PARAM_FILTER = "filter";

    private static final String PERCENTAGE = "%";

    /*
     * (non-Javadoc)
     *
     * @see mx.gob.arquitectura.arquitectura.persistence.impl.BaseDAOImpl#
     * setEntityManager(javax.persistence.EntityManager)
     */
    @Override
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
   
}
