package cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.fmiddleDao;
import dto.fmiddleDto;
import paging.paging;

public class fmiddleCmd implements fmiddleInterface{
// 파라메타를 받는 곳
	// select, search
	@Override
	public void select(HttpServletRequest request, HttpServletResponse response) {
		String search = "";
		
        if(request.getParameter("search") != null) {
        	search = request.getParameter("search");
        	search = search.trim();
        	System.out.println("찾기 단어 : " + search);
        }		
		
		fmiddleDao dao = new fmiddleDao();
		// 		**	fmiddle_s PAGENATION	**		//
		int count = dao.getCount_F(search); // 조회한 테이블 전체 개수를 구함.
		int page = 1;
		int displayPage = 5;
		int displayRow = 20;
		
	        if(request.getParameter("page")!=null){
	            page = Integer.parseInt(request.getParameter("page"));
	        }

	        paging paging = new paging();
	        paging.setPage(page);
	        paging.setTotalCount(count);
	        paging.setDisplayPage(displayPage);
	        paging.setDisplayRow(displayRow);
	        
	        ArrayList<fmiddleDto> dtoList = dao.selectFmiddle(page, search);
	        request.setAttribute("flist", dtoList);
	        request.setAttribute("paging", paging);
		
	}

	// detail
	@Override
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		fmiddleDao dao = new fmiddleDao();
		String oid = "28";
	        if(request.getParameter("oid")!=null){
	            oid = request.getParameter("oid");
	            System.out.println("fmiddleCmd oid : "+oid);
	        }
	        
	        ArrayList<fmiddleDto> dtoList = dao.detailFmiddle(oid);
	        request.setAttribute("dlist", dtoList);
		
	}

	// detail -> update select
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {

		fmiddleDao dao = new fmiddleDao();
		String oid = "28";
	        if(request.getParameter("oid")!=null){
	            oid = request.getParameter("oid");
	            System.out.println("fmiddleCmd oid : "+oid);
	        }
	        
	        ArrayList<fmiddleDto> dtoList = dao.detailFmiddle(oid);
	        request.setAttribute("ulist", dtoList);		
	}
	
	// update
	@Override
	public void updateResult(HttpServletRequest request, HttpServletResponse response) {
		
		fmiddleDao dao = new fmiddleDao();
		fmiddleDto data = new fmiddleDto();
		
		data.setOid(request.getParameter("oid"));
		data.setB_oid(request.getParameter("b_oid"));
		data.setC_type(request.getParameter("c_type"));
		data.setP_name(request.getParameter("p_name"));
		data.setP_no(request.getParameter("p_no"));
		data.setGubun(request.getParameter("gubun"));
		data.setDescription(request.getParameter("description"));
	    
	    dao.updateFmiddle(data);
	    System.out.println("udate 넘어감");		
	}

	// insert
	@Override
	public void create(HttpServletRequest request, HttpServletResponse response) {
		
		fmiddleDao dao = new fmiddleDao();
		fmiddleDto data = new fmiddleDto();
		
		data.setOid(request.getParameter("oid"));
		data.setB_oid(request.getParameter("b_oid"));
		data.setC_type(request.getParameter("c_type"));
		data.setP_name(request.getParameter("p_name"));
		data.setP_no(request.getParameter("p_no"));
		data.setGubun(request.getParameter("gubun"));
		data.setDescription(request.getParameter("description"));
	    
	    dao.insertFmiddle(data);
	    System.out.println("insert 넘어감");		
	}
}