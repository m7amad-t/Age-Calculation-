import javax.swing.*;

public class UserInput {

    private static int year, month, day;
    private static String birthdate;

    public UserInput(int temp ) {

    }
    public UserInput (){
       this.birthdate = JOptionPane.showInputDialog("Input your birth date \n" +
                "\nPlease make sure your Input in this format {DD/MM/YYYY}    ");
       new UserInput( this.birthdate);
    }

    public UserInput(String birthdate) {
        this.birthdate = birthdate;
        try {
            userDay(birthdate);
            userMonth(birthdate);
            userYear(birthdate);
            if ( birthdate.length() == 10 &&birthdate.charAt(2) == '/' && birthdate.charAt(5) == '/') {
                if (getMonth() >= 1 && getMonth() <= 12 && getDay() >= 1 && getDay() <= 31 ) {
                    try {
                        Process p = new Process();
                        int q1 = Integer.parseInt(JOptionPane.showInputDialog("do you want to see your age in ?" +
                                "\n1. in year" +
                                "\n2. in months" +
                                "\n3. in weeks" +
                                "\n4. days" +
                                "\n5. years + months + weeks + days" +
                                "\n6. show all"));
                        if (q1 == 1) {
                            p.yearOutPut();
                        } else if (q1 == 2) {
                            p.monthOutPut();
                        } else if (q1 == 3) {
                            p.weekOutPut();
                        } else if (q1 == 4) {
                            p.dayOutPut();
                        } else if (q1 == 5) {
                            p.showAgeInDetail();
                        } else if (q1 == 6) {
                            p.showAll();
                        } else {
                            JOptionPane.showMessageDialog(null, "You have to put a number between 1 to 6");
                            new UserInput(this.birthdate);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Your Input is wrong, you have to only put a number");
                         new UserInput(this.birthdate);

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "You have been Input wrong date");
                    new UserInput();
                }

            } else {
                JOptionPane.showMessageDialog(null, "You have been Input wrong date");
                new UserInput();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You have been Input wrong date");
            new UserInput();
        }


    }

    private void userDay(String birthdate) {
        String temp = birthdate.charAt(0) + "" + birthdate.charAt(1);
        this.day = Integer.parseInt(temp);
    }

    private void userMonth(String birthdate) {
        String temp = birthdate.charAt(3) + "" + birthdate.charAt(4);
        this.month = Integer.parseInt(temp);
    }

    private void userYear(String birthdate) {
        String temp = "";
        for (int i = 6; i < 10; i++) {
            temp += birthdate.charAt(i) + "";
        }
        this.year = Integer.parseInt(temp);
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }


}
