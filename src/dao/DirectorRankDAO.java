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

import vo.DirectorRank;

/**
 * A data access object (DAO) providing persistence and search support for
 * DirectorRank entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see vo.DirectorRank
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DirectorRankDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DirectorRankDAO.class);
	// property constants
	public static final String DNAME = "dname";
	public static final String TOTALSCORE = "totalscore";
	public static final String FANS = "fans";
	public static final String AVERAGESCORE = "averagescore";

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

	public void save(DirectorRank transientInstance) {
		log.debug("saving DirectorRank instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DirectorRank persistentInstance) {
		log.debug("deleting DirectorRank instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DirectorRank findById(java.lang.Integer id) {
		log.debug("getting DirectorRank instance with id: " + id);
		try {
			DirectorRank instance = (DirectorRank) getCurrentSession().get(
					"vo.DirectorRank", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DirectorRank instance) {
		log.debug("finding DirectorRank instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("vo.DirectorRank")
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
		log.debug("finding DirectorRank instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DirectorRank as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDname(Object dname) {
		return findByProperty(DNAME, dname);
	}

	public List findByTotalscore(Object totalscore) {
		return findByProperty(TOTALSCORE, totalscore);
	}

	public List findByFans(Object fans) {
		return findByProperty(FANS, fans);
	}

	public List findByAveragescore(Object averagescore) {
		return findByProperty(AVERAGESCORE, averagescore);
	}

	public List findAll() {
		log.debug("finding all DirectorRank instances");
		try {
			String queryString = "from DirectorRank";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findTotalScoreTop20() {
		log.debug("finding all DirectorRank instances");
		try {
			String queryString = "from DirectorRank order by totalscore desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(20);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findWatcherNumTop20() {
		log.debug("finding all DirectorRank instances");
		try {
			String queryString = "from DirectorRank order by fans desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(20);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAverageScoreTop20() {
		log.debug("finding all DirectorRank instances");
		try {
			String queryString = "from DirectorRank order by averagescore desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(20);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public DirectorRank merge(DirectorRank detachedInstance) {
		log.debug("merging DirectorRank instance");
		try {
			DirectorRank result = (DirectorRank) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DirectorRank instance) {
		log.debug("attaching dirty DirectorRank instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DirectorRank instance) {
		log.debug("attaching clean DirectorRank instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DirectorRankDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (DirectorRankDAO) ctx.getBean("DirectorRankDAO");
	}
}