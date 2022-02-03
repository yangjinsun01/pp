package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmd.binfoCmd;
import cmd.fmiddleCmd;
import cmd.fmiddleInterface;
import cmd.pplanCmd;

@WebServlet("*.do")
public class commonCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public commonCtrl() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo");

		request.setCharacterEncoding("UTF-8");

				String viewPage = null;
				binfoCmd bcmd = null;
				pplanCmd pcmd = null;   
				fmiddleInterface fmiddleCmd = null;
				fmiddleCmd = new fmiddleCmd();

				String uri = request.getRequestURI();
				System.out.println(uri);
				String conPath = request.getContextPath();
				System.out.println(conPath);
				String com = uri.substring(conPath.length());
				System.out.println(com);
				if(com.equals("/ma/main_binfo.do")) {
					bcmd = new binfoCmd();
					bcmd.select(request, response);
					viewPage = "/ma/binfo_s.jsp";
					System.out.println(com);
				}else if (com.equals("/ma/main_pplan.do")) {
					pcmd = new pplanCmd();
					pcmd.select(request, response);
					viewPage = "/ma/pplan.jsp";
				}else if (com.equals("/ma/search_binfo.do")) {
					bcmd = new binfoCmd();
					bcmd.search(request, response);
					viewPage = "/ma/binfo_s.jsp";
					System.out.println(com);
				}else if(com.equals("/ma/binfo_createResult.do")) {
					bcmd = new binfoCmd();
					bcmd.createResult(request, response);
					viewPage="/ma/detail_binfo.do";
					System.out.println(com);
				}else if (com.equals("/ma/binfo_update.do")) {
					bcmd = new binfoCmd();
					bcmd.update(request, response);
					viewPage="/ma/binfo_u.jsp";
					System.out.println(com);
				}else if(com.equals("/ma/binfo_create.do")) {
					bcmd = new binfoCmd();;
					bcmd.create(request, response);
					viewPage="/ma/binfo_c.jsp";
					System.out.println(com);
				}else if (com.equals("/ma/detail_binfo.do")) {
					bcmd = new binfoCmd();
					bcmd.detail(request, response);
					viewPage="/ma/binfo_d.jsp";
					System.out.println(com);
				}else if (com.equals("/ma/binfo_updateResult.do")){
					bcmd = new binfoCmd();
					bcmd.updateResult(request, response);
					System.out.println("������Ʈ ����");
					viewPage="/ma/detail_binfo.do";
				}else if(com.equals("/ma/main_fmiddle.do")) {
					fmiddleCmd = new fmiddleCmd();
					fmiddleCmd.select(request, response);
						viewPage = "/ma/fmiddle_s.jsp";
						
					}else if(com.equals("/ma/detail_fmiddle.do")) {
						fmiddleCmd = new fmiddleCmd();
						fmiddleCmd.detail(request, response);
						viewPage = "/ma/fmiddle_d.jsp";
						
					}else if(com.equals("/ma/update_fmiddle.do")) {
						fmiddleCmd = new fmiddleCmd();
						fmiddleCmd.update(request, response);
						viewPage = "/ma/fmiddle_u.jsp";
						
					}else if(com.equals("/ma/updateResult_fmiddle.do")){
						fmiddleCmd = new fmiddleCmd();
						System.out.println("업데이트 들어온것 확인");
						fmiddleCmd.updateResult(request, response);
						viewPage = "/ma/detail_fmiddle.do";
						
					}else if(com.equals("/ma/create_fmiddle.do")) {
						fmiddleCmd = new fmiddleCmd();
						fmiddleCmd.create(request, response);
						viewPage = "/ma/detail_fmiddle.do";
					}
					
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
				}
	}
