package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnSupportedMathOperationException;

@RestController
public class MathController {

			
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnSupportedMathOperationException("Digite um número valido");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/subtration/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtration(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnSupportedMathOperationException("Digite um número válido");
		}
		Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnSupportedMathOperationException("Digite um número válido!");
		}
		Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnSupportedMathOperationException("Digite um número válido!");			
		}
		Double sum = (convertToDouble(numberOne) / convertToDouble(numberTwo));
		return sum;
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnSupportedMathOperationException("Digite um número válido!");			
		}
		Double sum = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		return sum;
	} 
	
	@RequestMapping(value="/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		
		if(!isNumeric(number)) {
			throw new UnSupportedMathOperationException("Digite um número válido!");
		}
		Double sum = Math.sqrt(convertToDouble(number));
		return sum;
	}
	private Double convertToDouble(String strNumber) {

		if(strNumber == null) return 0D; 
			String number = strNumber.replaceAll(",", ".");
		
		if(isNumeric(number)) return Double.parseDouble(number);
			return 0D;
	}

	private boolean isNumeric(String strNumber) {
		
		if(strNumber == null) return false; 
			String number = strNumber.replaceAll(",", ".");
			
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	
}
