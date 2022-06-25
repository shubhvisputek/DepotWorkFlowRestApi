package com.aurusinc.depotworkflow.restapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Tickets")
public class Ticket {
	
	@Id
    @Column(name = "TicketID", unique=true)
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ticketID;
	
	@Column(name = "TicketName")
	private String ticketName;
	
	@Column(name = "TicketDescription")
	private String ticketDescription;
	
	@Column(name = "TicketStatus")
	private String ticketStatus;

    @Column(name = "TicketPriority")
	private String ticketPriority;

	@OneToMany(targetEntity=Device.class, mappedBy="ticketID", fetch=FetchType.LAZY, cascade = 
	CascadeType.ALL)
    // @JoinColumn(name = "TicketID", referencedColumnName = "TicketID")
	@Column(name = "Devices")
    private List<Device> devices;

	@Column(name = "DeviceType")
    private String deviceType;

    @Column(name = "PONumber", unique=true)
	private String ponumber;

    @Column(name = "StorageBin")
	private String storageBin;

    @Column(name = "SBOM")
	private String sbom;

    @Column(name = "PartNumber")
	private String partNumber;

    @Column(name = "CorpID")
	private String corpID;

    @Column(name = "CorpName")
	private String corpName;

	@Column(name = "KeysInfo")
    private String keysInfo;
}
