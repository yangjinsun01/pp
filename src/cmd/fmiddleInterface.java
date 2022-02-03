package cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface fmiddleInterface{
	
void select(HttpServletRequest request, HttpServletResponse response);

void detail(HttpServletRequest request, HttpServletResponse response);

void update(HttpServletRequest request, HttpServletResponse response);

void updateResult(HttpServletRequest request, HttpServletResponse response);

void create(HttpServletRequest request, HttpServletResponse response);

}
