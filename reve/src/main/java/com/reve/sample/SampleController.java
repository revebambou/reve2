package com.reve.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author reve
 *
 */
@Controller
public class SampleController {

	@RequestMapping("/sample")
	@ResponseBody // @ResponseBody is required, because of returning String words
	// if @ResponseBody is not added, error is occurred: There was an unexpected error (type=Not Found, status=404).
	public String sample() {
		return "reve";
	}
}
