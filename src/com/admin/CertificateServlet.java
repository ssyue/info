package com.admin;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.CertificationGenerator;

@WebServlet(name = "CertificateServlet", urlPatterns = "/certificate")
public class CertificateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("===service======CertificateServlet====");
		String code = CertificationGenerator.getCode();
		HttpSession session = request.getSession();
		session.setAttribute("code", code );
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("image/jpeg");
		ServletOutputStream s = response.getOutputStream();
		ImageIO.write(CertificationGenerator.getGraphics(code), "jpeg", s);
		s.close();
	}
}
