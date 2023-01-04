package com.pehtml2pdf.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v107.page.Page;
import org.openqa.selenium.devtools.v107.css.CSS;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class DemoForPeHtmlToPdfApplication {

	public static void main(String[] args) throws IOException {
		String chromeDriverPath = "/Users/yashwinder.kumar/Documents/temp/selenium_chromedriver/chromedriver" ;

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless", "--window-size=1920,1200","--ignore-certificate-errors");
		ChromeDriver chromeDriver = new ChromeDriver(options);
		chromeDriver.getDevTools();

		chromeDriver.get("file:///Users/yashwinder.kumar/Documents/temp/pe.html");

		var params = new HashMap<String, Object>();
		params.put("paperWidth", 210 / 25.4 );
		//params.put("paperHeight", 297 / 25.4 + 0.05 );
		params.put("paperHeight", 297 / 25.4);
		params.put("scale", 0.9);
		//params.put("pageRanges", "1-2" );
		params.put("marginTop",2);
		params.put("marginBottom",4);
//		params.put("marginLeft",0);
//		params.put("marginRight",0);
		params.put("displayHeaderFooter", true);

//class='col';
//style='margin-right:0;
//float='right';
//		String[] cssb;
//		cssb.push('<style>');
//		cssb.push('h1 { font-size:30px;position:absolute;background-color:#f00; z-index:1000;color:#000; margin-left:30px;}');
//		cssb.push('</style>');
//		String cssb = "<style> #col { font-size:30px;position:absolute;background-color:#f00; z-index:1000;color:#000; margin-left:30px} </style>";
		//String fstring = "<style> div.N4r9M {border-style: dotted;}";
		//params.put("footerTemplate", fstring);
		WebElement elem1 = chromeDriver.findElement(By.cssSelector("input#fname"));
		WebElement elem2 = chromeDriver.findElement(By.cssSelector("input#lname"));
		chromeDriver.executeScript("arguments[0].setAttribute('value','Yash')",elem1);
		chromeDriver.executeScript("arguments[0].setAttribute('value','Kumar')",elem2);
		//chromeDriver.findElement(By.id("")).click();
		//WebElement elem3 = chromeDriver.findElement(By.cssSelector("myVar"));
		//chromeDriver.executeScript("arguments[0].setAttribute('value','MYTEXT')",elem3);
		//chromeDriver.findElement(By.id("myVar"));

		String hstring = "<div> <img height=\'80\' width=\'600\' src='data:image/png;base64,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' /> </div>";
		params.put("headerTemplate", hstring);
		//String cssb = "<style> .parent {border: 1px solid black; margin: 1rem; padding: 2rem 2rem; text-align: center; height: 200px; width: 300px;} .child {font-size:20px; display: inline-block; border: 1px solid red; padding: 1rem 1rem; vertical-align: middle; height:90px; width:100px;} #child2{z-index: 1;} </style>";
  		//String ch = "fun";
  		//String fstring = cssb+"<div class='parent'> <div class='child'> Hi!"+ ch + "There. </div> <div class='child' id='child2'>Welcome to Reality. </div> </div>";
		String cssb = "<style> img { float: right;} .child {font-size:20px;}</style>";
		String test = "<div class=\"child\"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. There I tried.</div>";
		String fstring = cssb+"<div> <p> <img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARkAAACzCAMAAACKPpgZAAAA/" +
				"1BMVEUzupz//////P82uJz/+v8wu5z6///8////+/7///4zups2uZj//f42vZ/1//8svZwzu5cmt41KvZ4ltZi+6uDw///7//u05dqd3tD/+P/W+e8pvZjM7+ni/flYxqsyt" +
				"JVsxbJxzrNBtZmR1sR70sHd9+/K8ucrtpCm49YmwZfo/fqy5d42rpEvuqI7tKJLwKaU1MlXvafC5eJevqGm69lFu5iC1r+Q39Gk2czT8PE3qZTm///D7ufg8PTr+/Sj4tl7" +
				"xrghwpJTs52t2cxpvalQs6NdxqDJ7OCc2MOG38FNy6+86OeC4s551MTL+PRVupu98N+L0MlOwJlly7gvqoEhbWXeAAANVklEQVR4nO2aC3faxrbHGY00eg2awSBegxgQBvE0Jra" +
				"xE1PspMlpzqMOOT7f/7PcPQKD3XQ1tzd0pb1n/7pWV4CRtPXXfo5cKCAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiAIgiC/" +
				"IHCCwHGc723GnwuHUqGn6WIxD7KyEKjOE+FI6c7wIWZRnLz6nCoZfG+L/iSIUdZZMcJt27M4cce9kvjeJv1JENkw4tz3/Srg2w3WmmM8Fc5mNMg2jHjMsjknhLjc83hyIcODOJB3RB" +
				"AGgdgRUEcUijqb0uPZEchQSpWzu8pISSc93gV+N7OZc1IhPLJs1rxc1mutGMRxyeBKHXIN1KuUnlCa5uhsBHY7zvvL4eJ4dgRSyjB9ztWVVt/VdZ10xV1IMsl9WCpleroYuA3GyKUs7lc" +
				"URPlzBIwToF9ZpiH4kRoScl0+mhlBqPR18pIhLX79wD+M4GTAfQZOQrVjokap7MblLo87+mmJQwV9DXFGuMEibP35jSPksMrr5eOZHqqTW/4cq3E7P2K4/i6oQx0JwvAGH5RUEcyglBZ" +
				"G4aVlu3ylD+uE/sGv9geG5ppwL7rTIrus+vWy40BgQXAVjGuZw6mzJTBBKBzITQUKPaQw34kAvsu7yd1a89Esyj+N5hFZDw60Xtc1PKtiEQ6DlQEthDKPLjjCXCcwhwkRwof9/UCqOko" +
				"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\" style=\"width:170px;height:170px;\">" +
				""+test+"</p></div>";

		params.put("footerTemplate", fstring);
		String command = "Page.printToPDF";
		Map<String, Object> output = chromeDriver.executeCdpCommand(command, params);

		String outputPath = "/Users/yashwinder.kumar/Documents/temp/hp11.pdf";
		FileOutputStream fileOutputStream = new FileOutputStream(outputPath.toString());
		byte[] byteArray = Base64.getDecoder().decode((String) output.get("data"));
		fileOutputStream.write(byteArray);
		fileOutputStream.close();
		chromeDriver.close();

	}
}

