package com.scholarbowlquestionproj.scholarbowlquestions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    // Create Question
    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return this.questionRepository.save(question);
    }

    // Get Questions
    @GetMapping
    public List<Question> getQuestion(){
        return this.questionRepository.findAll();
    }

    // Get Question by Type (bonus or full question)
    @GetMapping("/type/{questionType}")
    public ResponseEntity<List<Question>> getQuestionByQuestionType(@PathVariable(value = "questionType") String questionType){
        return new ResponseEntity<List<Question>>(this.questionRepository.findAllByQuestionType(questionType), HttpStatus.OK);
    }

    // Get All Bonus Parts by Packet and Number
    @GetMapping("/bonusbypacketandnumber")
    public ResponseEntity<List<Question>> getBonusByPacketAndQuestionNumber(@RequestParam int packetNumber, @RequestParam int questionNumber){
        List<Question> responseObj = this.questionRepository.findAllByPacketNumberAndQuestionNumber(packetNumber, questionNumber);
        List<Question> returnObj = new ArrayList<Question>();

        for (Question item: responseObj){
            if(item.getQuestionType().equals("bonus")){
                returnObj.add(item);
            }
        }

        return new ResponseEntity<List<Question>> (returnObj, HttpStatus.OK);
    }

    // Get Question by Category (subject)
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable(value = "category") String category){
        return new ResponseEntity<List<Question>>(this.questionRepository.findAllByCategory(category), HttpStatus.OK);
    }

    // Get Question by Packet
    @GetMapping("/packet/{packetNumber}")
    public ResponseEntity<List<Question>> getQuestionByPacket(@PathVariable(value = "packetNumber") int packetNumber){
        return new ResponseEntity<List<Question>>(this.questionRepository.findAllByPacketNumber(packetNumber), HttpStatus.OK);
    }

    // Get Question by Packet and Number
    @GetMapping("/packetandquestionnumber")
    public ResponseEntity<List<Question>> getQuestionByPacketAndQuestionNumber(@RequestParam int packetNumber, @RequestParam int questionNumber){
        return new ResponseEntity<List<Question>>(this.questionRepository.findAllByPacketNumberAndQuestionNumber(packetNumber, questionNumber), HttpStatus.OK);
    }

    // Get Question by Packet and Year
    @GetMapping("/packetandyear")
    public ResponseEntity<List<Question>> getQuestionByPacketAndYear(@RequestParam int packetNumber, @RequestParam int year){
        return new ResponseEntity<List<Question>>(this.questionRepository.findAllByPacketNumberAndYear(packetNumber, year), HttpStatus.OK);
    }

    // Get Question by Packet, Number, and Year
    @GetMapping("/packetandquestionnumberandyear")
    public ResponseEntity<List<Question>> getQuestionByPacketAndQuestionNumberAndYear(@RequestParam int packetNumber, @RequestParam int questionNumber, @RequestParam int year){
        return new ResponseEntity<List<Question>>(this.questionRepository.findAllByPacketNumberAndQuestionNumberAndYear(packetNumber, questionNumber, year), HttpStatus.OK);
    }

    // Get Question by Year
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Question>> getQuestionByYear(@PathVariable(value = "year") int year){
        return new ResponseEntity<List<Question>>(this.questionRepository.findAllByYear(year), HttpStatus.OK);
    }

    // Get Question by ID
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable(value = "id") long questionId){
        return this.questionRepository.findById(questionId)
        .orElseThrow(() -> new ResourceNotFoundException("Question Not Found With ID:" + questionId));
    }

    // Put Question by ID
    @PutMapping("/update/{id}")
    public Question putQuestionById(@RequestBody Question question, @PathVariable(value = "id") long questionId){
        Question exisiting = this.questionRepository.findById(questionId)
        .orElseThrow(() -> new ResourceNotFoundException("Question Not Found With ID:" + questionId));

        exisiting.setPacketNumber(question.getPacketNumber());
        exisiting.setQuestionNumber(question.getQuestionNumber());
        exisiting.setBonusLetter(question.getBonusLetter());
        exisiting.setYear(question.getYear());
        exisiting.setPointValue(question.getPointValue());
        exisiting.setQuestionBody(question.getQuestionBody());
        exisiting.setCategory(question.getCategory());
        exisiting.setQuestionType(question.getQuestionType());
        exisiting.setBonusBeginningQuestion(question.getBonusBeginningQuestion());
        exisiting.setAnswer(question.getAnswer());
        exisiting.setTitle(question.getTitle());
        return this.questionRepository.save(exisiting);
    }

    // Delete Question by ID
    @DeleteMapping("{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable ("id") long questionId){
        Question exisiting = this.questionRepository.findById(questionId)
        .orElseThrow(() -> new ResourceNotFoundException("Question Not Found With ID:" + questionId));

        this.questionRepository.delete(exisiting);

        return ResponseEntity.ok().build();
    }

}
