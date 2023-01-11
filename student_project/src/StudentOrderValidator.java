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
            if (!cityAnswer.success) {
                //continue;
                break;
            }

            AnswerWedding wedAnswer = checkWedding(so);
            AnswerChildren childAnswer = checkChildren(so);
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
        System.out.println("Wedding запущен");
        AnswerWedding ans = new AnswerWedding();
        return ans;
    }
    static AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("ChildrenCheck is running");
        AnswerChildren ans = new AnswerChildren();
        return ans;
    }
    static AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Студенты проверяются");
        AnswerStudent ans = new AnswerStudent();
        return ans;
    }
    static void sendMail(StudentOrder so) {
        System.out.println("Почта отправлена");
    }
}
