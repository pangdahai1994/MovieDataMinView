package vo;

/**
 * KMeansResult entity. @author MyEclipse Persistence Tools
 */

public class KMeansResult implements java.io.Serializable {

	// Fields

	private Integer k;
	private Double totalDistance;

	// Constructors

	/** default constructor */
	public KMeansResult() {
	}

	/** full constructor */
	public KMeansResult(Double totalDistance) {
		this.totalDistance = totalDistance;
	}

	// Property accessors

	public Integer getK() {
		return this.k;
	}

	public void setK(Integer k) {
		this.k = k;
	}

	public Double getTotalDistance() {
		return this.totalDistance;
	}

	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}

}