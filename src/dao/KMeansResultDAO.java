package dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import vo.KMeansResult;

/**
 * A data access object (DAO) providing persistence and search support for
 * KMeansResult entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see vo.KMeansResult
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class KMeansResultDAO {
	private static final Logger log = LoggerFactory
			.getLogger(KMeansResultDAO.class);
	// property constants
	public static final String TOTAL_DISTANCE = "totalDistance";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(KMeansResult transientInstance) {
		log.debug("saving KMeansResult instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(KMeansResult persistentInstance) {
		log.debug("deleting KMeansResult instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public KMeansResult findById(java.lang.Integer id) {
		log.debug("getting KMeansResult instance with id: " + id);
		try {
			KMeansResult instance = (KMeansResult) getCurrentSession().get(
					"vo.KMeansResult", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(KMeansResult instance) {
		log.debug("finding KMeansResult instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("vo.KMeansResult")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding KMeansResult instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from KMeansResult as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTotalDistance(Object totalDistance) {
		return findByProperty(TOTAL_DISTANCE, totalDistance);
	}

	public List findAll() {
		log.debug("finding all KMeansResult instances");
		try {
			String queryString = "from KMeansResult";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public KMeansResult merge(KMeansResult detachedInstance) {
		log.debug("merging KMeansResult instance");
		try {
			KMeansResult result = (KMeansResult) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(KMeansResult instance) {
		log.debug("attaching dirty KMeansResult instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(KMeansResult instance) {
		log.debug("attaching clean KMeansResult instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static KMeansResultDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (KMeansResultDAO) ctx.getBean("KMeansResultDAO");
	}
}