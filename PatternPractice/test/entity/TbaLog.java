package entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbaLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tba_log", catalog = "hl7")
public class TbaLog implements java.io.Serializable {

	// Fields

	private String opId;
	private String scene;
	private String receiveHl7;
	private String sendXml;
	private String returnXml;
	private String sendHl7;
	private Timestamp receiveHl7Time;
	private Timestamp sendXmlTime;
	private Timestamp returnXmlTime;
	private Timestamp sendHl7Time;

	// Constructors

	/** default constructor */
	public TbaLog() {
	}

	/** minimal constructor */
	public TbaLog(String opId) {
		this.opId = opId;
	}

	/** full constructor */
	public TbaLog(String opId, String scene, String receiveHl7, String sendXml,
			String returnXml, String sendHl7, Timestamp receiveHl7Time,
			Timestamp sendXmlTime, Timestamp returnXmlTime,
			Timestamp sendHl7Time) {
		this.opId = opId;
		this.scene = scene;
		this.receiveHl7 = receiveHl7;
		this.sendXml = sendXml;
		this.returnXml = returnXml;
		this.sendHl7 = sendHl7;
		this.receiveHl7Time = receiveHl7Time;
		this.sendXmlTime = sendXmlTime;
		this.returnXmlTime = returnXmlTime;
		this.sendHl7Time = sendHl7Time;
	}

	// Property accessors
	@Id
	@Column(name = "opId", unique = true, nullable = false, length = 32)
	public String getOpId() {
		return this.opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	@Column(name = "scene", length = 50)
	public String getScene() {
		return this.scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	@Column(name = "receive_hl7")
	public String getReceiveHl7() {
		return this.receiveHl7;
	}

	public void setReceiveHl7(String receiveHl7) {
		this.receiveHl7 = receiveHl7;
	}

	@Column(name = "send_xml")
	public String getSendXml() {
		return this.sendXml;
	}

	public void setSendXml(String sendXml) {
		this.sendXml = sendXml;
	}

	@Column(name = "return_xml")
	public String getReturnXml() {
		return this.returnXml;
	}

	public void setReturnXml(String returnXml) {
		this.returnXml = returnXml;
	}

	@Column(name = "send_hl7")
	public String getSendHl7() {
		return this.sendHl7;
	}

	public void setSendHl7(String sendHl7) {
		this.sendHl7 = sendHl7;
	}

	@Column(name = "receive_hl7_time", length = 19)
	public Timestamp getReceiveHl7Time() {
		return this.receiveHl7Time;
	}

	public void setReceiveHl7Time(Timestamp receiveHl7Time) {
		this.receiveHl7Time = receiveHl7Time;
	}

	@Column(name = "send_xml_time", length = 19)
	public Timestamp getSendXmlTime() {
		return this.sendXmlTime;
	}

	public void setSendXmlTime(Timestamp sendXmlTime) {
		this.sendXmlTime = sendXmlTime;
	}

	@Column(name = "return_xml_time", length = 19)
	public Timestamp getReturnXmlTime() {
		return this.returnXmlTime;
	}

	public void setReturnXmlTime(Timestamp returnXmlTime) {
		this.returnXmlTime = returnXmlTime;
	}

	@Column(name = "send_hl7_time", length = 19)
	public Timestamp getSendHl7Time() {
		return this.sendHl7Time;
	}

	public void setSendHl7Time(Timestamp sendHl7Time) {
		this.sendHl7Time = sendHl7Time;
	}

}