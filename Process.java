import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;


public class Process {

    UserInput userInput = new UserInput(1);
    LocalDate now = LocalDate.now();
    LocalDate birthdate = LocalDate.of(userInput.getYear(), userInput.getMonth(), userInput.getDay());
    Period p = Period.between(birthdate, now);
    public void yearOutPut() {
        JOptionPane.showMessageDialog(null,"Year ::  " +p.getYears());
    }

    public void monthOutPut() {
        int month = p.getYears()*12;
        month +=p.getMonths();
        JOptionPane.showMessageDialog(null,"Month ::  " +month);
    }

    public void weekOutPut() {
        int week = (int)(getAllDays()/7);
        JOptionPane.showMessageDialog(null, "Week ::  "+week );
    }

    public void dayOutPut() {
        JOptionPane.showMessageDialog(null, "day :: " +getAllDays());
    }

    public int getAllDays() {
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


        int birth = userInput.getMonth();
        int curr = now.getMonth().getValue();
        int bet = 0;
        int day = 0;
        if (birth != curr) {
            if (birth == 12 && curr != birth) {
                birth--;
            }
            int i = curr;
            while (i != (birth + 1)) {
                day += months[i];
                bet++;
                if (i == 12) i = 1;
                i++;
            }
        }
        day += (p.getYears() *365);
        day += p.getDays();
        return day;
    }

    public void showAll (){
        JOptionPane.showMessageDialog(null , "Your age in " +
                "\nYear  :: "+p.getYears()+
                "\nMonth :: "+((p.getYears()*12)+p.getMonths())+
                "\nWeek  :: "+((int)(getAllDays()/7))+
                "\nDays  :: "+getAllDays()
        );

    }
    public void showAgeInDetail(){
        JOptionPane.showMessageDialog(null , p.getYears()+" Years   "+p.getMonths()+" Months   "
                +((int)p.getDays()/7)+" Weeks   "+p.getDays()%7+" Days");
    }

}
