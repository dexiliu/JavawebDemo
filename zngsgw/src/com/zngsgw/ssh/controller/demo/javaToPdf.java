package com.zngsgw.ssh.controller.demo;

import java.awt.Color;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class javaToPdf {

	public static void main(String[] args) {
		 //调用第一个方法，向C盘生成一个名字为ITextTest.pdf 的文件
		  try {
			  writePdf("家庭报告");
		  } 
		  catch (Exception e) { e.printStackTrace(); }
	}
	
	private static Font headfont ;// 设置字体大小 
    private static Font textfont;// 设置字体大小 
    private static String REPORT="2014-2015学年度第二学期业已结束。根据县教育局通知精神，结合本校实际情况，我校决定于xxxx年xx月xx日放寒假，下学期于xxxx年xx月xx日（正月十一）晚回校上自修，xx日正式上课。现将贵子弟初一1班张三同学本学期思想表现和学业成绩向您汇报。希望您在寒假期间教育子弟遵纪守法，遵守社会公德，注意安全，远离“黄、赌、毒”，积极参加有益的社会实践活动，并督促其按时回校上课。请嘱咐贵子弟回校时别忘了将您的寄语带回学校。";
    private static String HEADER="尊敬的学生家长：";
    
    static{ 
        BaseFont bfChinese; 
        try { 
            bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED); 
            headfont = new Font(bfChinese, 11, Font.BOLD,new Color(238, 44, 44));// 设置字体大小、颜色 
            textfont = new Font(bfChinese, 9, Font.NORMAL);// 设置字体大小 
        } catch (Exception e) {          
            e.printStackTrace(); 
        }  
    }
	
	public static  void writePdf(String title) throws Exception{
		//1.新建document对象
		//第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		//2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		//创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		 PdfWriter.getInstance(document, new FileOutputStream("e:\\ITextTest.pdf"));
		//3.打开文档
		document.open();
		//4.向文档中添加内容
		//通过 com.lowagie.text.Paragraph 来添加文本。可以用文本及其默认的字体、颜色、大小等等设置来创建一个默认段落
		Paragraph pt=new Paragraph(title,headfont);//设置字体样式
		pt.setAlignment(1);//设置文字居中 0靠左   1，居中     2，靠右
		document.add(pt);
		document.add(new Paragraph("\n"));
		pt=new Paragraph(HEADER,textfont);
		pt.setAlignment(0);
		document.add(pt);
		pt=new Paragraph(REPORT,textfont);
		pt.setFirstLineIndent(19);
		document.add(pt);
		//5.关闭文档
		document.close();
		}
}
