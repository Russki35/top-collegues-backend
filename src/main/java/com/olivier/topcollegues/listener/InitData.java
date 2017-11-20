/**
 * 
 */
package com.olivier.topcollegues.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.olivier.topcollegues.service.Init;



@Component
public class InitData {
	
@Autowired private Init init;
	
	@EventListener ({ContextRefreshedEvent.class})
	void contextRefreshedEvent() {
		init.initCollegue();
	}
}
