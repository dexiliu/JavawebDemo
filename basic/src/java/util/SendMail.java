package util;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import bean.mail.Mail;



public class SendMail {

	private MimeMessage mimeMsg; // MIME邮件对象

	private Session session; // 邮件会话对象

	private Properties props; // 系统属性

	private boolean needAuth = false; // smtp是否需要认证

	private Multipart mp; // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象

	private String username ; // smtp认证用户名和密码

	private String password ;

	private String _From ;

	private String _To ;

	private String _CC ;
	
	private String _BCC ;
	
	private String _Subject ;
	
	private String smtp; 
	
	

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	public SendMail(){}
	public SendMail(String from, String to, String subject) {
		setSmtpHost();
		createMimeMessage();
		_From = from;
		_To = to;
		_Subject = subject;
	}

	public void setSmtpHost() {
		
		if (props == null)
			props = System.getProperties(); // 获得系统属性对象
		props.put("mail.smtp.host", this.smtp); // 设置SMTP主机
		props.put("username",this.username);
		props.put("password",this.password);
		//props.put("from",this._From);
	}

	public boolean createMimeMessage() {
		try {
			//System.out.println("准备获取邮件会话对象！");
//			/session = Session.getDefaultInstance(props, null); // 获得邮件会话对象
		} catch (Exception e) {
			System.err.println("获取邮件会话对象时发生错误！" + e);
			return false;
		}
		//System.out.println("准备创建MIME邮件对象！");
		try {
			mimeMsg = new MimeMessage(session); // 创建MIME邮件对象
			mp = new MimeMultipart();
			return true;
		} catch (Exception e) {
			System.err.println("创建MIME邮件对象失败！" + e);
			return false;
		}
	}

	public void setNeedAuth(boolean need) {
		//System.out.println("设置smtp身份认证：mail.smtp.auth = " + need);
		if (props == null)
			props = System.getProperties();
		if (need) {
			props.put("mail.smtp.auth", "true");
		} else {
			props.put("mail.smtp.auth", "false");
		}
	}

	public void setNamePass(String name, String pass) {
		username = name;
		password = pass;
	}

	public boolean setSubject(String mailSubject) {
		//System.out.println("设置邮件主题！");
		try {
			mimeMsg.setSubject(mailSubject);
			return true;
		} catch (Exception e) {
			System.err.println("设置邮件主题发生错误！");
			return false;
		}
	}

	public boolean setBody(String mailBody) {
		try {
			BodyPart bp = new MimeBodyPart();
			bp.setContent(
					"<meta http-equiv=Content-Type content=text/html; charset=gb2312>"
							+ mailBody, "text/html;charset=GB2312");
			mp.addBodyPart(bp);
			return true;
		} catch (Exception e) {
			System.err.println("设置邮件正文时发生错误！" + e);
			return false;
		}
	}

	public boolean addFileAffix(String filename) {
		//System.out.println("增加邮件附件：" + filename);
		try {
//			BodyPart bp = new MimeBodyPart();
//			FileDataSource fileds = new FileDataSource(filename);
//			bp.setDataHandler(new DataHandler(fileds));
//			bp.setFileName(fileds.getName());
//			mp.addBodyPart(bp);
			return true;
		} catch (Exception e) {
			System.err.println("增加邮件附件：" + filename + "发生错误！" + e);
			return false;
		}
	}

	public boolean setFrom(String from) {
		//System.out.println("设置发信人！");
		try {
			mimeMsg.setFrom(new InternetAddress(from)); // 设置发信人
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean setTo(String toPerson) {
		if (toPerson == null)
			return false;
		try {
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse(toPerson));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param name
	 *            String
	 * @param pass
	 *            String
	 */
	public boolean sendout() {
		try {			
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			Session mailSession = Session.getInstance(props, null);
			Transport transport = mailSession.getTransport("smtp");
			//transport.connect((String) props.get("mail.smtp.host"), username,	password);
			
			transport.connect((String) props.get("mail.smtp.host"), 
					(String) props.get("username"), 
					(String) props.get("password"));
			System.out.println("user ["+(String) props.get("username")+"] connected to "+(String) props.get("mail.smtp.host"));
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			if (getCc() != null) {
				transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.CC));
			}
			if (getBcc() != null) {
				transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.BCC));
			}
			
			System.out.println("user ["+(String) props.get("username")+"] sent message");
			transport.close();
			//Thread.sleep(10);
			return true;
		} catch (Exception e) {			
			System.err.println("email failed:user="+(String) props.get("username")+",mailServer="+(String) props.get("mail.smtp.host"));
			System.err.println("邮件发送失败！" + e);
			return false;
		}
	}
	
	public void sendMessage(Mail bmb)
	{
		setSmtpHost();
		createMimeMessage();
		_To = bmb.getMailTo();
		_From = bmb.getMailFrom();
		_Subject = bmb.getSubject();
		setNeedAuth(true);
		setSubject(bmb.getSubject());
		setBody(bmb.getContent());		
		setTo(_To);
		//setFrom((String)props.get("from"));				
		setFrom(_From);
		setNamePass(bmb.getSmtpUid(),bmb.getSmtpPW());
		sendout();
	}


	public String get_From() {
		return _From;
	}

	public void set_From(String from) {
		_From = from;
	}

	public String get_To() {
		return _To;
	}

	public void set_To(String to) {
		_To = to;
	}

	public String getBcc() {
		return _BCC;
	}

	public void setBcc(String bcc) {
		_BCC = bcc;
	}

	public String getCc() {
		return _CC;
	}

	public void setCc(String cc) {
		_CC = cc;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
