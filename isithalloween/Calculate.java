public class Calculate {
    
    private String result;
    
    public Calculate (String month, int day) {
        if (month.equals("OCT") && day == 31) {
            this.result = "yup";
        } else if (month.equals("DEC") && day == 25) {
            this.result = "yup";
        } else {
            this.result = "nope";
        }
    }
    
    public String getResult() {
        return this.result;
    }
}