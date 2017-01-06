package bean.mail;


import java.util.Date;


/**
 * 邮件对象的基类，定义了邮件对象的基本属性
 * @author ptwang
 *
 
 */
public class Mail
{
	/**
	 * 邮件内容类型常量：纯文本
	 */
	public static final String CONTENT_TYPE_TEXT = "text/plain";
	/**
	 * 邮件内容类型常量：Html
	 */
	public static final String CONTENT_TYPE_HTML = "text/html";
	/**
	 * 邮件内容类型常量：Xml
	 */
	public static final String CONTENT_TYPE_XML = "text/xml";

	/**
	 * 邮件内容类型
	 */
	private String contentType = CONTENT_TYPE_TEXT;

	/**
	 * 邮件发送地址
	 */
	private String strMailTo = "";

	/**
	 * 邮件CC地址
	 */
	private String strMailCc = "";

	/**
	 * 邮件BCC地址
	 */
	private String strMailBcc = "";
	
	/**
	 * 邮件发送地址
	 */
	private String strMailFrom = "";

	/**
	 * 发件人姓名
	 */
	private String strSenderName = "";

	/**
	 * 收件人姓名
	 */
	private String strReceiverName = "";

	/**
	 * 发件日期
	 */
	private Date dtSendDate = null;

	/**
	 * 邮件标题
	 */
	private String strSubject = "";
	/**
	 * 邮件正文
	 */
	private String strContent = "";
    
	/**
	 * 发送人邮件帐户名 
	 */
	private String smtpUid = "";

	/**
	 * 发送人邮件帐户密码 
	 */
	private String smtpPw = "";
	
	public String getSmtpUid() {
		return smtpUid;
	}

	public void setSmtpUid(String name) {
		this.smtpUid = name;
	}

	public String getSmtpPW() {
		return smtpPw;
	}

	public void setSmtpPw(String pass) {
		this.smtpPw = pass;
	}

	/**
	 * Returns the dtSendDate.
	 * @return Date
	 */
	public Date getSendDate()
	{
        //hbli change in 20041015
        if (dtSendDate == null)
        {
            dtSendDate = new Date(System.currentTimeMillis());
        }
		return dtSendDate;
	}

	/**
	 * Returns the contentType.
	 * @return long
	 */
	public String getContentType()
	{
		return contentType;
	}

	/**
	 * Returns the content.
	 * @return String
	 */
	public String getContent()
	{
        return this.getContent(this.contentType);         
	}

	/**
	 * Returns the receiverName.
	 * @return String
	 */
	public String getReceiverName()
	{
		return strReceiverName;
	}

	/**
	 * Returns the senderName.
	 * @return String
	 */
	public String getSenderName()
	{
		return strSenderName;
	}

	/**
	 * Returns the subject.
	 * @return String
	 */
	public String getSubject()
	{
		return this.strSubject;
	}

	/**
	 * Sets the dtSendDate.
	 * @param dtSendDate The dtSendDate to set
	 */
	public void setSendDate(Date dtSendDate)
	{
		this.dtSendDate = dtSendDate;
	}

	/**
	 * Sets the contentType.
	 * @param contentType The contentType to set
	 */
	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}
    

    /**
     * @return
     */
    public String getMailFrom()
    {
        return this.strMailFrom;
    }

    /**
     * @param mailFrom
     */
    public void setMailFrom(String mailFrom)
    {
        this.strMailFrom = mailFrom;
    }

    /**
     * @return
     */
    public String getMailTo()
    {
        return this.strMailTo;
    }

    /**
     * @param mailTo
     */
    public void setMailTo(String mailTo)
    {
        this.strMailTo = mailTo;
    }

    /**
     * @return
     */
    public String getMailCc()
    {
        return this.strMailCc;
    }

    /**
     * @param mailCc
     */
    public void setMailCc(String mailCc)
    {
        this.strMailCc = mailCc;
    }
    
    /**
     * @return
     */
    public String getMailBcc()
    {
        return this.strMailBcc;
    }

    /**
     * @param mailBcc
     */
    public void setMailBcc(String mailBcc)
    {
        this.strMailBcc = mailBcc;
    }
    
    /**
	 * Sets the content.
	 * @param content The content to set
	 */
	public void setContent(String content)
	{
		strContent = content;
	}

	/**
	 * Sets the receiverName.
	 * @param receiverName The receiverName to set
	 */
	public void setReceiverName(String receiverName)
	{
		strReceiverName = receiverName;
	}

	/**
	 * Sets the senderName.
	 * @param senderName The senderName to set
	 */
	public void setSenderName(String senderName)
	{
		strSenderName = senderName;
	}

	/**
	 * Sets the subject.
	 * @param subject The subject to set
	 */
	public void setSubject(String subject)
	{
		strSubject = subject;
	}

	/**
    /**
     * @param strContentType 可以为BaseMailBean.CONTENT_TYPE_TEXT
      *                             BaseMailBean.CONTENT_TYPE_XML
     * return String
     */
	public final String getContent(String strContentType)
	{
        Date dTemp = new Date();
        dTemp.setTime(System.currentTimeMillis());
        this.setSendDate(dTemp);
        
		if (CONTENT_TYPE_HTML.equalsIgnoreCase(strContentType)) {
			return this.strContent;
			
		} else if (CONTENT_TYPE_XML.equalsIgnoreCase(strContentType)) {
            return this.toXml();
            
		} else {
            return this.toText();
		}
	}

	/**
	 * 将Content转为Xml格式
	 * @return String
	 */
	protected String toXml()
	{
		return this.strContent;
	}

    /**
     * 将Content转为Text格式
     * @return String
     */
    protected String toText()
    {
        return this.strContent;
    }
}
