package com.xiaoyb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyb.domain.User;
import com.xiaoyb.realm.ShiroDbRealm;
import com.xiaoyb.service.UserService;
import com.xiaoyb.utils.CipherUtil;

@Controller
public class UserControler {
	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	@Autowired
	private UserService userService;

	/**
	 * 初始登陆界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String tologin(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.debug("来自IP[" + request.getRemoteHost() + "]的访问");
		return "login";
	}

	/**
	 * 验证用户名和密码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/checkLogin")
	public String login(HttpServletRequest request) {
		String result = "login.do";
		// 取得用户名
		String username = request.getParameter("username");
		// 取得 密码，并用MD5加密
		String password = CipherUtil.generatePassword(request.getParameter("password"));
		// String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		Subject currentUser = SecurityUtils.getSubject();
		try {
			System.out.println("----------------------------");
			if (!currentUser.isAuthenticated()) {// 使用shiro来验证
				token.setRememberMe(true);
				currentUser.login(token);// 验证角色和权限
			}
			System.out.println("result: " + result);
			result = "loginsuccess";// 验证成功
		} catch (Exception e) {
			logger.error(e.getMessage());
			result = "login";// 验证失败
		}
		return result;
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public String logout() {

		Subject currentUser = SecurityUtils.getSubject();
		String result = "logout";
		currentUser.logout();
		return result;
	}
}