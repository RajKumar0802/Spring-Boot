/**
 * 
 */
package io.javaBrains.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 28963
 *
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHai(){
		return "HAI";
	}
}
