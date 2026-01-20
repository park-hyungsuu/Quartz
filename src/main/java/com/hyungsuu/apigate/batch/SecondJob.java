package com.hyungsuu.apigate.batch;

import java.util.HashMap;

import org.quartz.Job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyungsuu.apigate.samaple.service.UserService;
import com.hyungsuu.apigate.samaple.vo.UserResVo;
import com.hyungsuu.common.config.WebConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SecondJob implements Job { 

	@Autowired
    private UserService userService;

@Override
public void execute(JobExecutionContext context) throws JobExecutionException {
	// TODO Auto-generated method stub
	UserResVo userResVo = new UserResVo();
	HashMap<String, Object> userMap = new HashMap<String, Object>();
	userMap.put("userId", "yjEcumJ2VN");
	userMap.put("userPasswd", "ABC12345");
	try {
		userResVo = userService.selectUser(userMap);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info("FirstJob ==> {}",userResVo.toString());
	
}

}