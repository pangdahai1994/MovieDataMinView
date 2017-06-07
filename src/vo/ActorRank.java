package vo;

/**
 * ActorRank entity. @author MyEclipse Persistence Tools
 */

public class ActorRank implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String aname;
	private Double totalscore;
	private Integer fans;
	private Double averagescore;

	// Constructors

	/** default constructor */
	public ActorRank() {
	}

	/** full constructor */
	public ActorRank(String aname, Double totalscore, Integer fans,
			Double averagescore) {
		this.aname = aname;
		this.totalscore = totalscore;
		this.fans = fans;
		this.averagescore = averagescore;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Double getTotalscore() {
		return this.totalscore;
	}

	public void setTotalscore(Double totalscore) {
		this.totalscore = totalscore;
	}

	public Integer getFans() {
		return this.fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

	public Double getAveragescore() {
		return this.averagescore;
	}

	public void setAveragescore(Double averagescore) {
		this.averagescore = averagescore;
	}

}