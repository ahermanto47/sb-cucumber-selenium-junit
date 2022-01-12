package org.southforestlab.acceptance.controller;

import lombok.Data;

import org.southforestlab.acceptance.service.RandomNumberGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UiController {

	@GetMapping("/random-number-generator")
	public String showForm(Model model) {
		RandomNumberQuery randomNumberQuery = new RandomNumberQuery();
		model.addAttribute("randomNumberQuery", randomNumberQuery);

		return "random-number-generator";
	}

	@PostMapping(value = "/random-number-generator")
	public String generateRandomNumber(@ModelAttribute("randomNumberQuery") final RandomNumberQuery randomNumberQuery) {
		RandomNumberGeneratorService service = new RandomNumberGeneratorService();
		randomNumberQuery.randomNumber = service.generateRandomNumber(randomNumberQuery.min, randomNumberQuery.max);
		return "random-number-generator";
	}

	//@Data
	private static class RandomNumberQuery {
		Integer min = null;
		Integer max = null;
		Integer randomNumber = null;
		public Integer getMin() {
			return min;
		}
		public void setMin(Integer min) {
			this.min = min;
		}
		public Integer getMax() {
			return max;
		}
		public void setMax(Integer max) {
			this.max = max;
		}
		public Integer getRandomNumber() {
			return randomNumber;
		}
		public void setRandomNumber(Integer randomNumber) {
			this.randomNumber = randomNumber;
		}
	}
}
