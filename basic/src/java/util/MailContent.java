package util;

import bean.mail.Mail;

/**
 * 设置邮件内容
 * 
 */
public class MailContent extends Mail {

	public static void main(String[] args) {
		
		Mail mailContent = new Mail();
		mailContent.setMailFrom("shangjianlou@sina.com");//必须与sendMail.setUsername设置一致
		mailContent.setMailTo("jianlou.shang@prnasia.com");
		mailContent.setSubject("test");
		mailContent.setContent(
				"尊敬的先生/女士，您好：<br/><br/>感谢订阅美通社资讯电子刊，我们将一如既往的为您提供相关行业精华资讯。<br/>同时，美通社也欢迎您将喜欢的作品或者您本人的作品推荐给我们，通过美通社资源库及资讯电子刊发布与行业内相关人士分享。<br/>我们将注明作者并有精美礼品相赠<br/><br/>再次感谢您的订阅以及对美通社的关注，期待您的投稿"
);
		
		
		SendMail sendMail=new SendMail();
		sendMail.setSmtp("smtp.sina.com");
		sendMail.setUsername("shangjianlou@sina.com");
		sendMail.setPassword("1x2p3r4n");
		
		sendMail.sendMessage(mailContent);
	}

	
	

	
}