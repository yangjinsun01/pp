package cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pplanDao;
import dto.pplanDto;
import paging.paging;

public class pplanCmd implements pplanInterface {
	// P_PLAN SELECT
	@Override
	public void select(HttpServletRequest request, HttpServletResponse response) {

		String oid = request.getParameter("oid").substring(0, 9);
		System.out.println("oid : " +oid);
		pplanDao dao = new pplanDao();


		int displayPage = 10; // 페이지네이션 (한 페이지에 몇개의 Page?)
		int displayRow = 5; // 페이지네이션 (한 페이지에 몇개의 Row?)
		int count = dao.getCount_P(oid); // 전체 페이지 가져오기
		System.out.println(count);
		int page = 1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
			System.out.println(page);
			System.out.println(oid);
		}

		paging paging = new paging();
		paging.setPage(page);
		paging.setTotalCount(count);
		paging.setOid(oid);
        paging.setDisplayPage(displayPage);
        paging.setDisplayRow(displayRow);

		ArrayList<pplanDto> SelectPPLANList = dao.selectPPLAN(page, oid, displayRow);
		request.setAttribute("plist", SelectPPLANList);
		request.setAttribute("paging", paging);

	}
	// P_PLAN DETAIL
	@Override
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	// P_PLAN CREATE(POP)
	@Override
	public void create(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	// P_PLAN CREATE(SUBMIT)
	@Override
	public void createResult(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	// P_PLAN UPDATE(POP)
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	// P_PLAN UPDATE(SUBMIT)
	@Override
	public void updateResult(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}


}
