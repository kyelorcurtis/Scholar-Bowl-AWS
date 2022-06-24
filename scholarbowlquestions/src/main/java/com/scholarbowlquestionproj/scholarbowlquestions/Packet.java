package com.scholarbowlquestionproj.scholarbowlquestions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "packets")
public class Packet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "packet_number", columnDefinition = "int")
    private int packetNumber;
    @Column(name = "year", columnDefinition = "int")
    private int year;
    @Column(name = "title", columnDefinition = "text")
    private String title;

    public Packet(){}

    public Packet(int packetNumber, int year, String title){
        super();
        this.packetNumber = packetNumber;
        this.year = year;
        this.title = title;
    }

	public long getId() {
		return this.id;
	}

    public void setId(long id) {
        this.id = id;
    }

	public String getTitle() {
		return this.title;
	}

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPacketNumber() {
        return this.packetNumber;
    }

    public void setPacketNumber(int packetNumber) {
        this.packetNumber = packetNumber;
    }
    
}
