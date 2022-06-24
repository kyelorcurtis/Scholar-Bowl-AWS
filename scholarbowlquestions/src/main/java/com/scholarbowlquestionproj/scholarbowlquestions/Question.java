package com.scholarbowlquestionproj.scholarbowlquestions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "packet_number", columnDefinition = "int")
    private int packetNumber;
    @Column(name = "question_number", columnDefinition = "int")
    private int questionNumber;
    @Column(name = "bonus_letter", columnDefinition = "text")
    private String bonusLetter;
    @Column(name = "year", columnDefinition = "int")
    private int year;
    @Column(name = "point_value", columnDefinition = "int")
    private int pointValue;
    @Column(name = "question_body", columnDefinition = "text")
    private String questionBody;
    @Column(name = "category", columnDefinition = "text")
    private String category;
    @Column(name = "question_type", columnDefinition = "text")
    private String questionType;
    @Column(name = "bonus_beginning_question", columnDefinition = "text")
    private String bonusBeginningQuestion;
    @Column(name = "answer", columnDefinition = "text")
    private String answer;
    @Column(name = "title", columnDefinition = "text")
    private String title;
    @Column(name = "packetId", columnDefinition = "int")
    private long packetId;

    public Question(){}

    public Question(int packetNumber,long packetId, int questionNumber, String bonusLetter, int year, int pointValue, String questionBody, String title, String category, String questionType, String bonusBeginningQuestion, String answer){
        super();
        this.packetNumber = packetNumber;
        this.questionNumber = questionNumber;
        this.bonusLetter = bonusLetter;
        this.year = year;
        this.pointValue = pointValue;
        this.questionBody = questionBody;
        this.category = category;
        this.questionType = questionType;
        this.bonusBeginningQuestion = bonusBeginningQuestion;
        this.answer = answer;
        this.title = title;
        this.packetId = packetId;
    }

	public long getId() {
		return this.id;
	}

    public void setId(long id) {
        this.id = id;
    }

	public long getPacketId() {
		return this.packetId;
	}

    public void setPacketId(long packetId) {
        this.packetId = packetId;
    }

    public int getPacketNumber() {
        return this.packetNumber;
    }

    public void setPacketNumber(int packetNumber) {
        this.packetNumber = packetNumber;
    }
    public int getQuestionNumber() {
        return this.questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBonusLetter() {
        return this.bonusLetter;
    }

    public void setBonusLetter(String bonusLetter) {
        this.bonusLetter = bonusLetter;
    }

    public int getPointValue() {
        return this.pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public String getQuestionBody() {
        return this.questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBonusBeginningQuestion() {
        return this.bonusBeginningQuestion;
    }

    public void setBonusBeginningQuestion(String bonusBeginningQuestion) {
        this.bonusBeginningQuestion = bonusBeginningQuestion;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
