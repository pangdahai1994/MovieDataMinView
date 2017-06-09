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

import vo.MovieRank;

/**
 * A data access object (DAO) providing persistence and search support for
 * MovieRank entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see vo.MovieRank
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MovieRankDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieRankDAO.class);
	// property constants
	public static final String TOTALSCORE = "totalscore";
	public static final String WATCHERNUM = "watchernum";
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

	public void save(MovieRank transientInstance) {
		log.debug("saving MovieRank instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieRank persistentInstance) {
		log.debug("deleting MovieRank instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieRank findById(java.lang.Integer id) {
		log.debug("getting MovieRank instance with id: " + id);
		try {
			MovieRank instance = (MovieRank) getCurrentSession().get(
					"vo.MovieRank", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieRank instance) {
		log.debug("finding MovieRank instance by example");
		try {
			List results = getCurrentSession().createCriteria("vo.MovieRank")
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
		log.debug("finding MovieRank instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MovieRank as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTotalscore(Object totalscore) {
		return findByProperty(TOTALSCORE, totalscore);
	}

	public List findByWatchernum(Object watchernum) {
		return findByProperty(WATCHERNUM, watchernum);
	}

	public List findByAveragescore(Object averagescore) {
		return findByProperty(AVERAGESCORE, averagescore);
	}

	public List findAll() {
		log.debug("finding all MovieRank instances");
		try {
			String queryString = "from MovieRank";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findTotalScoreTop20() {
		log.debug("finding all MovieRank instances");
		try {
			String queryString = "from MovieRank order by totalscore desc";
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
		log.debug("finding all MovieRank instances");
		try {
			String queryString = "from MovieRank order by watchernum desc";
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
		log.debug("finding all MovieRank instances");
		try {
			String queryString = "from MovieRank order by averagescore desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(20);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public MovieRank merge(MovieRank detachedInstance) {
		log.debug("merging MovieRank instance");
		try {
			MovieRank result = (MovieRank) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieRank instance) {
		log.debug("attaching dirty MovieRank instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieRank instance) {
		log.debug("attaching clean MovieRank instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MovieRankDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MovieRankDAO) ctx.getBean("MovieRankDAO");
	}
}