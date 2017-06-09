package vo;

/**
 * MovieRank entity. @author MyEclipse Persistence Tools
 */

public class MovieRank implements java.io.Serializable {

	// Fields

	private Integer mid;
	private Integer totalscore;
	private Integer watchernum;
	private Integer averagescore;

	// Constructors

	/** default constructor */
	public MovieRank() {
	}

	/** full constructor */
	public MovieRank(Integer totalscore, Integer watchernum,
			Integer averagescore) {
		this.totalscore = totalscore;
		this.watchernum = watchernum;
		this.averagescore = averagescore;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getTotalscore() {
		return this.totalscore;
	}

	public void setTotalscore(Integer totalscore) {
		this.totalscore = totalscore;
	}

	public Integer getWatchernum() {
		return this.watchernum;
	}

	public void setWatchernum(Integer watchernum) {
		this.watchernum = watchernum;
	}

	public Integer getAveragescore() {
		return this.averagescore;
	}

	public void setAveragescore(Integer averagescore) {
		this.averagescore = averagescore;
	}

}