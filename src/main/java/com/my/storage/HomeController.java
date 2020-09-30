package com.my.storage;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.storage.dao.UserDao;
import com.my.storage.dto.UserDto;
import com.my.storage.vo.userVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println( org.springframework.core.SpringVersion.getVersion() ); 

		
		logger.info("Welcome home!!!!!!! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate + " test");
		
		return "home";
	}
	
	@RequestMapping(value="/select", method = RequestMethod.GET)
	public String select(Model model) {
		List<UserDto> list = userDao.sel();
		for(int i=0; i<list.size(); i++){
			model.addAttribute("USER_SEQ", list.get(0).getUser_ID());
			model.addAttribute("USER_NAME", list.get(0).getUser_Name());
		}

		return "select";
	}
	
	@RequestMapping(value = "/getParaString", method = RequestMethod.GET)
	public String getParaString(Model model) {
		String in_user_seq = "0xu9n9w9ox176k418dlgq12f2h42tqs461t6";
		List<UserDto> list = userDao.getParamterString(in_user_seq);
		
		for(int i=0; i<list.size(); i++){
			model.addAttribute("USER_ID", list.get(0).getUser_ID());
			model.addAttribute("USER_NAME", list.get(0).getUser_Name());
		}
		
		return "select";
	}
	
	@RequestMapping(value = "/getParamterMap", method = RequestMethod.GET)
	public String getParamterMap(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("in_user_seq", "0xu9n9w9ox176k418dlgq12f2h42tqs461t6");
		
		List<UserDto> userDto = userDao.getParamterMap(map);
		
		for(int i=0; i<userDto.size(); i++){
			model.addAttribute("USER_ID", userDto.get(0).getUser_ID());
			model.addAttribute("USER_NAME", userDto.get(0).getUser_Name());
		}
		
		return "select";
	}
	
	@RequestMapping(value = "/getParamterVO", method = RequestMethod.GET)
	public String getParamterVO(Model model) {
		userVO paramVO = com.my.storage.vo.userVO.builder()
		.in_user_seq("0xu9n9w9ox176k418dlgq12f2h42tqs461t6")
		.build();
	
		List<UserDto> userDto = userDao.getParamterVO(paramVO);
		
		for(int i=0; i<userDto.size(); i++){
			model.addAttribute("USER_ID", userDto.get(0).getUser_ID());
			model.addAttribute("USER_NAME", userDto.get(0).getUser_Name());
		}
		
		return "select";
	}
	
	@RequestMapping(value = "/CallProcedure", method = RequestMethod.GET)
	public String CallProcedure(Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("in_user_seq", "0xu9n9w9ox176k418dlgq12f2h42tqs461t6");
		String userDto  = userDao.CallProcedure(map);
		
		model.addAttribute("USER_ID", userDto);
		
		return "select";
	}
}
