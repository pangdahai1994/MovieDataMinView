package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.KMeansResultDAO;
import vo.KMeansResult;
@Service("kmeansService")
public class kmeansServiceImpl implements kmeansService{
	KMeansResultDAO kresultdao;
	public KMeansResultDAO getKresultdao() {
		return kresultdao;
	}
	public void setKresultdao(KMeansResultDAO kresultdao) {
		this.kresultdao = kresultdao;
	}
	public List getResult(){
		return kresultdao.findAll();
	}
}
