package action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import service.RankService;
import service.kmeansService;
import vo.ActorRank;
import vo.DirectorRank;
import vo.KMeansResult;
import vo.MovieRank;

import com.opensymphony.xwork2.ActionSupport;

public class RankAction extends ActionSupport{
	RankService rankservice;
	ArrayList<MovieRank> topredumovies,topscoremovies,topwatchermovies;
	ArrayList<ActorRank> topreduactors,topscoreactors,topwatcheractors;
	ArrayList<DirectorRank> topredudirectors,topscoredirectors,topwatcherdirectors;
    public String movieRank(){
    	topredumovies = (ArrayList)rankservice.getTopTotalScoreMovies();
    	topscoremovies = (ArrayList)rankservice.getTopAverageScoreMovies();
    	topwatchermovies = (ArrayList)rankservice.getTopWatcherMovies();
    	return "movierank";
    }
    
    public String actorRank(){
    	topreduactors = (ArrayList)rankservice.getTopTotalScoreActors();
    	topscoreactors = (ArrayList)rankservice.getTopAverageScoreActors();
    	topwatcheractors = (ArrayList)rankservice.getTopWatcherActors();
    	//System.out.println(topscoreactors.get(0).getAname());
    	return "actorrank";
    }
    
    public String directorRank(){
    	topredudirectors = (ArrayList)rankservice.getTopTotalScoreDirectors();
    	topscoredirectors = (ArrayList)rankservice.getTopAverageScoreDirectors();
    	topwatcherdirectors = (ArrayList)rankservice.getTopWatcherDirectors();
    	for (DirectorRank d:topscoredirectors){
    		BigDecimal b = new BigDecimal(d.getAveragescore()); 
    		d.setAveragescore(b.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue() );
    	}
    	return "directorrank";
    }
    

	public RankService getRankservice() {
		return rankservice;
	}

	public void setRankservice(RankService rankservice) {
		this.rankservice = rankservice;
	}

	public ArrayList<MovieRank> getTopredumovies() {
		return topredumovies;
	}

	public void setTopredumovies(ArrayList<MovieRank> topredumovies) {
		this.topredumovies = topredumovies;
	}

	public ArrayList<MovieRank> getTopscoremovies() {
		return topscoremovies;
	}

	public void setTopscoremovies(ArrayList<MovieRank> topscoremovies) {
		this.topscoremovies = topscoremovies;
	}

	public ArrayList<MovieRank> getTopwatchermovies() {
		return topwatchermovies;
	}

	public void setTopwatchermovies(ArrayList<MovieRank> topwatchermovies) {
		this.topwatchermovies = topwatchermovies;
	}

	public ArrayList<ActorRank> getTopreduactors() {
		return topreduactors;
	}

	public void setTopreduactors(ArrayList<ActorRank> topreduactors) {
		this.topreduactors = topreduactors;
	}

	public ArrayList<ActorRank> getTopscoreactors() {
		return topscoreactors;
	}

	public void setTopscoreactors(ArrayList<ActorRank> topscoreactors) {
		this.topscoreactors = topscoreactors;
	}

	public ArrayList<ActorRank> getTopwatcheractors() {
		return topwatcheractors;
	}

	public void setTopwatcheractors(ArrayList<ActorRank> topwatcheractors) {
		this.topwatcheractors = topwatcheractors;
	}

	public ArrayList<DirectorRank> getTopredudirectors() {
		return topredudirectors;
	}

	public void setTopredudirectors(ArrayList<DirectorRank> topredudirectors) {
		this.topredudirectors = topredudirectors;
	}

	public ArrayList<DirectorRank> getTopscoredirectors() {
		return topscoredirectors;
	}

	public void setTopscoredirectors(ArrayList<DirectorRank> topscoredirectors) {
		this.topscoredirectors = topscoredirectors;
	}

	public ArrayList<DirectorRank> getTopwatcherdirectors() {
		return topwatcherdirectors;
	}

	public void setTopwatcherdirectors(ArrayList<DirectorRank> topwatcherdirectors) {
		this.topwatcherdirectors = topwatcherdirectors;
	}

	public ArrayList<KMeansResult> getResultList() {
		return resultList;
	}
	public void setResultList(ArrayList<KMeansResult> resultList) {
		this.resultList = resultList;
	}
	ArrayList<KMeansResult> resultList=new ArrayList<KMeansResult>(20);
	public String update(){

		return SUCCESS;
	}

}
