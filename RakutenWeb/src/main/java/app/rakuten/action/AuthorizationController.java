package app.rakuten.action;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller handle of Authorization process
 * 
 * @author Sergey Ogarkov
 *
 */
@Controller
public class AuthorizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal principal) {
		ModelAndView model = new ModelAndView();
		if (principal != null) {
			String message = String.format("%s have not permission to access to this page!", principal.getName());
			LOGGER.info(message);
			model.addObject("message", message);
		} else {
			model.addObject("message", "You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}

}
