package cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.binfoDao;
import dto.binfoDto;
import paging.paging;

public class binfoCmd implements binfoInterface{


	// W_BINFO SELECT
@Override
public void select(HttpServletRequest request, HttpServletResponse response) {

	binfoDao dao = new binfoDao();
	int displayPage = 5;
	int displayRow = 10;
	// 		**	binfo_C PAGENATION	**		//
	int count = dao.getCount_B(); // 조회한 테이블 전체 개수를 구함.
	int page = 1;

        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
            System.out.println(page);
        }
        paging paging = new paging();
        paging.setPage(page);
        paging.setTotalCount(count);
        paging.setDisplayPage(displayPage);
        paging.setDisplayRow(displayRow);
        ArrayList<binfoDto> dtoList = dao.selectWbinfo(page);
        request.setAttribute("blist", dtoList);
        request.setAttribute("paging", paging);

}
	// W_BINFO DETAIL
@Override
public void detail(HttpServletRequest request, HttpServletResponse response) {

binfoDao dao = new binfoDao();

String oidValue = request.getParameter("oid");
System.out.println(oidValue);


 ArrayList<binfoDto> detailList = dao.detailWbinfo(oidValue);
 request.setAttribute("dlist", detailList);

}
	// W_BINFO CREATE(POP)
@Override
public void create(HttpServletRequest request, HttpServletResponse response) {

	binfoDao dao = new binfoDao();
    ArrayList<binfoDto> lastList = dao.binfoLastList();
    request.setAttribute("lblist", lastList);
}
	// W_BINFO UPDATE(POP)
@Override
public void update(HttpServletRequest request, HttpServletResponse response) {

	binfoDao dao = new binfoDao();
	String oidValue = request.getParameter("oid");
	System.out.println(oidValue);

	 ArrayList<binfoDto> updateList = dao.detailWbinfo(oidValue);
     request.setAttribute("ulist", updateList);

}
	// W_BINFO UPDATE(SUBMIT)
@Override
public void updateResult(HttpServletRequest request, HttpServletResponse response) {
	binfoDao dao = new binfoDao();
	binfoDto udto = new binfoDto();


	udto.setOid(request.getParameter("oid"));
	udto.setBcode(request.getParameter("bcode"));
	udto.setBname(request.getParameter("bname"));
	udto.setW_day(request.getParameter("w_day"));
	udto.setW_time(request.getParameter("w_time"));
	udto.setT_cnt(request.getParameter("t_cnt"));
	udto.setS_day(request.getParameter("s_day"));
	udto.setL_stand(request.getParameter("l_stand"));
	udto.setDescription(request.getParameter("description"));

	dao.updateWbinfo(udto);




}
	// W_BINFO CREATE(SUBMIT)
@Override
public void createResult(HttpServletRequest request, HttpServletResponse response) {


binfoDao dao = new binfoDao();
binfoDto idto = new binfoDto();
idto.setOid(request.getParameter("oid"));
idto.setBcode(request.getParameter("bcode"));
idto.setBname(request.getParameter("bname"));
idto.setW_day(request.getParameter("w_day"));
idto.setW_time(request.getParameter("w_time"));
idto.setT_cnt(request.getParameter("t_cnt"));
idto.setS_day(request.getParameter("s_day"));
idto.setL_stand(request.getParameter("l_stand"));
idto.setDescription(request.getParameter("description"));
System.out.println("////////출력시작");
System.out.println("OID :" + idto.getOid());
System.out.println("BCODE :" +idto.getBcode());
System.out.println("BNAME :" +idto.getBname());
System.out.println("W_DAY :" +idto.getW_day());
System.out.println("W_time :" +idto.getW_time());
System.out.println("T_cnt :" +idto.getT_cnt());
System.out.println("S_day :" +idto.getS_day());
System.out.println("Lstand :" +idto.getL_stand());
System.out.println("Desc :" +idto.getDescription());
System.out.println("////////출력끝");
dao.insertWbinfo(idto);



}
	// W_BINFO SEARCH
@Override
public void search(HttpServletRequest request, HttpServletResponse response) {

	String oidValue = request.getParameter("oidValue");
	oidValue = oidValue.replaceAll("\\p{Z}","");

	binfoDao dao = new binfoDao();
	System.out.println(oidValue);

        ArrayList<binfoDto> searchList = dao.searchWbinfo(oidValue);
        request.setAttribute("blist", searchList);
}

}
