package com.growskill.exceptionHandler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionFormate {
	
	private LocalDateTime timeStamp;
	private String message;
	private String uri;
	

}
