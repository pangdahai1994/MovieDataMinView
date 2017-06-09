package service;

import java.util.List;

public interface RankService {
	public List getTopTotalScoreMovies();
	public List getTopWatcherMovies();
	public List getTopAverageScoreMovies();
	
	public List getTopTotalScoreActors();
	public List getTopWatcherActors();
	public List getTopAverageScoreActors();
	
	public List getTopTotalScoreDirectors();
	public List getTopWatcherDirectors();
	public List getTopAverageScoreDirectors();
}
