package code.practice.jerry.dtos;

//@Getter
//@Setter
public class JerryCheersResponse {

    private String message;

    public JerryCheersResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JerryCheersResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
