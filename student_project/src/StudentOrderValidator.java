public class StudentOrderValidator
{
    public static void main(String[] args) {
        checkAll();
    }
    static void checkAll() {

        while(true) {
            StudentOrder so = readStudentOrder();
           // System.out.println("Start");
            if (so == null) {
                break;
            }
            //System.out.println("Finish");

            AnswerCityRegister cityAnswer = checkCityRegister(so);
            /*if (!cityAnswer.success) {
                //continue;
                break;
            }*/

            AnswerChildren childAnswer = checkChildren(so);
            if (!childAnswer.success) {
                //continue;
                break;
            }


            AnswerWedding wedAnswer = checkWedding(so);
            AnswerStudent studentAnswer = checkStudent(so);

            sendMail(so);
        }
        //System.out.println("Finish2");
    }
    static StudentOrder readStudentOrder() {
        StudentOrder so = new StudentOrder();
        return so;
    }
    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "Host1";
        crv1.login = "Login1";
        crv1.password = "Password1";
        CityRegisterValidator crv2 = new CityRegisterValidator();
        crv2.hostName = "Host2";
        crv2.login = "Login2";
        crv2.password = "Password2";
        AnswerCityRegister ans1 = crv1.checkCityRegister(so);
        AnswerCityRegister ans2 = crv2.checkCityRegister(so);
        return ans1;
    }
    static AnswerWedding checkWedding(StudentOrder so) {
        WeddingValidator wd = new WeddingValidator();
        return wd.checkWedding(so);
    }
    static AnswerChildren checkChildren(StudentOrder so) {
        ChildrenValidator cv = new ChildrenValidator();
        return cv.checkChildren(so);
    }
    static AnswerStudent checkStudent(StudentOrder so) {
        return new StudentValidator().checkStudent(so);
    }
    static void sendMail(StudentOrder so) {
        new MailSender().sendMail(so);
    }
}
