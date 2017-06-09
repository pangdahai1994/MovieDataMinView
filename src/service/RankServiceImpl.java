package service;

import java.util.List;

import dao.ActorRankDAO;
import dao.DirectorRankDAO;
import dao.MovieRankDAO;

public class RankServiceImpl implements RankService {
    MovieRankDAO movieRank;
    ActorRankDAO actorRank;
    DirectorRankDAO directorRank;
	public DirectorRankDAO getDirectorRank() {
		return directorRank;
	}

	public void setDirectorRank(DirectorRankDAO directorRank) {
		this.directorRank = directorRank;
	}

	public MovieRankDAO getMovieRank() {
		return movieRank;
	}

	public void setMovieRank(MovieRankDAO movieRank) {
		this.movieRank = movieRank;
	}

	public ActorRankDAO getActorRank() {
		return actorRank;
	}

	public void setActorRank(ActorRankDAO actorRank) {
		this.actorRank = actorRank;
	}

	public List getTopTotalScoreMovies() {
		// TODO Auto-generated method stub
		return movieRank.findTotalScoreTop20();
	}
	
	public List getTopWatcherMovies() {
		// TODO Auto-generated method stub
		return movieRank.findWatcherNumTop20();
	}
	
	public List getTopAverageScoreMovies() {
		// TODO Auto-generated method stub
		return movieRank.findAverageScoreTop20();
	}

	public List getTopTotalScoreDirectors() {
		// TODO Auto-generated method stub
		return directorRank.findTotalScoreTop20();
	}

	public List getTopWatcherDirectors() {
		// TODO Auto-generated method stub
		return directorRank.findWatcherNumTop20();
	}

	public List getTopAverageScoreDirectors() {
		// TODO Auto-generated method stub
		return directorRank.findAverageScoreTop20();
	}

	public List getTopTotalScoreActors() {
		// TODO Auto-generated method stub
		return actorRank.findTotalScoreTop20();
	}

	public List getTopWatcherActors() {
		// TODO Auto-generated method stub
		return actorRank.findWatcherNumTop20();
	}

	public List getTopAverageScoreActors() {
		// TODO Auto-generated method stub
		return actorRank.findAverageScoreTop20();
	}
}
