package app.rakuten.action;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application root page.
 */
@Controller
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "redirect:/products";
	}
	
}
