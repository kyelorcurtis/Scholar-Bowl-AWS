package com.scholarbowlquestionproj.scholarbowlquestions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
    
    public List<Question> findAllByYear(int year);

    public List<Question> findAllByPacketNumber(int packetNumber);

    public List<Question> findAllByQuestionType(String questionType);

    public List<Question> findAllByCategory(String category);

    public List<Question> findAllByPacketNumberAndQuestionNumber(int packetNumber, int questionNumber);

    public List<Question> findAllByPacketNumberAndQuestionNumberAndYear(int packetNumber, int questionNumber, int year);

    public List<Question> findAllByPacketNumberAndYear(int packetNumber, int year);
}