package vo;

/**
 * DirectorRank entity. @author MyEclipse Persistence Tools
 */

public class DirectorRank implements java.io.Serializable {

	// Fields

	private Integer did;
	private String dname;
	private Double totalscore;
	private Integer fans;
	private Double averagescore;

	// Constructors

	/** default constructor */
	public DirectorRank() {
	}

	/** full constructor */
	public DirectorRank(String dname, Double totalscore, Integer fans,
			Double averagescore) {
		this.dname = dname;
		this.totalscore = totalscore;
		this.fans = fans;
		this.averagescore = averagescore;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
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