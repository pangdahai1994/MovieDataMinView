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

import vo.ActorRank;

/**
 * A data access object (DAO) providing persistence and search support for
 * ActorRank entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see vo.ActorRank
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ActorRankDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ActorRankDAO.class);
	// property constants
	public static final String ANAME = "aname";
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

	public void save(ActorRank transientInstance) {
		log.debug("saving ActorRank instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ActorRank persistentInstance) {
		log.debug("deleting ActorRank instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ActorRank findById(java.lang.Integer id) {
		log.debug("getting ActorRank instance with id: " + id);
		try {
			ActorRank instance = (ActorRank) getCurrentSession().get(
					"vo.ActorRank", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ActorRank instance) {
		log.debug("finding ActorRank instance by example");
		try {
			List results = getCurrentSession().createCriteria("vo.ActorRank")
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
		log.debug("finding ActorRank instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ActorRank as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAname(Object aname) {
		return findByProperty(ANAME, aname);
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
		log.debug("finding all ActorRank instances");
		try {
			String queryString = "from ActorRank";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findTotalScoreTop20() {
		log.debug("finding all ActorRank instances");
		try {
			String queryString = "from ActorRank";
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
		log.debug("finding all ActorRank instances");
		try {
			String queryString = "from ActorRank order by fans desc";
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
		log.debug("finding all ActorRank instances");
		try {
			String queryString = "from ActorRank order by averagescore desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(20);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public ActorRank merge(ActorRank detachedInstance) {
		log.debug("merging ActorRank instance");
		try {
			ActorRank result = (ActorRank) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	

	public void attachDirty(ActorRank instance) {
		log.debug("attaching dirty ActorRank instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ActorRank instance) {
		log.debug("attaching clean ActorRank instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ActorRankDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ActorRankDAO) ctx.getBean("ActorRankDAO");
	}
}