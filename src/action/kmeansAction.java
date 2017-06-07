package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import service.kmeansService;
import vo.KMeansResult;

import com.opensymphony.xwork2.ActionSupport;

public class kmeansAction extends ActionSupport{
	//@Resource(name="kmeansService")
	kmeansService kmeansservice;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	private String result;  
	ArrayList<KMeansResult> resultList=new ArrayList<KMeansResult>(20);
	public String update(){
		ArrayList distanceList=new ArrayList(20);
		ArrayList kList=new ArrayList(20);
		resultList = (ArrayList)kmeansservice.getResult();
		Map<String,List> room = new HashMap<String,List>();
		for (KMeansResult  o:resultList){
			distanceList.add(o.getTotalDistance());
			kList.add(o.getK());
		}
		room.put("kList", kList);
		room.put("distanceList", distanceList);
		try {
			this.result=JSONUtil.serialize(room).toString();
			System.out.println(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public kmeansService getKmeansservice() {
		return kmeansservice;
	}
	public void setKmeansservice(kmeansService kmeansservice) {
		this.kmeansservice = kmeansservice;
	}
}
