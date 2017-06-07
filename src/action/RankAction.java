package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import service.RankService;
import service.kmeansService;
import vo.KMeansResult;

import com.opensymphony.xwork2.ActionSupport;

public class RankAction extends ActionSupport{
	//@Resource(name="kmeansService")
	RankService rankservice;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	private String result;  
	ArrayList<KMeansResult> resultList=new ArrayList<KMeansResult>(20);
	public String update(){

		return SUCCESS;
	}

}
