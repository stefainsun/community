package club.stefanie.community.exception;

public class QuestionNotFindException extends Exception{
    public QuestionNotFindException(){
    }
    public QuestionNotFindException(String error){
        super(error);
    }
}
